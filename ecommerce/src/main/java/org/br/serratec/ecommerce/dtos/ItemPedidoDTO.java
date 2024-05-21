package org.br.serratec.ecommerce.dtos;

import org.br.serratec.ecommerce.entities.ItemPedido;
import org.br.serratec.ecommerce.entities.Pedido;
import org.br.serratec.ecommerce.entities.Produto;

import java.util.List;

public record ItemPedidoDTO(
        Integer id,
        Double quantidade,
        Double precoVenda,
        Double percentualDesconto,
        Double valorBruto,
        Double valorLiquido,
        List<Pedido> pedidos,
        List<Produto> produtos
) {
}
