package com.devsuperior.dsdeliver.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dsdeliver.dto.ProductDTO;
import com.devsuperior.dsdeliver.services.ProductService;

//Controlador REST
@RestController
@RequestMapping(value = "/products") //Define o caminho do recurso
public class ProductController {
	//Injetar a dependência
	@Autowired
	private ProductService service;
	
	//Fazendo o end-point
	@GetMapping
	public ResponseEntity<List<ProductDTO>> findAll(){ //Encapsula uma resposta de uma requisição HTTP
		List<ProductDTO> list = service.findAll();
		//retorna um objeto do tipo ResponseEntity
		return ResponseEntity.ok().body(list);
	}
	}

