package org.br.serratec.ecommerce.dtos;

import java.time.LocalDateTime;
import java.util.List;

import org.br.serratec.ecommerce.entities.Cliente;
import org.br.serratec.ecommerce.entities.ItemPedido;
import org.br.serratec.ecommerce.entities.Pedido;

import javax.xml.crypto.Data;

public class RelatorioPedidoDTO {

	private Integer pedidoId;
	private LocalDateTime dataPedido;
	private Double valorTotal;
	private Cliente cliente;
	private List<ItemPedido> itensPedido;

	public RelatorioPedidoDTO(){
	}

	public RelatorioPedidoDTO(Integer pedidoId, LocalDateTime dataPedido, Double valorTotal, Cliente cliente, List<ItemPedido> itensPedido) {
		this.pedidoId = pedidoId;
		this.dataPedido = dataPedido;
		this.valorTotal = valorTotal;
		this.cliente = cliente;
		this.itensPedido = itensPedido;
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

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<ItemPedido> getItensPedido() {
		return itensPedido;
	}

	public void setItensPedido(List<ItemPedido> itensPedido) {
		this.itensPedido = itensPedido;
	}

	@Override
	public String toString() {
		var itensStr = new StringBuilder();
		for (ItemPedido item : itensPedido) {
			itensStr.append(item.toString()).append("\n");
		}

		return String.format(
				"========================================================\n" +
						"Data do Pedido : %s\n" +
						"Valor Total    : R$ %.2f\n" +
						"--------------------------------------------------------\n" +
						"%s" +
						"========================================================\n" +
						"%s" +
						"========================================================\n",
				dataPedido,
				valorTotal,
				cliente.toString(),
				itensStr.toString()
		);
	}
}

