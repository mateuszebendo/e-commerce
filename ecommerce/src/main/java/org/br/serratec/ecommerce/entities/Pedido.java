package org.br.serratec.ecommerce.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.br.serratec.ecommerce.dtos.PedidoDTO;
import org.br.serratec.ecommerce.enums.StatusPedidoEnum;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.FutureOrPresent;


@Entity
@Table(name = "pedido")
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pedido_id")
	private Integer pedidoId;

	@Column(name = "data_pedido")
	private LocalDateTime dataPedido;

	@FutureOrPresent
	@Column(name = "data_entrega")
	private LocalDate dataEntrega;

	@FutureOrPresent
	@Column(name = "data_envio")
	private LocalDate dataEnvio;

	@Enumerated(EnumType.STRING)
	@Column(name = "status")
	private StatusPedidoEnum status;

	@Column(name = "valor_total")
	private Double valorTotal;

	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;

	@JsonIgnore
	@OneToMany(mappedBy="pedido",  fetch = FetchType.EAGER)
	private List<ItemPedido> itensPedido;

	public Pedido() {
	}

	public Pedido(PedidoDTO pedidoDTO) {
		this.dataPedido = LocalDateTime.now();
		this.dataEntrega = pedidoDTO.getDataEntrega();
		this.dataEnvio = pedidoDTO.getDataEnvio();
		this.status = pedidoDTO.getStatus();
		this.valorTotal = pedidoDTO.getValorTotal();
		this.cliente = pedidoDTO.getCliente();
	}

	public Integer getPedidoId() {
		return pedidoId;
	}

	public Pedido(Integer pedidoId, LocalDateTime dataPedido, LocalDate dataEntrega, LocalDate dataEnvio,
			StatusPedidoEnum status, Double valorTotal, Cliente cliente, List<ItemPedido> itensPedido) {
		super();
		this.pedidoId = pedidoId;
		this.dataPedido = dataPedido;
		this.dataEntrega = dataEntrega;
		this.dataEnvio = dataEnvio;
		this.status = status;
		this.valorTotal = valorTotal;
		this.cliente = cliente;
		this.itensPedido = itensPedido;
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

	@Override
	public String toString() {
		return "Pedido{" +
				"pedidoId=" + pedidoId +
				", dataPedido=" + dataPedido +
				", dataEntrega=" + dataEntrega +
				", dataEnvio=" + dataEnvio +
				", status=" + status +
				", valorTotal=" + valorTotal +
				", cliente=" + cliente +
				", itensPedido=" + itensPedido +
				'}';
	}

	public void setItensPedido(List<ItemPedido> itensPedido) {
		this.itensPedido = itensPedido;
	}
}