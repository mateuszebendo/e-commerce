package org.br.serratec.ecommerce.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "categoria")
public class Categoria {

	@Id
	@Column(name="categoria_id")
	private Integer categoriaId;

	@Column(name="nome")
	private String nome;

	@Column(name="descricao")
	private String descricao;

	public Categoria() {
	}

	public Categoria(Integer categoriaId, String nome, String descricao) {
		this.categoriaId = categoriaId;
		this.nome = nome;
		this.descricao = descricao;
	}

	public Integer getCategoriaId() {
		return categoriaId;
	}

	public void setCategoriaId(Integer idCategoria) {
		this.categoriaId = categoriaId;
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
