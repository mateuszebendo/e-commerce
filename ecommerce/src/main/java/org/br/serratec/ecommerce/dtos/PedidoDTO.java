package org.br.serratec.ecommerce.dtos;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.br.serratec.ecommerce.entities.Cliente;
import org.br.serratec.ecommerce.entities.ItemPedido;
import org.br.serratec.ecommerce.enums.StatusPedidoEnum;

public class PedidoDTO{
	private Integer pedidoId;
	private LocalDateTime dataPedido;
	private LocalDate dataEntrega;
	private LocalDate dataEnvio;
	private StatusPedidoEnum status;
	private Double valorTotal;
	private Cliente cliente;
	private List<ItemPedido> itensPedido;

	public PedidoDTO() {
	}

	public PedidoDTO(LocalDate dataEntrega, LocalDate dataEnvio, StatusPedidoEnum status,
					 Double valorTotal, Cliente cliente) {
		this.dataEntrega = dataEntrega;
		this.dataEnvio = dataEnvio;
		this.status = status;
		this.valorTotal = valorTotal;
		this.cliente = cliente;
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

	public LocalDate getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(LocalDate dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	public LocalDate getDataEnvio() {
		return dataEnvio;
	}

	public void setDataEnvio(LocalDate dataEnvio) {
		this.dataEnvio = dataEnvio;
	}

	public StatusPedidoEnum getStatus() {
		return status;
	}

	public void setStatus(StatusPedidoEnum status) {
		this.status = status;
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
}