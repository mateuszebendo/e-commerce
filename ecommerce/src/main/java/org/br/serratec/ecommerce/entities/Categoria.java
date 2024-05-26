package org.br.serratec.ecommerce.entities;

import jakarta.persistence.*;
import org.br.serratec.ecommerce.dtos.CategoriaDTO;


@Entity
@Table(name = "categoria")
public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="categoria_id")
	private Integer categoriaId;

	@Column(name="nome")
	private String nome;

	@Column(name="descricao")
	private String descricao;

	public Categoria() {
	}

	public Categoria(CategoriaDTO categoriaDTO) {
		this.categoriaId = categoriaDTO.getCategoriaId();
		this.nome = categoriaDTO.getNome();
		this.descricao = categoriaDTO.getDescricao();
	}

	public Integer getCategoriaId() {
		return categoriaId;
	}

	public void setCategoriaId(Integer categoriaId) {
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
