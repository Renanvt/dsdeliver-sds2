package com.devsuperior.dsdeliver.services;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import com.devsuperior.dsdeliver.dto.OrderDTO;
import com.devsuperior.dsdeliver.dto.ProductDTO;
import com.devsuperior.dsdeliver.entities.Order;
import com.devsuperior.dsdeliver.entities.OrderStatus;
import com.devsuperior.dsdeliver.entities.Product;
import com.devsuperior.dsdeliver.repositories.OrderRepository;
import com.devsuperior.dsdeliver.repositories.ProductRepository;



//Componente que será injetado no controlador
//Objeto da camada de servico
//O serviço chama o repository(camada de acesso a dados)


@Service //Registra o componente
public class OrderService {
	//Ter uma instancia do ProductRepository disponível no Productservice
	// não é uma boa prática -> private ProductRepository repository = new ...;
	/*
	//Injeção de dependência desaclopada
	public productService(ProductRepository repository) {
		this.repository = repository;
	}
	*/
	
	@Autowired //Faz a resolução da dependência de forma transparente
	private OrderRepository repository;
	
	@Autowired
	private ProductRepository productRepository;

	
	//Função para retornar uma lista de produtos
	
	//readOnly = true-> operação não faz o lock de escrita no banco, deixando a operação mais rápida
	@Transactional(readOnly = true) //Garanti a transação e fechamento com o banco
	public List<OrderDTO> findAll(){
		List<Order> list = repository.findOrdersWithProducts();
		//Transformar cada elemento de product para productDTO
		return list.stream().map(x -> new OrderDTO(x)).collect(Collectors.toList());
	}
	
	//Inserir no banco de dados um novo pedido associados com os seus pedidos
	//O objeto DTO que é o pedido vai conter todos os dados do pedido e os produtos desse pedido
	@Transactional
	public OrderDTO insert(OrderDTO dto){
		//Salvar o objeto no banco
		Order order = new Order(null,dto.getAddress(),dto.getLatitude(), dto.getLongitude(), 
				Instant.now(), OrderStatus.PENDING);
		
		//Percorre todos os ProductsDTOS
		for(ProductDTO p : dto.getProducts()) {
			//associar os produtos com o pedido
			//getOne -> instancia um produto sem ir no banco de dados, criando uma entidade
			//gerenciada pelo jpa para que quando salve a entidade, tambem salva  todas as suas associações
			Product product = productRepository.getOne(p.getId());
			order.getProducts().add(product);
		}
		//Feito isso eu vou ter o order com os seus dados básicos + os produtos associados a eles
		//salvando o produto no banco
		order = repository.save(order);
		return new OrderDTO(order);
	}
	
	@Transactional
	public OrderDTO setDelivered(Long id){
		//Instanciando na memória um pedido, monitorado pelo jpa
		Order order = repository.getOne(id);
		order.setStatus(OrderStatus.DELIVERED);
		order = repository.save(order);
		return new OrderDTO(order);
	}
	
	
	
}
