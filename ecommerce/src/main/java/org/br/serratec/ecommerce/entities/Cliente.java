package org.br.serratec.ecommerce.entities;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;

@Entity
@Table(name = "cliente")
@JsonIdentityInfo(
		generator = ObjectIdGenerators.PropertyGenerator.class,
		property = "clienteId",
		scope = Cliente.class
		)

public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cliente_id")
	private Integer clienteId;
	
	@Email(message = "Preencha o campo email corretamente exemplo@exemplo")
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
	
	@OneToMany(mappedBy = "cliente")
	private List<Endereco> enderecos;

	public Cliente() {
	}

	public Cliente(Integer cliente, String email, String nomeCompleto, String cpf, String telefone,
			LocalDate data_nascimento, Endereco endereco) {
		this.clienteId = cliente;
		this.email = email;
		this.nomeCompleto = nomeCompleto;
		this.cpf = cpf;
		this.telefone = telefone;
		this.dataNascimento = data_nascimento;
		this.endereco = endereco;
	}

	public Integer getClienteId() {
		return clienteId;
	}

	protected void setClienteId(Integer clienteId) {
		this.clienteId = clienteId;
	}

	protected String getEmail() {
		return email;
	}

	protected void setEmail(String email) {
		this.email = email;
	}

	protected String getNomeCompleto() {
		return nomeCompleto;
	}

	protected void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	protected String getCpf() {
		return cpf;
	}

	protected void setCpf(String cpf) {
		this.cpf = cpf;
	}

	protected String getTelefone() {
		return telefone;
	}

	protected void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	protected LocalDate getDataNascimento() {
		return dataNascimento;
	}

	protected void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	protected Endereco getEndereco() {
		return endereco;
	}

	protected void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	protected List<Endereco> getEnderecos() {
		return enderecos;
	}

	protected void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

}
