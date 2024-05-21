package org.br.serratec.ecommerce.controllers;

import org.br.serratec.ecommerce.dtos.ItemPedidoDTO;
import org.br.serratec.ecommerce.entities.ItemPedido;
import org.br.serratec.ecommerce.services.ItemPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/item-pedido")
public class ItemPedidoController {

    @Autowired
    ItemPedidoService itemPedidoService;



    @PostMapping
    public ResponseEntity<ItemPedidoDTO> save (@RequestBody ItemPedidoDTO itemPedidoDTO){
         return ResponseEntity.status(HttpStatus.CREATED).body(itemPedidoService.save(itemPedidoDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItemPedidoDTO> findById (@PathVariable Integer id){
        return ResponseEntity.status(HttpStatus.OK).body(itemPedidoService.findById(id));
    }
}
