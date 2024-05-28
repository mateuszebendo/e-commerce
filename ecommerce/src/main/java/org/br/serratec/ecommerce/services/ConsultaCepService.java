package org.br.serratec.ecommerce.services;

import java.util.HashMap;
import java.util.Map;

import org.br.serratec.ecommerce.dtos.ConsultaCepDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ConsultaCepService {

	public static ConsultaCepDTO consultaCep(String cep) {
		RestTemplate restTemplate = new RestTemplate();
		String url = "https://viacep.com.br/ws/{cep}/json/";
		Map<String, String> dadosCep = new HashMap<String, String>();
		dadosCep.put("cep", cep);
		ConsultaCepDTO cepConsultadoDTO = restTemplate.getForObject(url, ConsultaCepDTO.class, dadosCep);
		if (cepConsultadoDTO.getlogradouro() == null) {
			throw new NullPointerException("Ocorreu um erro: Este cep é invalido!");
		}
		return cepConsultadoDTO;
	}
}