package org.br.serratec.ecommerce.services;

import java.util.ArrayList;
import java.util.List;

import org.br.serratec.ecommerce.dtos.CategoriaDTO;
import org.br.serratec.ecommerce.dtos.EnderecoDTO;
import org.br.serratec.ecommerce.entities.Categoria;
import org.br.serratec.ecommerce.entities.Endereco;
import org.br.serratec.ecommerce.repositories.CategoriaRepository;
import org.br.serratec.ecommerce.repositories.EnderecoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EnderecoService {
	
	@Autowired
	EnderecoRepository enderecoRepository;

	@Autowired
	ModelMapper modelMapper;

	public EnderecoDTO save(EnderecoDTO enderecoDTO){
		Endereco enderecoSalvo = enderecoRepository.save(new Endereco(enderecoDTO));
		EnderecoDTO enderecoDTOSaved = modelMapper.map(enderecoSalvo, EnderecoDTO.class);
		return enderecoDTOSaved;
	}

	public EnderecoDTO findById (Integer id){
		Endereco enderecoEncontrado = enderecoRepository.findById(id).get();
		EnderecoDTO enderecoDTOFounded = modelMapper.map(enderecoEncontrado, EnderecoDTO.class);
		return enderecoDTOFounded;
	}

	public List<EnderecoDTO> findAll (){
		List<Endereco> listaEnderecos = enderecoRepository.findAll();
		List<EnderecoDTO> listaEnderecosDTO = new ArrayList<>();
		for(Endereco endereco: listaEnderecos) {
			EnderecoDTO itemDTOLista = modelMapper.map(endereco, EnderecoDTO.class);
			listaEnderecosDTO.add(itemDTOLista);
		}
		return listaEnderecosDTO;
	}

	public EnderecoDTO update(EnderecoDTO enderecoDTO){
		Endereco enderecoModificado = enderecoRepository.save(modelMapper.map(enderecoDTO, Endereco.class));
		EnderecoDTO enderecoDTOModify = modelMapper.map(enderecoModificado, EnderecoDTO.class);
		return enderecoDTOModify;
	}

	public EnderecoDTO deleteById (Integer id){
		Endereco enderecoDeletado = enderecoRepository.findById(id).get();
		enderecoRepository.deleteById(id);
		EnderecoDTO enderecoDTODeleted = modelMapper.map(enderecoDeletado, EnderecoDTO.class);
		return enderecoDTODeleted;
	}
	
}
