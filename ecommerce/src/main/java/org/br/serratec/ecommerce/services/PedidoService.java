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
		PedidoDTO newPedidoDTO;
		newPedidoDTO = modelMapper.map(pedido, PedidoDTO.class);
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
			PedidoDTO pedidoDTO = modelMapper.map(listaPedidoDTO, PedidoDTO.class);
			listaPedidoDTO.add(pedidoDTO);
		}
		return listaPedidoDTO;
	}

	public Pedido update(PedidoDTO pedidoDTO) {
		return pedidoRepository.save(new Pedido(pedidoDTO));
	}

	public PedidoDTO deleteById (Integer id){
        Pedido pedido = pedidoRepository.findById(id).orElse(null);
        PedidoDTO newPedidoDTO;
        newPedidoDTO = modelMapper.map(pedido, PedidoDTO.class);
        return newPedidoDTO;
    }

}
