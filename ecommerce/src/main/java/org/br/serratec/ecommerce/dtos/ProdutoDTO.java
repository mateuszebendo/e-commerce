package org.br.serratec.ecommerce.dtos;

import org.br.serratec.ecommerce.entities.Categoria;
import org.br.serratec.ecommerce.entities.Imagem;

import java.time.LocalDateTime;

public class ProdutoDTO {
	private Integer produtoId;
	private String nome;
	private String descricao;
	private Integer qtdEstoque;
	private LocalDateTime dataCadastro;
	private Double valorUnitario;
	private Categoria categoria;
	private Imagem imagem;



	public ProdutoDTO() {
	}

	public ProdutoDTO(String nome, String descricao, Integer qtdEstoque, LocalDateTime dataCadastro,
			Double valorUnitario, Categoria categoria, Imagem imagem) {
		this.nome = nome;
		this.descricao = descricao;
		this.qtdEstoque = qtdEstoque;
		this.dataCadastro = dataCadastro;
		this.valorUnitario = valorUnitario;
		this.categoria = categoria;
		this.imagem = imagem;

	}


	public Integer getProdutoId() {
		return produtoId;
	}

	public void setProdutoId(Integer produtoId) {
		this.produtoId = produtoId;
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

	public Integer getQtdEstoque() {
		return qtdEstoque;
	}

	public void setQtdEstoque(Integer qtdEstoque) {
		this.qtdEstoque = qtdEstoque;
	}

	public LocalDateTime getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDateTime dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Double getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(Double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Imagem getImagem() {
		return imagem;
	}

	public void setImagem(Imagem imagem) {
		this.imagem = imagem;
	}
}
