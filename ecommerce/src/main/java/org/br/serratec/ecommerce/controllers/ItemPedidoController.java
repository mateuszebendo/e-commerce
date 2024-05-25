package org.br.serratec.ecommerce.controllers;

import org.br.serratec.ecommerce.dtos.ItemPedidoDTO;
import org.br.serratec.ecommerce.services.ItemPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/item-pedido")
public class ItemPedidoController {

    @Autowired
    ItemPedidoService itemPedidoService;

    @PostMapping
    public ResponseEntity<ItemPedidoDTO> save (@RequestBody ItemPedidoDTO itemPedidoDTO){
         return ResponseEntity.status(HttpStatus.CREATED).body(itemPedidoService.save(itemPedidoDTO));
    }

    @PostMapping("/all")
    public ResponseEntity<List<ItemPedidoDTO>> saveAll (@RequestBody List<ItemPedidoDTO> listItemPedidoDTO){
         return ResponseEntity.status(HttpStatus.CREATED).body(itemPedidoService.saveAll(listItemPedidoDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItemPedidoDTO> findById (@PathVariable Integer id){
        return ResponseEntity.status(HttpStatus.OK).body(itemPedidoService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<ItemPedidoDTO>> findAll (){
        return ResponseEntity.status(HttpStatus.OK).body(itemPedidoService.findAll());
    }

    @PutMapping
    public ResponseEntity<ItemPedidoDTO> update (@RequestBody ItemPedidoDTO itemPedidoDTO){
        return ResponseEntity.status(HttpStatus.OK).body(itemPedidoService.update(itemPedidoDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ItemPedidoDTO> delete (@PathVariable Integer id){
        return ResponseEntity.status(HttpStatus.OK).body(itemPedidoService.deleteById(id));
    }
}
