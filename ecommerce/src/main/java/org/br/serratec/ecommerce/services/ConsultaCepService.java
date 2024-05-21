package org.br.serratec.ecommerce.services;

import java.util.HashMap;
import java.util.Map;

import org.br.serratec.ecommerce.dtos.ConsultaCepDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ConsultaCepService {

	public ConsultaCepDTO consultaCep(String id) {
		RestTemplate restTemplate = new RestTemplate();
		String uri = "https://fakestoreapi.com/users/{id}";
		
		Map<String,String> params = new HashMap<String,String>();
		
		params.put("id", id);
		
		ConsultaCepDTO dto = restTemplate.getForObject(uri, ConsultaCepDTO.class, params);
		
		return dto;
	}
	
	
	
}
