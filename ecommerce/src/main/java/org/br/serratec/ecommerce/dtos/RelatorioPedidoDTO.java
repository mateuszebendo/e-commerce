package org.br.serratec.ecommerce.dtos;

import java.time.LocalDateTime;
import java.util.List;

import org.br.serratec.ecommerce.entities.ItemPedido;
import org.br.serratec.ecommerce.entities.Pedido;

public class RelatorioPedidoDTO {

	private Integer pedidoId;
	private LocalDateTime dataPedido;
	private Double valorTotal;

	private List<ItemPedido> itensPedido;

	public RelatorioPedidoDTO(){
	}

	public RelatorioPedidoDTO(Pedido pedido) {
		this.pedidoId = pedido.getPedidoId();
		this.dataPedido = pedido.getDataPedido();
		this.valorTotal = pedido.getValorTotal();
		this.itensPedido = pedido.getItensPedido();
	}

	public Integer getPedidoId() {
		return pedidoId;
	}

	public void setPedidoId(Integer pedidoId) {
		this.pedidoId = pedidoId;
	}

	public LocalDateTime getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(LocalDateTime dataPedido) {
		this.dataPedido = dataPedido;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public List<ItemPedido> getItensPedido() {
		return itensPedido;
	}

	public void setItensPedido(List<ItemPedido> itensPedido) {
		this.itensPedido = itensPedido;
	}

	@Override
	public String toString() {
		return "RelatorioPedidoDTO{" +
				"pedidoId=" + pedidoId +
				", dataPedido=" + dataPedido +
				", valorTotal=" + valorTotal +
				", itensPedido=" + itensPedido.toString()+
				'}';
	}
}
