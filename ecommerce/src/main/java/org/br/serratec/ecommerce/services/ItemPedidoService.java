package org.br.serratec.ecommerce.services;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.br.serratec.ecommerce.dtos.ItemPedidoDTO;
import org.br.serratec.ecommerce.dtos.ProdutoDTO;
import org.br.serratec.ecommerce.entities.ItemPedido;
import org.br.serratec.ecommerce.exceptions.EntidadeNotFoundException;
import org.br.serratec.ecommerce.repositories.ItemPedidoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemPedidoService {

	@Autowired
	ItemPedidoRepository itemPedidoRepository;

	@Autowired
	ProdutoService produtoService;

	@Autowired
	PedidoService pedidoService;

	@Autowired
	ModelMapper modelMapper;

	public ItemPedidoDTO save(ItemPedidoDTO itemPedidoDTO) {
		ItemPedido newItemPedido = new ItemPedido(itemPedidoDTO);
		ProdutoDTO produto = produtoService.findById(newItemPedido.getProduto().getProdutoId());

		newItemPedido.setPrecoVenda(produto.getValorUnitario());
		double valorBruto = newItemPedido.getPrecoVenda() * newItemPedido.getQuantidade();
		newItemPedido.setValorBruto(valorBruto);
		double valorLiquido = newItemPedido.getValorBruto() - (newItemPedido.getValorBruto() * newItemPedido.getPercentualDesconto() / 100);
		newItemPedido.setValorLiquido(valorLiquido);

		var pedido = pedidoService.findById(itemPedidoDTO.getPedido().getPedidoId());
		if( pedido.getValorTotal() != null) {
			pedido.setValorTotal(pedido.getValorTotal() + valorLiquido);
		}
		else {
			pedido.setValorTotal(valorLiquido);
		}
		pedidoService.update(pedido);

		itemPedidoRepository.save(newItemPedido);
		ItemPedidoDTO newItemPedidoDTO = modelMapper.map(newItemPedido, ItemPedidoDTO.class);
		return newItemPedidoDTO;
	}

	public ItemPedidoDTO update(ItemPedidoDTO itemPedidoDTO) {
		Integer itemPedidoId = itemPedidoDTO.getItemPedidoId();
		itemPedidoRepository.findById(itemPedidoId).orElseThrow(
				() -> new EntidadeNotFoundException("Não foi encontrado nenhum Item-Pedido com Id " + itemPedidoId));
		ItemPedido itemPedido = modelMapper.map(itemPedidoDTO, ItemPedido.class);
		ProdutoDTO produto = produtoService.findById(itemPedido.getProduto().getProdutoId());
		itemPedido.setPrecoVenda(produto.getValorUnitario());
		double valorBruto = itemPedido.getPrecoVenda() * itemPedido.getQuantidade();
		itemPedido.setValorBruto(valorBruto);
		double valorLiquido = itemPedido.getValorBruto() - (itemPedido.getValorBruto() * itemPedido.getPercentualDesconto() / 100);
		itemPedido.setValorLiquido(valorLiquido);

		itemPedidoRepository.save(itemPedido);
		ItemPedidoDTO newItemPedidoDTO = modelMapper.map(itemPedido, ItemPedidoDTO.class);
		return newItemPedidoDTO;
	}

	public ItemPedidoDTO findById(Integer id) {
		ItemPedido itemPedido = itemPedidoRepository.findById(id)
				.orElseThrow(() -> new EntidadeNotFoundException("Não foi encontrado nenhum Item-Pedido com Id " + id));
		ItemPedidoDTO newItemPedidoDTO = modelMapper.map(itemPedido, ItemPedidoDTO.class);
		return newItemPedidoDTO;
	}

	public List<ItemPedidoDTO> findAll() {
		List<ItemPedido> listaItemPedido = itemPedidoRepository.findAll();
		if(listaItemPedido.isEmpty()) {
			throw new NoSuchElementException("Nenhum Item-Pedido encontrado.");
		}
		List<ItemPedidoDTO> ListItemPedidoDTO = new ArrayList<>();
		for (ItemPedido itemPedido : listaItemPedido) {
			ItemPedidoDTO itemDTOLista = modelMapper.map(itemPedido, ItemPedidoDTO.class);
			ListItemPedidoDTO.add(itemDTOLista);
		}
		return ListItemPedidoDTO;
	}

	public ItemPedidoDTO deleteById(Integer id) {
		ItemPedido itemPedido = itemPedidoRepository.findById(id)
				.orElseThrow(() -> new EntidadeNotFoundException("Não foi encontrado nenhum Item-Pedido com Id " + id));
		itemPedidoRepository.deleteById(id);

		var pedido = pedidoService.findById(itemPedido.getPedido().getPedidoId());
		pedido.setValorTotal(pedido.getValorTotal() - itemPedido.getValorLiquido());
		pedidoService.update(pedido);

		ItemPedidoDTO newItemPedidoDTO = modelMapper.map(itemPedido, ItemPedidoDTO.class);
		return newItemPedidoDTO;
	}
}
