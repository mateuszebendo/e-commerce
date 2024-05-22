package org.br.serratec.ecommerce.controllers;

import java.util.List;

import org.br.serratec.ecommerce.dtos.ClienteDTO;
import org.br.serratec.ecommerce.entities.Cliente;
import org.br.serratec.ecommerce.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	ClienteService clienteService;

	@PostMapping
	public ResponseEntity<ClienteDTO> save(@RequestBody ClienteDTO clienteDto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.save(clienteDto);
	}

	@GetMapping
	public ResponseEntity <List<Cliente>> findAll() {
		return new ResponseEntity<>(clienteService.findAll(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Object> findById(@PathVariable Integer id) {
		Cliente cliente = clienteService.findById(id);

		if (cliente == null) {
			return new ResponseEntity<>("{Erro: Usuário não encontrado}", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<> (cliente, HttpStatus.OK);
	}

	@PutMapping
	public ResponseEntity<Cliente> update(@RequestBody Cliente cliente) {
		return new ResponseEntity<> (clienteService.update(cliente), HttpStatus.CREATED);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deletePerfilById(@PathVariable Integer id) {
		Cliente clienteDeletado = clienteService.deleteById(id);
		if  (clienteDeletado != null) {
			return new ResponseEntity<> (clienteDeletado, HttpStatus.OK);
		}
		return new ResponseEntity<>("{Erro: Cliente não encontrado}", HttpStatus.NOT_FOUND);
	}
}
