package org.br.serratec.ecommerce.entities;

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

	public Integer getItemPedidoID() {
		return itemPedidoId;
	}

	public void setItemPedidoID(Integer itemPedidoId) {
		this.itemPedidoId = itemPedidoId;
	}

	public double getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(double quantidade) {
		this.quantidade = quantidade;
	}

	public double getPrecoVenda() {
		return precoVenda;
	}

	public void setPrecoVenda(double precoVenda) {
		this.precoVenda = precoVenda;
	}

	public double getPercentualDesconto() {
		return percentualDesconto;
	}

	public void setPercentualDesconto(double percentualDesconto) {
		this.percentualDesconto = percentualDesconto;
	}

	public double getValorBruto() {
		return valorBruto;
	}

	public void setValorBruto(double valorBruto) {
		this.valorBruto = valorBruto;
	}

	public double getValorLiquido() {
		return valorLiquido;
	}

	public void setValorLiquido(double valorLiquido) {
		this.valorLiquido = valorLiquido;
	}

	public Pedido getPedidos() {
		return pedido;
	}

	public void setPedidos(Pedido pedido) {
		this.pedido = pedido;
	}

	public Produto getProdutos() {
		return produto;
	}

	public void setProdutos(Produto produto) {
		this.produto = produto;
	}
}