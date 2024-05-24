package org.br.serratec.ecommerce.services;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.br.serratec.ecommerce.dtos.ProdutoDTO;
import org.br.serratec.ecommerce.entities.Produto;
import org.br.serratec.ecommerce.exceptions.EntidadeNotFoundException;
import org.br.serratec.ecommerce.repositories.ProdutoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

	@Autowired
	ProdutoRepository produtoRepository;

	@Autowired
	ModelMapper modelMapper;

	public ProdutoDTO save(ProdutoDTO produtoDto) {
		Produto produto = produtoRepository.save(new Produto(produtoDto));
		ProdutoDTO produtoDtoSaved = modelMapper.map(produto, ProdutoDTO.class);
		return produtoDtoSaved;
	}

	public ProdutoDTO update(ProdutoDTO produtoDto) {
		Integer produtoId = produtoDto.getProdutoId();
		Produto produto = produtoRepository.findById(produtoId).orElseThrow(
				() -> new EntidadeNotFoundException("Não foi encontrado nenhum Produto com id " + produtoId));

		produtoRepository.save(modelMapper.map(produtoDto, Produto.class));
		ProdutoDTO produtoDtoSaved = modelMapper.map(produto, ProdutoDTO.class);
		return produtoDtoSaved;
	}

	public List<ProdutoDTO> findAll() {
		List<Produto> produtos = produtoRepository.findAll();
		if (produtos.isEmpty()) {
			throw new NoSuchElementException("Nenhum produto encontrado.");
		}
		List<ProdutoDTO> produtosDto = new ArrayList<>();
		for (Produto produto : produtos) {
			produtosDto.add(modelMapper.map(produto, ProdutoDTO.class));
		}
		return produtosDto;
	}

	public ProdutoDTO findById(Integer id) {
		Produto produto = produtoRepository.findById(id)
				.orElseThrow(() -> new EntidadeNotFoundException("Não foi encontrado nenhum Produto com Id " + id));
		ProdutoDTO produtoDtoEncontrado = modelMapper.map(produto, ProdutoDTO.class);
		return produtoDtoEncontrado;
	}

	public ProdutoDTO deleteById(Integer id) {
		Produto produto = produtoRepository.findById(id)
				.orElseThrow(() -> new EntidadeNotFoundException("Não foi encontrado nenhum Produto com Id " + id));
		ProdutoDTO produtoDtoDeleted = modelMapper.map(produto, ProdutoDTO.class);
		produtoRepository.delete(produto);
		return produtoDtoDeleted;
	}
}