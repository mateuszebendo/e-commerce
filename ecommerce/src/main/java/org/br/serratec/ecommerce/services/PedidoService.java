package org.br.serratec.ecommerce.services;

import org.br.serratec.ecommerce.dtos.PedidoDTO;
import org.br.serratec.ecommerce.entities.Pedido;
import org.br.serratec.ecommerce.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {

	@Autowired
	PedidoRepository pedidoRepository;

	public Pedido save(PedidoDTO pedidoDTO) {

		return pedidoRepository.save(new Pedido(pedidoDTO));
	}
}
