package org.br.serratec.ecommerce.controllers;

import org.br.serratec.ecommerce.dtos.ProdutoDTO;
import org.br.serratec.ecommerce.entities.Produto;
import org.br.serratec.ecommerce.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    ProdutoService produtoService;

    @PostMapping
    public ResponseEntity<Produto> save (@RequestBody Produto produto){
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoService.save(produto));
    }

    @GetMapping("/produtos")
    public ResponseEntity<ProdutoDTO> findAll (@PathVariable) {
    
    }
}
