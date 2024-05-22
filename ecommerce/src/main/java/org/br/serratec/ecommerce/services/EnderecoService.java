package org.br.serratec.ecommerce.services;

import java.util.List;

import org.br.serratec.ecommerce.entities.Endereco;
import org.br.serratec.ecommerce.repositories.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EnderecoService {

	
	@Autowired
	EnderecoRepository enderecoRepository;

	
	public List<Endereco> findAll() {
		return enderecoRepository.findAll();
	}
	
	public Endereco findById(Integer id) {
		return enderecoRepository.findById(id).orElse(null);
	}
	
	public Endereco save(Endereco endereco) {
		return enderecoRepository.save(endereco);
	}

	public Endereco update(Endereco endereco) {
		return enderecoRepository.save(endereco);
	}

	public Boolean deleteById(Integer id) {
		if(enderecoRepository.existsById(id)) {
			enderecoRepository.deleteById(id);
			Endereco enderecoDeletado = enderecoRepository.findById(id).orElse(null);
			if(enderecoDeletado == null) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	
	public long count() {
		return enderecoRepository.count();
	}
	
}
