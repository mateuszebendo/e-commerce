package org.br.serratec.ecommerce.services;

import java.util.ArrayList;
import java.util.List;

import org.br.serratec.ecommerce.dtos.ClienteDTO;
import org.br.serratec.ecommerce.dtos.ItemPedidoDTO;
import org.br.serratec.ecommerce.dtos.ProdutoDTO;
import org.br.serratec.ecommerce.entities.Cliente;
import org.br.serratec.ecommerce.entities.ItemPedido;
import org.br.serratec.ecommerce.entities.Produto;
import org.br.serratec.ecommerce.repositories.ClienteRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
	
	@Autowired
	ClienteRepository clienteRepository;

	@Autowired
	ModelMapper modelMapper;

	public ClienteDTO save(ClienteDTO clienteDto) {
		Cliente clienteSalvo = clienteRepository.save(new Cliente(clienteDto));
		ClienteDTO clienteDtoSalvo;
		clienteDtoSalvo = modelMapper.map(clienteSalvo, ClienteDTO.class);
		return clienteDtoSalvo;

	}
	public List<ClienteDTO> findAll() {
		List<Cliente> clientes = clienteRepository.findAll();
		List<ClienteDTO> clientesDto = new ArrayList<>();
		for (Cliente cliente : clientes) {
			ClienteDTO clienteDtoEncontrado = modelMapper.map(cliente, ClienteDTO.class);
			clientesDto.add(clienteDtoEncontrado);
		}
		return clientesDto;
	}

	public ClienteDTO findById(Integer id) {
		Cliente cliente = clienteRepository.findById(id).get();
		ClienteDTO clienteDtoEncontrado;
		clienteDtoEncontrado = modelMapper.map(cliente, ClienteDTO.class);
		return clienteDtoEncontrado;
	}

	public ClienteDTO update(ClienteDTO clienteDto) {
		Cliente cliente = clienteRepository.save(new Cliente(clienteDto));
		ClienteDTO clienteDtoSaved;
		clienteDtoSaved = modelMapper.map(cliente, ClienteDTO.class);
		return clienteDtoSaved;
	}

	public ClienteDTO deleteById(Integer id) {
		Cliente cliente = clienteRepository.findById(id).get();
		ClienteDTO clienteDtoDeleted;
		clienteDtoDeleted = modelMapper.map(cliente, ClienteDTO.class);

		if(cliente != null) {
			clienteRepository.delete(cliente);
			return clienteDtoDeleted;
		}
		return clienteDtoDeleted;
	}

	public long count() {
		return clienteRepository.count();
	}
}
