package org.br.serratec.ecommerce.dtos;

import org.br.serratec.ecommerce.entities.Categoria;

import java.time.LocalDateTime;

public class ProdutoDTO {
    private Integer produtoId;
    private String nomeDescricao;
    private Integer qtdEstoque;
    private LocalDateTime dataCadastro;
    private Double valorUnitario;
    private Categoria categoria;

    public ProdutoDTO() {
    }

    public ProdutoDTO(String nomeDescricao, Integer qtdEstoque, LocalDateTime dataCadastro, Double valorUnitario, Categoria categoria) {
        this.nomeDescricao = nomeDescricao;
        this.qtdEstoque = qtdEstoque;
        this.dataCadastro = dataCadastro;
        this.valorUnitario = valorUnitario;
        this.categoria = categoria;
    }
    
    

    public Integer getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(Integer produtoId) {
        this.produtoId = produtoId;
    }

    public String getNomeDescricao() {
        return nomeDescricao;
    }

    public void setNomeDescricao(String nomeDescricao) {
        this.nomeDescricao = nomeDescricao;
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

}
