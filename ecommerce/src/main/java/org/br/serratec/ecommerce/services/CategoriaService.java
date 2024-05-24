package org.br.serratec.ecommerce.services;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.br.serratec.ecommerce.dtos.CategoriaDTO;
import org.br.serratec.ecommerce.entities.Categoria;
import org.br.serratec.ecommerce.exceptions.EntidadeNotFoundException;
import org.br.serratec.ecommerce.repositories.CategoriaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {

	@Autowired
	CategoriaRepository categoriaRepository;

	@Autowired
	ModelMapper modelMapper;

	public CategoriaDTO save(CategoriaDTO categoriaDTO) {
		Categoria categoriaEncontrada = categoriaRepository.save(new Categoria(categoriaDTO));
		return modelMapper.map(categoriaEncontrada, CategoriaDTO.class);
	}

	public CategoriaDTO update(CategoriaDTO categoriaDTO) {
		Integer categoriaId = categoriaDTO.getCategoriaId();

		Categoria categoria = categoriaRepository.findById(categoriaId).orElseThrow(
				() -> new EntidadeNotFoundException("Não foi encontrada nenhuma Categoria com id " + categoriaId));

		categoriaRepository.save(modelMapper.map(categoriaDTO, Categoria.class));
		CategoriaDTO newCategoriaDTO = modelMapper.map(categoria, CategoriaDTO.class);
		return newCategoriaDTO;
	}

	public CategoriaDTO findById(Integer id) {
		Categoria categoriaEncontrada = categoriaRepository.findById(id)
				.orElseThrow(() -> new EntidadeNotFoundException("Não foi encontrado um Cliente com Id " + id));
		return modelMapper.map(categoriaEncontrada, CategoriaDTO.class);
	}

	public List<CategoriaDTO> findAll() {
		List<Categoria> listaCategorias = categoriaRepository.findAll();
		if(listaCategorias.isEmpty()) {
			throw new NoSuchElementException("Nenhuma Categoria encontrada");
		}
		List<CategoriaDTO> listaCategoriasDTO = new ArrayList<>();
		for (Categoria categoria : listaCategorias) {
			listaCategoriasDTO.add(modelMapper.map(categoria, CategoriaDTO.class));
		}
		return listaCategoriasDTO;
	}

	public CategoriaDTO deleteById(Integer id) {
		Categoria categoriaDeletada = categoriaRepository.findById(id)
				.orElseThrow(() -> new EntidadeNotFoundException("Não foi encontrado um Cliente com Id " + id));
		categoriaRepository.deleteById(id);
		CategoriaDTO newCategoriaDTO = modelMapper.map(categoriaDeletada, CategoriaDTO.class);
		return newCategoriaDTO;
	}

}