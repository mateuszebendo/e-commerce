package org.br.serratec.ecommerce.entities;

import java.time.LocalDate;
import java.util.List;

import org.br.serratec.ecommerce.dtos.ClienteDTO;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "cliente")
public class Cliente{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cliente_id")
	private Integer clienteId;

	@Column(name = "email", unique = true)
	private String email;

	@Column(name = "nome_completo")
	private String nomeCompleto;

	@Column(name = "cpf", unique = true)
	private String cpf;

	@Column(name = "telefone")
	private String telefone;

	@Column(name = "data_nascimento")
	private LocalDate dataNascimento;

	@OneToOne
	@JoinColumn(name = "endereco_id")
	private Endereco endereco;

	@JsonIgnore
	@OneToMany(mappedBy = "cliente")
	private List<Pedido> pedidos;


	public Cliente() {
	}

	public Cliente(ClienteDTO clienteDto) {
		this.clienteId = clienteDto.getClienteId();
		this.nomeCompleto = clienteDto.getNomeCompleto();
		this.email = clienteDto.getEmail();
		this.cpf = clienteDto.getCpf();
		this.telefone = clienteDto.getTelefone();
		this.dataNascimento = clienteDto.getDataNascimento();
		this.endereco = clienteDto.getEndereco();
	}

	public Integer getClienteId() {
		return clienteId;
	}

	public void setClienteId(Integer clienteId) {
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

	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	@Override
	public String toString() {
		var enderecoString = new StringBuilder();
		enderecoString.append(endereco.toString()).append("\n");

		return String.format(
						"Nome           : %s\n" +
						"Telefone       : %s\n" +
						"--------------------------------------------------------\n" +
						"%s",
				nomeCompleto,
				telefone,
				enderecoString
		);
	}
}
