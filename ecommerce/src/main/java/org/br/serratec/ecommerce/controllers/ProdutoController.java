package org.br.serratec.ecommerce.controllers;

import org.br.serratec.ecommerce.dtos.PedidoDTO;
import org.br.serratec.ecommerce.dtos.ProdutoDTO;
import org.br.serratec.ecommerce.entities.Produto;
import org.br.serratec.ecommerce.repositories.ProdutoRepository;
import org.br.serratec.ecommerce.services.PedidoService;
import org.br.serratec.ecommerce.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    ProdutoService produtoService;
    @Autowired
    private ProdutoRepository produtoRepository;

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
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoService.save(produtoDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable Integer id) {
        ProdutoDTO produto = produtoService.findById(id);
        if(produto != null) {
            produtoService.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body(produto);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{ ERROR: PRODUTO NÃO ENCONTRADO! }");
    }
}