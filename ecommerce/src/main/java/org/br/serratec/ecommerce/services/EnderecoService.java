package org.br.serratec.ecommerce.services;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.br.serratec.ecommerce.dtos.ConsultaCepDTO;
import org.br.serratec.ecommerce.dtos.EnderecoDTO;
import org.br.serratec.ecommerce.entities.Cliente;
import org.br.serratec.ecommerce.entities.Endereco;
import org.br.serratec.ecommerce.exceptions.EntidadeNotFoundException;
import org.br.serratec.ecommerce.repositories.EnderecoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

@Service
public class EnderecoService {

	@Autowired
	EnderecoRepository enderecoRepository;

	@Autowired
	ModelMapper modelMapper;

	public EnderecoDTO save(EnderecoDTO enderecoDTO) {
		if(enderecoDTO.getCep() == null) {
			throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Cep não pode ser Nulo");
		}else if(enderecoDTO.getCep().equals("")){
			throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Cep não pode ser Vazio");
		}

		ConsultaCepDTO enderecoDTOConsultado = ConsultaCepService.consultaCep(enderecoDTO.getCep());
		enderecoDTO.setRua(enderecoDTOConsultado.getlogradouro());
		enderecoDTO.setBairro(enderecoDTOConsultado.getBairro());
		enderecoDTO.setCidade(enderecoDTOConsultado.getlocalidade());
		enderecoDTO.setUf(enderecoDTOConsultado.getUf());
		Endereco endereco = enderecoRepository.save(new Endereco(enderecoDTO));
		EnderecoDTO newEnderecoDTO = modelMapper.map(endereco, EnderecoDTO.class);
		return newEnderecoDTO;
	}

	public EnderecoDTO update(EnderecoDTO enderecoDTO) {
		Integer enderecoId = enderecoDTO.getEnderecoId();
		Endereco endereco = enderecoRepository.findById(enderecoId).orElseThrow(
				() -> new EntidadeNotFoundException("Não foi encontrado nenhum Endereço com id " + enderecoId));

		if(enderecoDTO.getCep() == null) {
			throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Cep não pode ser Nulo");
		}else if(enderecoDTO.getCep().equals("")){
			throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Cep não pode ser Vazio");
		}
		ConsultaCepDTO enderecoDTOConsultado = ConsultaCepService.consultaCep(enderecoDTO.getCep());
		enderecoDTO.setRua(enderecoDTOConsultado.getlogradouro());
		enderecoDTO.setBairro(enderecoDTOConsultado.getBairro());
		enderecoDTO.setCidade(enderecoDTOConsultado.getlocalidade());
		enderecoDTO.setUf(enderecoDTOConsultado.getUf());
		enderecoRepository.save(modelMapper.map(enderecoDTO, Endereco.class));
		EnderecoDTO newEnderecoDTO;
		newEnderecoDTO = modelMapper.map(endereco, EnderecoDTO.class);
		return newEnderecoDTO;
	}

	public EnderecoDTO findById(Integer id) {
		Endereco endereco = enderecoRepository.findById(id)
				.orElseThrow(() -> new EntidadeNotFoundException("Não foi encontrado nenhum Endereço com Id " + id));
		EnderecoDTO newEnderecoDTO = modelMapper.map(endereco, EnderecoDTO.class);
		return newEnderecoDTO;
	}

	public List<EnderecoDTO> findAll() {

		List<Endereco> listaEndereco = enderecoRepository.findAll();
		if (listaEndereco.isEmpty()) {
			throw new NoSuchElementException("Nenhum endereço encontrado");
		}
		List<EnderecoDTO> listaEnderecoDTO = new ArrayList<>();
		for (Endereco endereco : listaEndereco) {
			listaEnderecoDTO.add(modelMapper.map(endereco, EnderecoDTO.class));
		}
		return listaEnderecoDTO;
	}

	public EnderecoDTO deleteById(Integer id) {
		Endereco endereco = enderecoRepository.findById(id)
				.orElseThrow(() -> new EntidadeNotFoundException("Não foi encontrado nenhum Endereço com Id " + id));
		Cliente cliente = endereco.getCliente();

		if (cliente != null) {
			throw new DataIntegrityViolationException(
					"O endereço está associado a um usuário e não pode ser excluído.");
		}

		EnderecoDTO newEnderecoDTO = modelMapper.map(endereco, EnderecoDTO.class);

		enderecoRepository.delete(endereco);
		return newEnderecoDTO;
	}
}
