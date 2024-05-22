package org.br.serratec.ecommerce.dtos;

import java.time.LocalDate;

public class RelatorioPedidoDTO {
	private Integer pedidoId;
	private LocalDate dataPedido;
	private Double valorTotal;
	private Integer itemPedidoId;
	private String produto;
	private Double precoVenda;
	private Integer quantidade;
	private Double valorBruto;
	private Double valorLiquido;
	private Double percentualDesconto;

	public RelatorioPedidoDTO() {
		super();
	}

	public RelatorioPedidoDTO(Integer pedidoId, LocalDate dataPedido, Double valorTotal, Integer itemPedidoId,
			String produto, Double precoVenda, Integer quantidade, Double valorBruto, Double valorLiquido,
			Double percentualDesconto) {
		super();
		this.pedidoId = pedidoId;
		this.dataPedido = dataPedido;
		this.valorTotal = valorTotal;
		this.itemPedidoId = itemPedidoId;
		this.produto = produto;
		this.precoVenda = precoVenda;
		this.quantidade = quantidade;
		this.valorBruto = valorBruto;
		this.valorLiquido = valorLiquido;
		this.percentualDesconto = percentualDesconto;
	}

	public Integer getPedidoId() {
		return pedidoId;
	}

	public void setPedidoId(Integer pedidoId) {
		this.pedidoId = pedidoId;
	}

	public LocalDate getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(LocalDate dataPedido) {
		this.dataPedido = dataPedido;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Integer getItemPedidoId() {
		return itemPedidoId;
	}

	public void setItemPedidoId(Integer itemPedidoId) {
		this.itemPedidoId = itemPedidoId;
	}

	public String getProduto() {
		return produto;
	}

	public void setProduto(String produto) {
		this.produto = produto;
	}

	public Double getPrecoVenda() {
		return precoVenda;
	}

	public void setPrecoVenda(Double precoVenda) {
		this.precoVenda = precoVenda;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
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

	public Double getPercentualDesconto() {
		return percentualDesconto;
	}

	public void setPercentualDesconto(Double percentualDesconto) {
		this.percentualDesconto = percentualDesconto;
	}

	@Override
	public String toString() {
		return "RelatorioPedidoDTO [pedidoId=" + pedidoId + ", dataPedido=" + dataPedido + ", valorTotal=" + valorTotal
				+ ", itemPedidoId=" + itemPedidoId + ", produto=" + produto + ", precoVenda=" + precoVenda
				+ ", quantidade=" + quantidade + ", valorBruto=" + valorBruto + ", valorLiquido=" + valorLiquido
				+ ", percentualDesconto=" + percentualDesconto + "]";
	}

}
