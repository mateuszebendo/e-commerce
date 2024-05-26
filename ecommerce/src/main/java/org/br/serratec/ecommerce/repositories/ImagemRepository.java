package org.br.serratec.ecommerce.repositories;

import org.br.serratec.ecommerce.entities.Imagem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImagemRepository extends JpaRepository<Imagem, Integer> {
}