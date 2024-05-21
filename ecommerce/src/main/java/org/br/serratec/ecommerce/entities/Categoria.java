package org.br.serratec.ecommerce.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Id;

public class Categoria {

	@Id
	@Column(name="id_categoria")
	private Integer idCategoria;
	
	@Column(name="nome")
	private String nome;
	
	@Column(name="descricao")
	private String descricao;

	public Categoria() {
		super();
	}

	public Categoria(Integer idCategoria, String nome, String descricao) {
		super();
		this.idCategoria = idCategoria;
		this.nome = nome;
		this.descricao = descricao;
	}

	public Integer getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(Integer idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
