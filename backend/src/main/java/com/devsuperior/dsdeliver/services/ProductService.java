package com.devsuperior.dsdeliver.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dsdeliver.dto.ProductDTO;
import com.devsuperior.dsdeliver.entities.Product;
import com.devsuperior.dsdeliver.repositories.ProductRepository;



//Componente que será injetado no controlador
//Objeto da camada de servico
//O serviço chama o repository(camada de acesso a dados)


@Service //Registra o componente
public class ProductService {
	//Ter uma instancia do ProductRepository disponível no Productservice
	// não é uma boa prática -> private ProductRepository repository = new ...;
	/*
	//Injeção de dependência desaclopada
	public productService(ProductRepository repository) {
		this.repository = repository;
	}
	*/
	
	@Autowired //Faz a resolução da dependência de forma transparente
	private ProductRepository repository;

	
	//Função para retornar uma lista de produtos
	
	//readOnly = true-> operação não faz o lock de escrita no banco, deixando a operação mais rápida
	@Transactional(readOnly = true) //Garanti a transação e fechamento com o banco
	public List<ProductDTO> findAll(){
		List<Product> list = repository.findAllByOrderByNameAsc();
		//Transformar cada elemento de product para productDTO
		return list.stream().map(x -> new ProductDTO(x)).collect(Collectors.toList());
	}
}
