package com.generation.blogpessoal.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.generation.blogpessoal.model.Postagem;
import com.generation.blogpessoal.respository.PostagemRepository;

import jakarta.validation.Valid;

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

	@GetMapping("/{id}") // Mapeia requisições GET com um ID específico
	public ResponseEntity<Postagem> getById(@PathVariable Long id) {
		return postagemRepository.findById(id)
				.map(postagem -> ResponseEntity.ok(postagem)) // Se encontrado, retorna 200 OK com a postagem
				.orElse(ResponseEntity.notFound().build()); // Se não encontrado, retorna 404 Not Found
	
	// SELECT * FROM tb_postagens WHERE id = {id}
	}
	
	@GetMapping("/titulo/{titulo}") // Mapeia requisições GET com um título específico")
	public ResponseEntity<List<Postagem>> getByTitulo(@PathVariable String titulo) {
		return ResponseEntity.ok(postagemRepository.findAllByTituloContainingIgnoreCase(titulo));
 
}
	@PostMapping
	public ResponseEntity<Postagem> post(@Valid @RequestBody Postagem postagem){
        postagem.setId(null); // Garante que o ID seja nulo para criar uma nova postagem
		
		return ResponseEntity.status(HttpStatus.CREATED).body(postagemRepository.save(postagem)); //
	
	}
	
	@PutMapping
	public ResponseEntity<Postagem> put(@Valid @RequestBody Postagem postagem){
  		
		return postagemRepository.findById(postagem.getId())
				.map(resposta -> ResponseEntity.status(HttpStatus.OK) // Se encontrado, atualiza e retorna 200 OK)
				      .body(postagemRepository.save(postagem))) // Salva a postagem no banco de dados)
				 .orElse(ResponseEntity.notFound().build()); // Se não encontrado, retorna 404 Not Found
}
	@ResponseStatus(HttpStatus.NO_CONTENT)// Indica que a resposta será 204 No Content
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
	
	    Optional<Postagem> postagem = postagemRepository.findById(id);
	
	    
	    if(postagem.isEmpty())
        	throw new ResponseStatusException(HttpStatus.NOT_FOUND);

	    postagemRepository.deleteById(id);
	
	}
	
}