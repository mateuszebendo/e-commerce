package org.br.serratec.ecommerce.entities;


import jakarta.persistence.*;
import org.br.serratec.ecommerce.dtos.ProdutoDTO;

import java.time.LocalDateTime;

@Entity
@Table(name = "produto")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "produto_id")
    private Integer produtoId;

    @Column(name = "nome_descricao")
    private String nomeDesgricao;

    @Column(name = "qtd_estoque")
    private Integer qtdEstoque;

    @Column(name = "data_cadastro")
    private LocalDateTime dataCadastro;

    @Column(name = "valor_unitario")
    private Double valorUnitario;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    public Produto() {
    }

    public Produto(ProdutoDTO produtoDto) {
        this.nomeDesgricao = produtoDto.nomeDescricao();
        this.qtdEstoque = produtoDto.qtdEstoque();
        this.dataCadastro = produtoDto.dataCadastro();
        this.valorUnitario = produtoDto.valorUnitario();
        this.categoria = produtoDto.categoria();
    }

    public Integer getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(Integer produtoId) {
        this.produtoId = produtoId;
    }

    public String getNomeDesgricao() {
        return nomeDesgricao;
    }

    public void setNomeDesgricao(String nomeDesgricao) {
        this.nomeDesgricao = nomeDesgricao;
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
