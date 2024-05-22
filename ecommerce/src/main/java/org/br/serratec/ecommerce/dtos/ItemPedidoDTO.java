package org.br.serratec.ecommerce.dtos;

import org.br.serratec.ecommerce.entities.Pedido;
import org.br.serratec.ecommerce.entities.Produto;

public record ItemPedidoDTO(
        Integer id,
        Double quantidade,
        Double precoVenda,
        Double percentualDesconto,
        Double valorBruto,
        Double valorLiquido,
        Pedido pedido,
        Produto produto
) {
}
