package org.br.serratec.ecommerce.services;

import org.br.serratec.ecommerce.entities.Categoria;
import org.br.serratec.ecommerce.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {

	@Autowired
	CategoriaRepository categoriaRepository;

	public Categoria save(Categoria categoria) {
		return categoriaRepository.save(categoria);
	}
	
	public Categoria update(Categoria categoria) {
		return categoriaRepository.save(categoria);
	}
	
	
}
