package org.br.serratec.ecommerce.services;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.br.serratec.ecommerce.dtos.ItemPedidoDTO;
import org.br.serratec.ecommerce.dtos.PedidoDTO;
import org.br.serratec.ecommerce.dtos.RelatorioPedidoDTO;
import org.br.serratec.ecommerce.entities.Cliente;
import org.br.serratec.ecommerce.entities.ItemPedido;
import org.br.serratec.ecommerce.entities.Pedido;
import org.br.serratec.ecommerce.entities.StatusPedidoEnum;
import org.br.serratec.ecommerce.exceptions.EntidadeNotFoundException;
import org.br.serratec.ecommerce.repositories.ClienteRepository;
import org.br.serratec.ecommerce.repositories.ItemPedidoRepository;
import org.br.serratec.ecommerce.repositories.PedidoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {

	@Autowired
	PedidoRepository pedidoRepository;

	@Autowired
	ClienteRepository clienteRepository;

	@Autowired
	ItemPedidoRepository itemPedidoRepository;

	@Autowired
	EmailService emailService;

	@Autowired
	ModelMapper modelMapper;

	public PedidoDTO save(PedidoDTO pedidoDTO) {
		Pedido pedido = new Pedido(pedidoDTO);
		pedidoRepository.save(pedido);
		PedidoDTO newPedidoDTO = modelMapper.map(pedido, PedidoDTO.class);
		return newPedidoDTO;
	}

	public RelatorioPedidoDTO criaRelatorio (Integer id){
		Pedido pedido = pedidoRepository.findById(id).orElseThrow(
				() -> new EntidadeNotFoundException("Não foi encontrado nenhum Pedido com Id " + id));
		var relatorioPedido = modelMapper.map(pedido, RelatorioPedidoDTO.class);
		return relatorioPedido;
	}

	public PedidoDTO update(PedidoDTO pedidoDTO) {
		Integer pedidoId = pedidoDTO.getPedidoId();
		Pedido pedido = pedidoRepository.findById(pedidoId).orElseThrow(
				() -> new EntidadeNotFoundException("Não foi encontrado nenhum Pedido com Id " + pedidoId));

//		Double valorTotal = 0.0;
//		if(pedidoDTO.getItensPedido() != null) {
//			for(ItemPedido itemPedido: pedido.getItensPedido()) {
//				valorTotal += itemPedido.getValorLiquido();
//			}
//			pedido.setValorTotal(valorTotal);
//		}
		var cliente = clienteRepository.findById(pedido.getCliente().getClienteId()).get();
		List<ItemPedido> itemPedidos = new ArrayList<>();
		for (ItemPedido itemPedido : itemPedidoRepository.findAll()) {
			if(itemPedido.getPedido().getPedidoId() == pedidoId) itemPedidos.add(itemPedido);
		}

		pedidoDTO.setCliente(cliente);
		pedidoDTO.setItensPedido(itemPedidos);

	    pedidoRepository.save(modelMapper.map(pedidoDTO, Pedido.class));


		if(pedidoDTO.getStatus().equals(StatusPedidoEnum.REALIZADO)){
			RelatorioPedidoDTO relatorio = criaRelatorio(pedidoDTO.getPedidoId());
			System.out.println(relatorio.toString());
			emailService.enviarEmail(pedido.getCliente().getEmail(), "RELATÓRIO DO SEU PEDIDO", relatorio.toString());
		}


		return modelMapper.map(pedido, PedidoDTO.class);
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