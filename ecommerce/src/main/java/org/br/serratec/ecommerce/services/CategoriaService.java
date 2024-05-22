package org.br.serratec.ecommerce.services;

import org.br.serratec.ecommerce.dtos.CategoriaDTO;
import org.br.serratec.ecommerce.entities.Categoria;
import org.br.serratec.ecommerce.exceptions.EntidadeNotFoundException;
import org.br.serratec.ecommerce.repositories.CategoriaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class CategoriaService {

        @Autowired
        CategoriaRepository categoriaRepository;

        @Autowired
        ModelMapper modelMapper;

        public CategoriaDTO save(CategoriaDTO categoriaDTO){
            Categoria categoriaEncontrada = categoriaRepository.save(new Categoria(categoriaDTO));
            CategoriaDTO newCategoriaDTO = modelMapper.map(categoriaEncontrada, CategoriaDTO.class);
            return newCategoriaDTO;
        }

        public CategoriaDTO findById (Integer id){
            Categoria categoriaEncontrada = categoriaRepository.findById(id).orElseThrow(
    				()-> new EntidadeNotFoundException("Não foi encontrado um Cliente com Id " + id));
            CategoriaDTO newCategoriaDTO = modelMapper.map(categoriaEncontrada, CategoriaDTO.class);;
            return newCategoriaDTO;
        }

        public List<CategoriaDTO> findAll (){
            List<Categoria> listaCategorias = categoriaRepository.findAll();
            List<CategoriaDTO> listaCategoriasDTO = new ArrayList<>();
            for(Categoria categoria: listaCategorias) {
                CategoriaDTO itemDTOLista = modelMapper.map(categoria, CategoriaDTO.class);
                listaCategoriasDTO.add(itemDTOLista);
            }
            return listaCategoriasDTO;
        }

        public CategoriaDTO update(CategoriaDTO categoriaDTO) {
            Categoria categoriaEncontrada = categoriaRepository.save(modelMapper.map(categoriaDTO, Categoria.class));
            CategoriaDTO newCategoriaDTO = modelMapper.map(categoriaEncontrada, CategoriaDTO.class);
            return newCategoriaDTO;
        }


        public CategoriaDTO deleteById(Integer id){
            Categoria categoriaDeletada = categoriaRepository.findById(id).orElseThrow(
    				()-> new EntidadeNotFoundException("Não foi encontrado um Cliente com Id " + id));
            categoriaRepository.deleteById(id);
            CategoriaDTO newCategoriaDTO = modelMapper.map(categoriaDeletada, CategoriaDTO.class);
            return newCategoriaDTO;
        }

}