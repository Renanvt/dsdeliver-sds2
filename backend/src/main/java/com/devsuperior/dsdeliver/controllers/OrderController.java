package com.devsuperior.dsdeliver.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dsdeliver.dto.OrderDTO;
import com.devsuperior.dsdeliver.services.OrderService;

//Controlador REST
@RestController
@RequestMapping(value = "/orders") //Define o caminho do recurso
public class OrderController {
	//Injetar a dependência
	@Autowired
	private OrderService service;
	
	//Fazendo o end-point
	@GetMapping
	public ResponseEntity<List<OrderDTO>> findAll(){ //Encapsula uma resposta de uma requisição HTTP
		List<OrderDTO> list = service.findAll();
		//retorna um objeto do tipo ResponseEntity
		return ResponseEntity.ok().body(list);
	}
	}

