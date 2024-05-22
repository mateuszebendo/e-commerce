package org.br.serratec.ecommerce.services;

import org.br.serratec.ecommerce.dtos.ProdutoDTO;
import org.br.serratec.ecommerce.entities.Produto;
import org.br.serratec.ecommerce.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ProdutoService {

    @Autowired
    ProdutoRepository produtoRepository;
    public Produto save(ProdutoDTO produtoDto) {
        return produtoRepository.save(new Produto(produtoDto));
    }
}
