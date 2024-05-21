package org.br.serratec.ecommerce.dtos;

import java.time.LocalDateTime;

import org.br.serratec.ecommerce.entities.Categoria;

public record ProdutoDTO(
        String nomeDescricao,
        Integer qtdEstoque,
        LocalDateTime dataCadastro,
        Double valorUnitario,
        Categoria categoria)
{}
