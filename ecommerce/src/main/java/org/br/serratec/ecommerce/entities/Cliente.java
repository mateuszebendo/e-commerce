package org.br.serratec.ecommerce.entities;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import org.br.serratec.ecommerce.dtos.ClienteDTO;

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
	}
  
	public Cliente(ClienteDTO clienteDto) {
		this.clienteId = clienteDto.getClienteId();
		this.email = clienteDto.getEmail();
		this.nomeCompleto = clienteDto.getNomeCompleto();
		this.cpf = clienteDto.getCpf();
		this.telefone = clienteDto.getTelefone();
		this.dataNascimento = clienteDto.getDataNascimento();
		this.endereco = clienteDto.getEndereco();
	}

	public Integer getCliente() {
		return clienteId;
	}

	public void setCliente(Integer clienteId) {
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

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

}
