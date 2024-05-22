package org.br.serratec.ecommerce.dtos;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.br.serratec.ecommerce.entities.Cliente;

public class PedidoDTO{
	private Integer pedidoId;
	private LocalDateTime dataPedido;
	private LocalDate dataEntrega;
	private LocalDate dataEnvio;
	private String status;
	private Double valorTotal;
	private Cliente cliente;

	public PedidoDTO() {
	}

	public PedidoDTO(Integer pedidoId, LocalDateTime dataPedido, LocalDate dataEntrega, LocalDate dataEnvio, String status,
			Double valorTotal, Cliente cliente) {
		super();
		this.pedidoId = pedidoId;
		this.dataPedido = dataPedido;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
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


}