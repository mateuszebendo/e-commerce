package org.br.serratec.ecommerce.dtos;

import java.time.LocalDate;

import org.br.serratec.ecommerce.entities.Endereco;

public class ClienteDTO {
	private Integer cliente;
	private String email;
	private String nomeCompleto;
	private String cpf;
	private String telefone;
	private LocalDate dataNascimento;
	private Endereco endereco;

}
