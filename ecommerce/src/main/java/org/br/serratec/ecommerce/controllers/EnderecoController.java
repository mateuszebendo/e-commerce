package org.br.serratec.ecommerce.controllers;

import java.util.List;

import org.br.serratec.ecommerce.dtos.EnderecoDTO;
import org.br.serratec.ecommerce.services.ConsultaCepService;
import org.br.serratec.ecommerce.services.EnderecoService;
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
@RequestMapping("/enderecos")
public class EnderecoController {

	@Autowired
	EnderecoService enderecoService;

	@PostMapping
	public ResponseEntity<EnderecoDTO> save(@RequestBody EnderecoDTO enderecoDTO) {
		return ResponseEntity.status(HttpStatus.CREATED).body(enderecoService.save(enderecoDTO));
	}

	@PutMapping
	public ResponseEntity<EnderecoDTO> update(@RequestBody EnderecoDTO enderecoDTO) {
		return ResponseEntity.status(HttpStatus.CREATED).body(enderecoService.update(enderecoDTO));
	}

	@GetMapping("/fake-endereco/{cep}")
	public ResponseEntity<?> findById(@PathVariable String cep) {
		return ResponseEntity.status(HttpStatus.OK).body(ConsultaCepService.consultaCep(cep));
	}

	@GetMapping("/{id}")
	public ResponseEntity<EnderecoDTO> findById(@PathVariable Integer id) {
		return ResponseEntity.status(HttpStatus.OK).body(enderecoService.findById(id));
	}

	@GetMapping
	public ResponseEntity<List<EnderecoDTO>> findAll() {
		return ResponseEntity.status(HttpStatus.OK).body(enderecoService.findAll());
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> delete(@PathVariable Integer id) {
		return ResponseEntity.status(HttpStatus.OK).body(enderecoService.deleteById(id));

	}

}
