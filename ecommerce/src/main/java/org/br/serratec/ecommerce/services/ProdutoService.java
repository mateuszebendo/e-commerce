package org.br.serratec.ecommerce.services;

import org.br.serratec.ecommerce.dtos.ProdutoDTO;
import org.br.serratec.ecommerce.entities.Produto;
import org.br.serratec.ecommerce.repositories.ProdutoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ProdutoService {

    @Autowired
    ProdutoRepository produtoRepository;

    @Autowired
    ModelMapper modelMapper;
    public ProdutoDTO save(ProdutoDTO produtoDto) {
        Produto produto = produtoRepository.save(new Produto(produtoDto));
        ProdutoDTO produtoDtoSaved;
        produtoDtoSaved = modelMapper.map(produto, ProdutoDTO.class);
        return produtoDtoSaved;
}

    public List<ProdutoDTO> findAll() {
        List<Produto> produtos = produtoRepository.findAll();
        List<ProdutoDTO> produtosDto = new ArrayList<>();
        for (Produto produto : produtos) {
            ProdutoDTO produtoDtoEncontrado = modelMapper.map(produto, ProdutoDTO.class);
            produtosDto.add(produtoDtoEncontrado);
        }
        return produtosDto;
    }
    public ProdutoDTO findById(Integer id) {
        Produto produto = produtoRepository.findById(id).orElse(null);
        ProdutoDTO produtoDtoEncontrado;
        produtoDtoEncontrado = modelMapper.map(produto, ProdutoDTO.class);
        return produtoDtoEncontrado;
    }

    public ProdutoDTO update(ProdutoDTO produtoDto) {
        Produto produto = produtoRepository.save(new Produto(produtoDto));
        ProdutoDTO produtoDtoSaved;
        produtoDtoSaved = modelMapper.map(produto, ProdutoDTO.class);
        return produtoDtoSaved;
    }

    public ProdutoDTO deleteById(Integer id) {
        return null;
    }
}
