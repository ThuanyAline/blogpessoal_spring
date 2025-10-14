package com.generation.blogpessoal.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity // Indica que esta classe é uma entidade JPA
@Table(name = "tb_postagens") // Mapeia a entidade para a tabela "tb_postagens"
public class Postagem {

	@Id // Indica que este campo é a chave primária
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Gera o valor do ID automaticamente
	private Long id; // Identificador único da postagem
	
	@Column(length = 100) // Define o tamanho máximo da coluna no banco de dados
	@NotBlank(message = "O atributo título é obrigatório") // Indica que o campo não pode ser nulo ou vazio
	@Size(min = 5, max = 100, message = "O atributo título deve conter no mínimo 05 e no máximo 100 caracteres") // Restringe o tamanho do campo)
	private String titulo; // Título da postagem
	
	@Column(length = 1000) // Define o tamanho máximo da coluna no banco de dados
	@NotBlank(message = "O atributo texto é obrigatório")
	@Size(min = 10, max = 500, message = "O atributo texto deve conter no mínimo 10 e no máximo 1000 caracteres")
	private String texto; // Conteúdo da postagem
	
	@UpdateTimestamp // Atualiza automaticamente o campo com a data e hora atuais ao atualizar a entidade
	private LocalDateTime data; // Data e hora da postagem
	
	public Long getId() { // Getter para o ID
		return id; // Retorna o ID da postagem
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public LocalDateTime getData() {
		return data;
	}
	public void setData(LocalDateTime data) {
		this.data = data;
	}
}
