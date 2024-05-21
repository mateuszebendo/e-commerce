package org.br.serratec.ecommerce.dtos;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.br.serratec.ecommerce.entities.Cliente;

public record PedidoDTO(
		LocalDateTime dataPedido,
		LocalDate dataEntrega,
		LocalDate dataEnvio,
		String status,
		Double valorTotal,
		Cliente cliente
		) {}
