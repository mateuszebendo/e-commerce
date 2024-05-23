package org.br.serratec.ecommerce.services;

import java.util.ArrayList;
import java.util.List;

import org.br.serratec.ecommerce.dtos.ConsultaCepDTO;
import org.br.serratec.ecommerce.dtos.EnderecoDTO;
import org.br.serratec.ecommerce.entities.Endereco;
import org.br.serratec.ecommerce.exceptions.EntidadeNotFoundException;
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

	public EnderecoDTO save(EnderecoDTO enderecoDTO) {
		ConsultaCepDTO enderecoDTOConsultado = ConsultaCepService.consultaCep(enderecoDTO.getCep());
		enderecoDTO.setRua(enderecoDTOConsultado.getlogradouro());
		enderecoDTO.setBairro(enderecoDTOConsultado.getBairro());
		enderecoDTO.setCidade(enderecoDTOConsultado.getlocalidade());
		enderecoDTO.setUf(enderecoDTOConsultado.getUf());
		Endereco endereco = enderecoRepository.save(new Endereco(enderecoDTO));
		EnderecoDTO newEnderecoDTO = modelMapper.map(endereco, EnderecoDTO.class);
		return newEnderecoDTO;
	}


	public EnderecoDTO findById(Integer id) {
        Endereco endereco = enderecoRepository.findById(id).orElseThrow(
				()-> new EntidadeNotFoundException("Não foi encontrado um Endereço com Id " + id));
        EnderecoDTO newEnderecoDTO;
        newEnderecoDTO = modelMapper.map(endereco, EnderecoDTO.class);
        return newEnderecoDTO;
	}

	public List<EnderecoDTO> findAll(){

		List<Endereco> listaEndereco = enderecoRepository.findAll();
		List<EnderecoDTO> listaEnderecoDTO = new ArrayList<>();
		for(Endereco endereco : listaEndereco) {
			EnderecoDTO enderecoDTO = modelMapper.map(endereco, EnderecoDTO.class);
			listaEnderecoDTO.add(enderecoDTO);
		}
		return listaEnderecoDTO;
	}

	public EnderecoDTO update(EnderecoDTO enderecoDTO) {
		ConsultaCepDTO enderecoDTOConsultado = ConsultaCepService.consultaCep(enderecoDTO.getCep());
		enderecoDTO.setRua(enderecoDTOConsultado.getlogradouro());
		enderecoDTO.setBairro(enderecoDTOConsultado.getBairro());
		enderecoDTO.setCidade(enderecoDTOConsultado.getlocalidade());
		enderecoDTO.setUf(enderecoDTOConsultado.getUf());
		Endereco endereco = enderecoRepository.save(modelMapper.map(enderecoDTO, Endereco.class));
		EnderecoDTO newEnderecoDTO;
		newEnderecoDTO = modelMapper.map(endereco, EnderecoDTO.class);
		return newEnderecoDTO;
	}

	public EnderecoDTO deleteById (Integer id){
		Endereco endereco = enderecoRepository.findById(id).orElseThrow(
				()-> new EntidadeNotFoundException("Não foi encontrado um Endereço com Id " + id));
		EnderecoDTO newEnderecoDTO = modelMapper.map(endereco, EnderecoDTO.class);
		if(endereco != null) {
			enderecoRepository.delete(endereco);
			return newEnderecoDTO;
		}
		return newEnderecoDTO;
    }

}
