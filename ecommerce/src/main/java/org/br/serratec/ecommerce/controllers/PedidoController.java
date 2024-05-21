package org.br.serratec.ecommerce.controllers;

import java.util.List;

import org.br.serratec.ecommerce.dtos.PedidoDTO;
import org.br.serratec.ecommerce.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    PedidoService pedidoService;

    @PostMapping
    public ResponseEntity<PedidoDTO> save (@RequestBody PedidoDTO pedidoDTO){
         return ResponseEntity.status(HttpStatus.CREATED).body(pedidoService.save(pedidoDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidoDTO> findById (@PathVariable Integer id){
        return ResponseEntity.status(HttpStatus.OK).body(pedidoService.findById(id));
    }

    @GetMapping()
    public ResponseEntity<List<PedidoDTO>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(pedidoService.findAll());
    }
}
