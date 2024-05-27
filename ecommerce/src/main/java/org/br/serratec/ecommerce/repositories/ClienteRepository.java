package org.br.serratec.ecommerce.repositories;

import org.br.serratec.ecommerce.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{
}
