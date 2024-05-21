package org.br.serratec.ecommerce.services;

import org.br.serratec.ecommerce.dtos.ItemPedidoDTO;
import org.br.serratec.ecommerce.entities.ItemPedido;
import org.br.serratec.ecommerce.repositories.ItemPedidoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemPedidoService {

    @Autowired
    ItemPedidoRepository itemPedidoRepository;

    @Autowired
    ModelMapper modelMapper;

    public ItemPedidoDTO save (ItemPedidoDTO itemPedidoDTO){
        ItemPedido itemPedidoSaved = itemPedidoRepository.save(new ItemPedido(itemPedidoDTO));
        ItemPedidoDTO newItemPedidoDTO;
        newItemPedidoDTO = modelMapper.map(itemPedidoSaved, ItemPedidoDTO.class);
        return newItemPedidoDTO;
    }

    public ItemPedidoDTO findById (Integer id){
        ItemPedido itemPedidoSaved = itemPedidoRepository.findById(id).orElse(null);
        ItemPedidoDTO newItemPedidoDTO;
        newItemPedidoDTO = modelMapper.map(itemPedidoSaved, ItemPedidoDTO.class);
        return newItemPedidoDTO;
    }

    public List<ItemPedidoDTO> findAll (){
        List<ItemPedido> itemPedidoSaved = itemPedidoRepository.findAll();
        List<ItemPedidoDTO> ListItemPedidoDTO = new ArrayList<>();
        for(ItemPedido itemPedido: itemPedidoSaved) {
            ItemPedidoDTO itemDTOLista = modelMapper.map(itemPedidoSaved, ItemPedidoDTO.class);
            ListItemPedidoDTO.add(itemDTOLista);
        }
        return ListItemPedidoDTO;
    }

    public ItemPedido update (ItemPedidoDTO itemPedidoDTO){
        return itemPedidoRepository.save(new ItemPedido(itemPedidoDTO));
    }

    public ItemPedidoDTO deleteById (Integer id){
        ItemPedido itemPedidoSaved = itemPedidoRepository.findById(id).orElse(null);
        ItemPedidoDTO newItemPedidoDTO;
        newItemPedidoDTO = modelMapper.map(itemPedidoSaved, ItemPedidoDTO.class);
        return newItemPedidoDTO;
    }
}
