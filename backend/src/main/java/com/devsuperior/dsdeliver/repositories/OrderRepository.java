package com.devsuperior.dsdeliver.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.dsdeliver.entities.Order;

//Faz parte do subframework data.jpa, que traz implementações padrões para salvar, implementar, etc
//todas as operaçoes básicas para acessar o banco de dados relacionado a entidade
//<Entidade, Tipo da chave privária da entidade> 
public interface OrderRepository extends JpaRepository<Order, Long> {

}
