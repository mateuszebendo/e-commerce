package org.br.serratec.ecommerce.dtos;

public class CategoriaDTO {

	private Integer categoriaId;
	private String nome;
	private String descricao;

	public CategoriaDTO() {

	}

	public CategoriaDTO(Integer categoriaId, String nome, String descricao) {
		this.categoriaId = categoriaId;
		this.nome = nome;
		this.descricao = descricao;
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
