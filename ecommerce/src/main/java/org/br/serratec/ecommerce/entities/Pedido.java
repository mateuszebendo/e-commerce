package org.br.serratec.ecommerce.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.br.serratec.ecommerce.dtos.PedidoDTO;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "pedido")
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pedido_id")
	private Integer pedidoId;

	@Column(name = "data_pedido")
	private LocalDateTime dataPedido;

	@Column(name = "data_entrega")
	private LocalDate dataEntrega;

	@Column(name = "data_envio")
	private LocalDate dataEnvio;

	@Column(name = "status")
	private String status;

	@Column(name = "valor_total")
	private Double valorTotal;

	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;

	@JsonIgnore
	@ManyToMany
	@JoinTable(
	    name = "pedido_item_pedido",
	    joinColumns = @JoinColumn(name = "pedido_id"),
	    inverseJoinColumns = @JoinColumn(name = "item_pedido_id")
	)
	private List<ItemPedido> itensPedido;

	public Pedido() {
	}

	public Pedido(PedidoDTO pedidoDTO) {
		this.dataPedido = LocalDateTime.now();
		this.dataEntrega = pedidoDTO.dataEntrega();
		this.dataEnvio = pedidoDTO.dataEnvio();
		this.status = pedidoDTO.status();
		this.valorTotal = pedidoDTO.valorTotal();
		this.cliente = pedidoDTO.cliente();
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