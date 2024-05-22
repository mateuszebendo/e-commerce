package org.br.serratec.ecommerce.repositories;

import org.br.serratec.ecommerce.entities.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Integer> {
}
