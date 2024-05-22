package org.br.serratec.ecommerce.services;

import java.util.ArrayList;
import java.util.List;

import org.br.serratec.ecommerce.dtos.ItemPedidoDTO;
import org.br.serratec.ecommerce.entities.ItemPedido;
import org.br.serratec.ecommerce.repositories.ItemPedidoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemPedidoService {

    @Autowired
    ItemPedidoRepository itemPedidoRepository;

    @Autowired
    ModelMapper modelMapper;

    public ItemPedidoDTO save(ItemPedidoDTO itemPedidoDTO){
        ItemPedido itemPedidoSaved = itemPedidoRepository.save(new ItemPedido(itemPedidoDTO));
        ItemPedidoDTO newItemPedidoDTO = modelMapper.map(itemPedidoSaved, ItemPedidoDTO.class);
        return newItemPedidoDTO;
    }

    public ItemPedidoDTO findById (Integer id){
        ItemPedido itemPedidoSaved = itemPedidoRepository.findById(id).orElse(null);
        ItemPedidoDTO newItemPedidoDTO = modelMapper.map(itemPedidoSaved, ItemPedidoDTO.class);
        return newItemPedidoDTO;
    }

    public List<ItemPedidoDTO> findAll (){
        List<ItemPedido> itemPedidoSaved = itemPedidoRepository.findAll();
        List<ItemPedidoDTO> ListItemPedidoDTO = new ArrayList<>();
        for(ItemPedido itemPedido: itemPedidoSaved) {
            ItemPedidoDTO itemDTOLista = modelMapper.map(itemPedido, ItemPedidoDTO.class);
            ListItemPedidoDTO.add(itemDTOLista);
        }
        return ListItemPedidoDTO;
    }

    public ItemPedidoDTO update (ItemPedidoDTO itemPedidoDTO){
        ItemPedido itemPedidoSaved = itemPedidoRepository.save(modelMapper.map(itemPedidoDTO, ItemPedido.class));
        ItemPedidoDTO newItemPedidoDTO= modelMapper.map(itemPedidoSaved, ItemPedidoDTO.class);
        return newItemPedidoDTO;
    }

    public ItemPedidoDTO deleteById (Integer id){
        ItemPedido itemPedidoSaved = itemPedidoRepository.findById(id).orElse(null);
        itemPedidoRepository.deleteById(id);
        ItemPedidoDTO newItemPedidoDTO = modelMapper.map(itemPedidoSaved, ItemPedidoDTO.class);
        return newItemPedidoDTO;
    }
}
