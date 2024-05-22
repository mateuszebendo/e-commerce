package org.br.serratec.ecommerce.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cliente")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cliente_id")
	private Integer clienteId;

	@Column(name = "email", unique = true)
	private String email;

	@Column(name = "nome_completo")
	private String nomeCompleto;

	@Column(name = "cpf")
	private String cpf;

	@Column(name = "telefone")
	private String telefone;

	@Column(name = "data_nascimento")
	private LocalDate dataNascimento;

	@Column(name = "endereco")
	private Endereco endereco;

	public Cliente() {
		super();
	}

	public Cliente(Integer clienteId, String email, String nomeCompleto, String cpf, String telefone,
			LocalDate dataNascimento, Endereco endereco) {
		this.clienteId = clienteId;
		this.email = email;
		this.nomeCompleto = nomeCompleto;
		this.cpf = cpf;
		this.telefone = telefone;
		this.dataNascimento = dataNascimento;
		this.endereco = endereco;
	}

	public Integer getCliente() {
		return clienteId;
	}

	public void setCliente(Integer clienteId) {
		this.clienteId = clienteId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
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

	public LocalDate getData_nascimento() {
		return dataNascimento;
	}

	public void setData_nascimento(LocalDate data_nascimento) {
		this.dataNascimento = data_nascimento;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

}
