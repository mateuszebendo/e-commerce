package org.br.serratec.ecommerce.entities;


import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.*;
import org.br.serratec.ecommerce.dtos.ProdutoDTO;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "produto")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "produto_id")
    private Integer produtoId;

    @Column(name = "nome")
    private String nome;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "qtd_estoque")
    private Integer qtdEstoque;

    @Column(name = "data_cadastro")
    private LocalDateTime dataCadastro;

    @Column(name = "valor_unitario")
    private Double valorUnitario;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    @OneToOne(fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn
    private Imagem imagem;

    @JsonIgnore
    @OneToMany(mappedBy = "produto")
    private List<ItemPedido> itemPedido;

    public Produto() {
    }

    public Produto(ProdutoDTO produtoDto) {
        this.nome = produtoDto.getNome();
        this.descricao = produtoDto.getDescricao();
        this.qtdEstoque = produtoDto.getQtdEstoque();
        this.dataCadastro = LocalDateTime.now();
        this.valorUnitario = produtoDto.getValorUnitario();
        this.categoria = produtoDto.getCategoria();
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

    public List<ItemPedido> getItemPedido() {
        return itemPedido;
    }

    public void setItemPedido(List<ItemPedido> itemPedido) {
        this.itemPedido = itemPedido;
    }


    public Imagem getImagem() {
        return imagem;
    }

    public void setImagem(Imagem imagem) {
        this.imagem = imagem;
    }
    @Override
    public String toString() {
        return "Produto{" +
                "nome='" + nome + '\'' +
                ", produtoId=" + produtoId +
                '}';
    }
}
