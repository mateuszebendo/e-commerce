package org.br.serratec.ecommerce.controllers;

import org.br.serratec.ecommerce.dtos.ConsultaCepDTO;
import org.br.serratec.ecommerce.services.ConsultaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cep")
public class ConsultaCepController {

	@Autowired
	ConsultaCepService consultaCepService;

	@GetMapping("{id}")
	public ResponseEntity<ConsultaCepDTO> consultaCep(@PathVariable String id) {

		return new ResponseEntity<>(consultaCepService.consultaCep(id), HttpStatus.OK);

	}

}
