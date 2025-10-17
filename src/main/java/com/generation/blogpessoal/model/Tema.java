package com.generation.blogpessoal.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity // Indica que esta classe é uma entidade JPA
@Table(name = "tb_temas") // Mapeia a entidade para a tabela "tb_tema"
public class Tema {

	@Id // Indica que este campo é a chave primária
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Gera o valor do ID automaticamente
	private Long id; // Identificador único da postagem

	@Column(length = 100)
	@NotBlank(message = "Por favor insira um tema válido ")
	@Size(max = 100, min = 5, message = "Descrição deve conter no mínimo 5 e no máximo 100 caracteres")
	private String descricao;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tema", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties(value = "tema", allowSetters = true)
	private List<Postagem> postagem;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Postagem> getPostagem() {
		return postagem;
	}

	public void setPostagem(List<Postagem> postagem) {
		this.postagem = postagem;
	}

}
