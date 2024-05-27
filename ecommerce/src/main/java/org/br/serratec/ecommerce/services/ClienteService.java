package org.br.serratec.ecommerce.services;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.br.serratec.ecommerce.dtos.ClienteDTO;
import org.br.serratec.ecommerce.entities.Cliente;
import org.br.serratec.ecommerce.exceptions.EntidadeNotFoundException;
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
		ClienteDTO clienteDtoSalvo = modelMapper.map(clienteSalvo, ClienteDTO.class);
		return clienteDtoSalvo;
	}

	public ClienteDTO update(ClienteDTO clienteDto) {
		Integer clienteId = clienteDto.getClienteId();
		Cliente cliente = clienteRepository.findById(clienteId).orElseThrow(
				() -> new EntidadeNotFoundException("Não foi encontrado nenhum Cliente com id " + clienteId));

		clienteRepository.save(modelMapper.map(clienteDto, Cliente.class));
		ClienteDTO clienteDtoSaved = modelMapper.map(cliente, ClienteDTO.class);
		return clienteDtoSaved;
	}

	public ClienteDTO findById(Integer id) {
		Cliente cliente = clienteRepository.findById(id)
				.orElseThrow(() -> new EntidadeNotFoundException("Não foi encontrado nenhum Cliente com Id " + id));
		ClienteDTO clienteDTO = modelMapper.map(cliente, ClienteDTO.class);
		return clienteDTO;
	}

	public List<ClienteDTO> findAll() {
		List<Cliente> clientes = clienteRepository.findAll();
		if (clientes.isEmpty())
			throw new NoSuchElementException("Nenhum Cliente encontrado");
		List<ClienteDTO> clientesDto = new ArrayList<>();
		for (Cliente cliente : clientes) {
			clientesDto.add(modelMapper.map(cliente, ClienteDTO.class));
		}
		return clientesDto;
	}

	public ClienteDTO deleteById(Integer id) {
		Cliente cliente = clienteRepository.findById(id)
				.orElseThrow(() -> new EntidadeNotFoundException("Não foi encontrado nenhum Cliente com Id " + id));
		clienteRepository.deleteById(id);
		ClienteDTO clienteDto = modelMapper.map(cliente, ClienteDTO.class);
		return clienteDto;
	}

	public long count() {
		return clienteRepository.count();
	}
}
