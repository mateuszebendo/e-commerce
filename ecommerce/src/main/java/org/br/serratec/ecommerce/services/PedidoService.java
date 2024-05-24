package org.br.serratec.ecommerce.services;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.br.serratec.ecommerce.dtos.PedidoDTO;
import org.br.serratec.ecommerce.entities.Pedido;
import org.br.serratec.ecommerce.exceptions.EntidadeNotFoundException;
import org.br.serratec.ecommerce.repositories.PedidoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {

	@Autowired
	PedidoRepository pedidoRepository;

	@Autowired
	ModelMapper modelMapper;

	public PedidoDTO save(PedidoDTO pedidoDTO) {
		Pedido pedido = pedidoRepository.save(new Pedido(pedidoDTO));
		PedidoDTO newPedidoDTO = modelMapper.map(pedido, PedidoDTO.class);
		return newPedidoDTO;
	}

	public PedidoDTO update(PedidoDTO pedidoDTO) {
		Integer pedidoId = pedidoDTO.getPedidoId();
		Pedido pedido = pedidoRepository.findById(pedidoId).orElseThrow(
				() -> new EntidadeNotFoundException("Não foi encontrado nenhum Pedido com Id " + pedidoId));

		pedidoRepository.save(modelMapper.map(pedidoDTO, Pedido.class));
		PedidoDTO newPedidoDTO = modelMapper.map(pedido, PedidoDTO.class);
		return newPedidoDTO;
	}

	public PedidoDTO findById(Integer id) {
		Pedido pedido = pedidoRepository.findById(id)
				.orElseThrow(() -> new EntidadeNotFoundException("Não foi encontrado nenhum Pedido com Id " + id));
		PedidoDTO newPedidoDTO = modelMapper.map(pedido, PedidoDTO.class);
		return newPedidoDTO;
	}

	public List<PedidoDTO> findAll() {
		List<Pedido> listaPedido = pedidoRepository.findAll();
		if(listaPedido.isEmpty()) {
			throw new NoSuchElementException("Nenhum pedido encontrado.");
		}
		List<PedidoDTO> listaPedidoDTO = new ArrayList<>();
		for (Pedido pedido : listaPedido) {
			PedidoDTO pedidoDTO = modelMapper.map(pedido, PedidoDTO.class);
			listaPedidoDTO.add(pedidoDTO);
		}
		return listaPedidoDTO;
	}

	public PedidoDTO deleteById(Integer id) {
		Pedido pedido = pedidoRepository.findById(id)
				.orElseThrow(() -> new EntidadeNotFoundException("Não foi encontrado nenhum Pedido com Id " + id));
		PedidoDTO newPedidoDTO = modelMapper.map(pedido, PedidoDTO.class);
		pedidoRepository.delete(pedido);
		return newPedidoDTO;
	}
}