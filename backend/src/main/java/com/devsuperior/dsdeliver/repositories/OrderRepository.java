package com.devsuperior.dsdeliver.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.dsdeliver.entities.Order;

//Faz parte do subframework data.jpa, que traz implementações padrões para salvar, implementar, etc
//todas as operaçoes básicas para acessar o banco de dados relacionado a entidade
//<Entidade, Tipo da chave privária da entidade> 
public interface OrderRepository extends JpaRepository<Order, Long> {

	//Método personalizado pra retornar somente os pedidos pendentes e que estejam ordenados por instante ( do mais antigo para o mais recente)
	@Query("SELECT DISTINCT obj FROM Order obj JOIN FETCH obj.products"
			+ " WHERE obj.status=0"
			+ " ORDER BY obj.moment ASC ")//Linguagem jpql
	List<Order> findOrdersWithProducts();
	
}


