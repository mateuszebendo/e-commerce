package org.br.serratec.ecommerce.services;

import java.util.List;

import org.br.serratec.ecommerce.entities.Cliente;
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
		return clienteRepository.findById(id).orElse(null);
	}

	public Cliente save(Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	public Cliente update(Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	public Cliente deleteCliente(Cliente cliente) {
		try {
			if(clienteRepository.existsById(cliente.getClienteId())) {

			clienteRepository.deleteById(cliente.getClienteId());
			return cliente;
			}
		}catch(Exception e){
			System.out.println(e);
		}
		return cliente;
	}

	public Cliente deleteById(Integer id) {
		Cliente cliente = clienteRepository.findById(id).orElse(null);
		try {
			if(cliente != null)
				clienteRepository.deleteById(id);
				return cliente;

		}catch(Exception e) {
			System.out.println(e);
		}
		return cliente;
	}

	public long count() {
		return clienteRepository.count();
	}
}
