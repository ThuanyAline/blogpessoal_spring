package com.generation.blogpessoal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.blogpessoal.model.Postagem;
import com.generation.blogpessoal.respository.PostagemRepository;

@RestController
@RequestMapping("/postagens") // Define o endpoint base para as requisições
@CrossOrigin(origins = "*", allowedHeaders = "*") // Permite requisições de qualquer origem
public class PostagemController {

	@Autowired // Injeta a dependência do repositório de postagens
	private PostagemRepository postagemRepository; // Repositório para operações CRUD com postagens
   
	@GetMapping // Mapeia requisições GET para este método
	public ResponseEntity<List<Postagem>> getAll(){
           return ResponseEntity.ok(postagemRepository.findAll());
      
           // SELECT * FROM tb_postagens
	
	}

	
}