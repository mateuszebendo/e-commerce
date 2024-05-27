package org.br.serratec.ecommerce.dtos;

import java.time.LocalDate;

import org.br.serratec.ecommerce.entities.Endereco;

public class ClienteDTO {
	private Integer clienteId;
	private String nomeCompleto;
	private String email;
	private String cpf;
	private String telefone;
	private LocalDate dataNascimento;
	private Endereco endereco;

	public ClienteDTO() {
	}

	public ClienteDTO(Integer clienteId, String nomeCompleto, String email, String cpf, String telefone,
					  LocalDate dataNascimento, Endereco endereco) {
		this.clienteId = clienteId;
		this.nomeCompleto = nomeCompleto;
		this.email = email;
		this.cpf = cpf;
		this.telefone = telefone;
		this.dataNascimento = dataNascimento;
		this.endereco = endereco;
	}

	public Integer getClienteId() {
		return clienteId;
	}

	public void setClienteId(Integer clienteId) {
		this.clienteId = clienteId;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
}
