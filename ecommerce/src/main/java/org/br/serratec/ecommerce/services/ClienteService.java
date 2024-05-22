package org.br.serratec.ecommerce.services;

import java.util.List;

import org.br.serratec.ecommerce.entities.Cliente;
import org.br.serratec.ecommerce.exceptions.EntidadeNotFoundException;
import org.br.serratec.ecommerce.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

	@Autowired
	ClienteRepository clienteRepository;

	public List<Cliente> findAll() {
		return clienteRepository.findAll();
	}

	public Cliente findById(Integer id) {
		return clienteRepository.findById(id).orElseThrow(
				()-> new EntidadeNotFoundException("Não foi encontrado um Cliente com Id " + id));
	}

	public Cliente save(Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	public Cliente update(Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	public Cliente deleteById(Integer id) {
		Cliente cliente = clienteRepository.findById(id).orElseThrow(
				()-> new EntidadeNotFoundException("Não foi encontrado um Cliente com Id " + id));
		clienteRepository.deleteById(id);
		return cliente;
	}

	public long count() {
		return clienteRepository.count();
	}
}
