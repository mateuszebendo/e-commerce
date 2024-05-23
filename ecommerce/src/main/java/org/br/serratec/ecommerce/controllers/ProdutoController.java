package org.br.serratec.ecommerce.controllers;


import java.util.List;

import org.br.serratec.ecommerce.dtos.ProdutoDTO;
import org.br.serratec.ecommerce.repositories.ProdutoRepository;
import org.br.serratec.ecommerce.services.ProdutoService;
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
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    ProdutoService produtoService;


    @PostMapping
    public ResponseEntity<ProdutoDTO> save(@RequestBody ProdutoDTO produtoDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoService.save(produtoDto));
    }

    @GetMapping
    public ResponseEntity<List<ProdutoDTO>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(produtoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoDTO> findById(@PathVariable Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(produtoService.findById(id));
    }

    @PutMapping
    public ResponseEntity<ProdutoDTO> update(@RequestBody ProdutoDTO produtoDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoService.update(produtoDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(produtoService.deleteById(id));
    }
}