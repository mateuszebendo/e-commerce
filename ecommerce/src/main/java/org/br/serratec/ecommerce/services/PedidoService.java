package org.br.serratec.ecommerce.services;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.br.serratec.ecommerce.dtos.PedidoDTO;
import org.br.serratec.ecommerce.dtos.RelatorioPedidoDTO;
import org.br.serratec.ecommerce.entities.ItemPedido;
import org.br.serratec.ecommerce.entities.Pedido;
import org.br.serratec.ecommerce.enums.StatusPedidoEnum;
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
	EmailService emailService;

	@Autowired
	ModelMapper modelMapper;

	public PedidoDTO save(PedidoDTO pedidoDTO) {
		Pedido pedido = new Pedido(pedidoDTO);
		pedido.setStatus(StatusPedidoEnum.ABERTO);
		pedidoRepository.save(pedido);
		PedidoDTO newPedidoDTO = modelMapper.map(pedido, PedidoDTO.class);
		return newPedidoDTO;
	}

	public PedidoDTO findById(Integer id) {
		Pedido pedido = pedidoRepository.findById(id)
				.orElseThrow(() -> new EntidadeNotFoundException("Não foi encontrado nenhum Pedido com Id " + id));
		PedidoDTO newPedidoDTO = modelMapper.map(pedido, PedidoDTO.class);
		newPedidoDTO.setItensPedido(new ArrayList<>(pedido.getItensPedido()));
		return newPedidoDTO;
	}

	public List<PedidoDTO> findAll() {
		List<Pedido> listaPedido = pedidoRepository.findAll();
		if (listaPedido.isEmpty()) {
			throw new NoSuchElementException("Nenhum pedido encontrado.");
		}
		List<PedidoDTO> listaPedidoDTO = new ArrayList<>();
		for (Pedido pedido : listaPedido) {
			if (!pedido.getStatus().equals(StatusPedidoEnum.CANCELADO)) {
				PedidoDTO pedidoDTO = modelMapper.map(pedido, PedidoDTO.class);
				pedidoDTO.setItensPedido(new ArrayList<>(pedido.getItensPedido()));
				listaPedidoDTO.add(pedidoDTO);
			}
		}
		return listaPedidoDTO;
	}

	public PedidoDTO updateDataEntrega(PedidoDTO pedidoDTO) {
		Integer pedidoId = pedidoDTO.getPedidoId();
		Pedido pedido = pedidoRepository.findById(pedidoId).orElseThrow(
				() -> new EntidadeNotFoundException("Não foi encontrado nenhum Pedido com Id " + pedidoId));
		if(pedido.getDataPedido() == null && pedido.getDataEnvio() == null){
			throw new NullPointerException("Ocorreu um erro: Pedido não realizado ou enviado.");
		}
		pedido.setDataEntrega(pedidoDTO.getDataEntrega());
		pedido.setStatus(StatusPedidoEnum.FINALIZADO);
		pedidoRepository.save(pedido);

		return modelMapper.map(pedido, PedidoDTO.class);
	}

	public PedidoDTO update(PedidoDTO pedidoDTO) {
		Integer pedidoId = pedidoDTO.getPedidoId();
		Pedido pedido = pedidoRepository.findById(pedidoId).orElseThrow(
				() -> new EntidadeNotFoundException("Não foi encontrado nenhum Pedido com Id " + pedidoId));

		if (pedidoDTO.getStatus().equals(StatusPedidoEnum.REALIZADO) && !pedido.getItensPedido().isEmpty()) {
			pedido.setDataPedido(pedidoDTO.getDataPedido());
			pedido.setStatus(pedidoDTO.getStatus());

			Double valorTotal = 0.0;
			for (ItemPedido itemPedido : pedido.getItensPedido()) {
				valorTotal += itemPedido.getValorLiquido();
			}
			pedido.setValorTotal(valorTotal);

			RelatorioPedidoDTO relatorio = modelMapper.map(pedido, RelatorioPedidoDTO.class);
			emailService.enviarEmail(pedido.getCliente().getEmail(), "RELATÓRIO DO SEU PEDIDO", relatorio.toString());

		} else if (pedido.getItensPedido().isEmpty()) {
			throw new NullPointerException("Não é possivel criar um pedido sem itens");
		}

		if (pedidoDTO.getDataEnvio() != null) {
			if(pedido.getDataPedido() == null) {
				throw new NullPointerException("Ocorreu um erro: Pedido não realizado");
			}else {
				pedido.setDataEnvio(pedidoDTO.getDataEnvio());
				pedido.setStatus(StatusPedidoEnum.ENVIADO);
			}
		}

		pedidoRepository.save(pedido);
		return modelMapper.map(pedido, PedidoDTO.class);
	}

	public PedidoDTO deleteById(Integer id) {
		Pedido pedido = pedidoRepository.findById(id)
				.orElseThrow(() -> new EntidadeNotFoundException("Não foi encontrado nenhum Pedido com Id " + id));
		PedidoDTO newPedidoDTO = modelMapper.map(pedido, PedidoDTO.class);
		pedidoRepository.delete(pedido);
		return newPedidoDTO;
	}

	public PedidoDTO cancelaPedido(Integer id) {
		Pedido pedido = pedidoRepository.findById(id)
				.orElseThrow(() -> new EntidadeNotFoundException("Não foi encontrado nenhum Pedido com Id " + id));
		pedido.setStatus(StatusPedidoEnum.CANCELADO);
		return modelMapper.map(pedido, PedidoDTO.class);
	}
}