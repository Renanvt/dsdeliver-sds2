package com.devsuperior.dsdeliver.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	//end-point pra salvar
	@PostMapping
	public ResponseEntity<OrderDTO> insert(@RequestBody OrderDTO dto){
		//RequestBody - Converte o json em objeto java do tipo dto
		dto = service.insert(dto);
		
		//return ResponseEntity.ok().body(dto);
		//Chamada para criar a uri que corresponde o recurso que eu criei, para retornar a mensagem correta
		//.path -> caminho do recurso criado (/orders/{id}
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(dto.getId()).toUri();
		
	return ResponseEntity.created(uri).body(dto);
	
	}
}

