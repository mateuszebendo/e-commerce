package org.br.serratec.ecommerce.services;

import java.util.ArrayList;
import java.util.List;

import org.br.serratec.ecommerce.dtos.PedidoDTO;
import org.br.serratec.ecommerce.entities.Pedido;
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

	public PedidoDTO findById(Integer id) {
        Pedido pedido = pedidoRepository.findById(id).orElse(null);
        PedidoDTO newPedidoDTO;
        newPedidoDTO = modelMapper.map(pedido, PedidoDTO.class);
        return newPedidoDTO;
	}

	public List<PedidoDTO> findAll(){

		List<Pedido> listaPedido = pedidoRepository.findAll();
		List<PedidoDTO> listaPedidoDTO = new ArrayList<>();
		for(Pedido pedido : listaPedido) {
			PedidoDTO pedidoDTO = modelMapper.map(pedido, PedidoDTO.class);
			listaPedidoDTO.add(pedidoDTO);
		}
		return listaPedidoDTO;
	}

	public PedidoDTO update(PedidoDTO pedidoDTO) {
		Pedido pedido = pedidoRepository.save(modelMapper.map(pedidoDTO, Pedido.class));
		PedidoDTO newPedidoDTO;
		newPedidoDTO = modelMapper.map(pedido, PedidoDTO.class);
		return newPedidoDTO;
	}

	public PedidoDTO deleteById (Integer id){
		Pedido pedido = pedidoRepository.findById(id).orElse(null);
		PedidoDTO newPedidoDTO = modelMapper.map(pedido, PedidoDTO.class);
		if(pedido != null) {
			pedidoRepository.delete(pedido);
			return newPedidoDTO;
		}
		return newPedidoDTO;
    }
}
