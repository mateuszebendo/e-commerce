package org.br.serratec.ecommerce.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.br.serratec.ecommerce.dtos.ItemPedidoDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Item_pedido")
public class ItemPedido {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "item_pedido_id")
	private Integer itemPedidoId;

	@Column(name = "quatidade")
	private Double quantidade;

	@Column(name = "preco_venda")
	private Double precoVenda;

	@Column(name = "percentual_desconto")
	private Double percentualDesconto;

	@Column(name = "valor_bruto")
	private Double valorBruto;

	@Column(name = "valor_liquido")
	private Double valorLiquido;

	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "pedido_id")
	private Pedido pedido;

	@ManyToOne
	@JoinColumn(name = "produto_id")
	private Produto produto;

	public ItemPedido() {
	}

	public ItemPedido(ItemPedidoDTO itemPedidoDTO) {
		this.itemPedidoId = itemPedidoDTO.getItemPedidoId();
		this.produto = itemPedidoDTO.getProduto();
		this.pedido = itemPedidoDTO.getPedido();
		this.valorLiquido = itemPedidoDTO.getValorLiquido();
		this.valorBruto = itemPedidoDTO.getValorBruto();
		this.percentualDesconto = itemPedidoDTO.getPercentualDesconto();
		this.precoVenda = itemPedidoDTO.getPrecoVenda();
		this.quantidade = itemPedidoDTO.getQuantidade();
	}

	public Integer getItemPedidoId() {
		return itemPedidoId;
	}

	public void setItemPedidoId(Integer itemPedidoId) {
		this.itemPedidoId = itemPedidoId;
	}

	public Double getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Double quantidade) {
		this.quantidade = quantidade;
	}

	public Double getPrecoVenda() {
		return precoVenda;
	}

	public void setPrecoVenda(Double precoVenda) {
		this.precoVenda = precoVenda;
	}

	public Double getPercentualDesconto() {
		return percentualDesconto;
	}

	public void setPercentualDesconto(Double percentualDesconto) {
		this.percentualDesconto = percentualDesconto;
	}

	public Double getValorBruto() {
		return valorBruto;
	}

	public void setValorBruto(Double valorBruto) {
		this.valorBruto = valorBruto;
	}

	public Double getValorLiquido() {
		return valorLiquido;
	}

	public void setValorLiquido(Double valorLiquido) {
		this.valorLiquido = valorLiquido;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
}