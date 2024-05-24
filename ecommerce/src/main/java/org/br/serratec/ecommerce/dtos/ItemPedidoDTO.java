package org.br.serratec.ecommerce.dtos;

import org.br.serratec.ecommerce.entities.Pedido;
import org.br.serratec.ecommerce.entities.Produto;

public class ItemPedidoDTO {
	private Integer itemPedidoId;
	private Double quantidade;
	private Double precoVenda;
	private Double percentualDesconto;
	private Double valorBruto;
	private Double valorLiquido;
	private Pedido pedido;
	private Produto produto;

	public ItemPedidoDTO() {
	}

	public ItemPedidoDTO(Integer itemPedidoId, Double quantidade, Double precoVenda, Double percentualDesconto,
			Double valorBruto, Double valorLiquido, Pedido pedido, Produto produto) {
		this.itemPedidoId = itemPedidoId;
		this.quantidade = quantidade;
		this.precoVenda = precoVenda;
		this.percentualDesconto = percentualDesconto;
		this.valorBruto = valorBruto;
		this.valorLiquido = valorLiquido;
		this.pedido = pedido;
		this.produto = produto;
	}

	public Integer getItemPedidoId() {
		return itemPedidoId;
	}

	public void setId(Integer itemPedidoId) {
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
