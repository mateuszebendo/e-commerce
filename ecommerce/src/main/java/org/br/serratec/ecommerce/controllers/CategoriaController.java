package org.br.serratec.ecommerce.controllers;

import org.br.serratec.ecommerce.dtos.CategoriaDTO;
import org.br.serratec.ecommerce.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

	@Autowired
	CategoriaService categoriaService;

	@PostMapping
	public ResponseEntity<CategoriaDTO> save (@RequestBody CategoriaDTO categoriaDTO){
		return ResponseEntity.status(HttpStatus.CREATED).body(categoriaService.save(categoriaDTO));
	}

	@GetMapping("/{id}")
	public ResponseEntity<CategoriaDTO> findById (@PathVariable Integer id){
		return ResponseEntity.status(HttpStatus.OK).body(categoriaService.findById(id));
	}

	@GetMapping
	public ResponseEntity<List<CategoriaDTO>> findAll (){
		return ResponseEntity.status(HttpStatus.OK).body(categoriaService.findAll());
	}

	@PutMapping
	public ResponseEntity<CategoriaDTO> update (@RequestBody CategoriaDTO categoriaDTO){
		return ResponseEntity.status(HttpStatus.OK).body(categoriaService.update(categoriaDTO));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete (@PathVariable Integer id){
		return ResponseEntity.status(HttpStatus.OK).body(categoriaService.deleteById(id));
	}
}
