package org.br.serratec.ecommerce.services;

import org.br.serratec.ecommerce.dtos.ProdutoDTO;
import org.br.serratec.ecommerce.entities.Produto;
import org.br.serratec.ecommerce.exceptions.EntidadeNotFoundException;
import org.br.serratec.ecommerce.repositories.ProdutoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

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

    public List<ProdutoDTO> findAll() {
        List<Produto> produtos = produtoRepository.findAll();
        if(produtos.isEmpty()) {
            throw new NoSuchElementException("Ocorreu um erro: Nenhum produto encontrado.");
        }
        List<ProdutoDTO> produtosDto = new ArrayList<>();
        for (Produto produto : produtos) {
            produtosDto.add(modelMapper.map(produto, ProdutoDTO.class));
        }
        return produtosDto;
    }
    public ProdutoDTO findById(Integer id) {
        Produto produto = produtoRepository.findById(id).orElseThrow(
				()-> new EntidadeNotFoundException("Não foi encontrado um Produto com Id " + id));
        ProdutoDTO produtoDtoEncontrado = modelMapper.map(produto, ProdutoDTO.class);
        return produtoDtoEncontrado;
    }

    public ProdutoDTO update(ProdutoDTO produtoDto) {
        Produto produto = produtoRepository.save(modelMapper.map(produtoDto, Produto.class));
        ProdutoDTO produtoDtoSaved = modelMapper.map(produto, ProdutoDTO.class);
        return produtoDtoSaved;
    }

    public ProdutoDTO deleteById(Integer id) {
        Produto produto = produtoRepository.findById(id).orElseThrow(
				()-> new EntidadeNotFoundException("Não foi encontrado um Produto com Id " + id));
        ProdutoDTO produtoDtoDeleted = modelMapper.map(produto, ProdutoDTO.class);
        produtoRepository.delete(produto);
        return produtoDtoDeleted;
    }
}