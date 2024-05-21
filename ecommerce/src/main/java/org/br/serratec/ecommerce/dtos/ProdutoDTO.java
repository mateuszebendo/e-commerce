package org.br.serratec.ecommerce.dtos;

import java.time.LocalDateTime;

public record ProdutoDTO(
        String nomeDescricao,
        Integer qtdEstoque,
        LocalDateTime dataCadastro,
        Double valorUnitario,
        Categoria categoria)
{}
