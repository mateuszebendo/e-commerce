package org.br.serratec.ecommerce.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "endereco")
public class Endereco {

	// id_endereco, cep, rua, bairro, cidade, numero, complemento, uf
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_endereco")
	private Integer idEndereco;
	
	@Column(name = "cep")
	private Integer cep;
	
	@Column(name = "rua")
	private Integer rua;
	
	@Column(name = "bairro")
	private Integer bairro;
	
	@Column(name = "cidade")
	private Integer cidade;
	
	@Column(name = "numero")
	private Integer numero;
	
	@Column(name = "complemento")
	private Integer complemento;
	
	@Column(name = "uf")
	private Integer uf;
	
	@OneToOne
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;
	
	
	public Integer getIdEndereco() {
		return idEndereco;
	}

	public void setIdEndereco(Integer idEndereco) {
		this.idEndereco = idEndereco;
	}

	public Integer getCep() {
		return cep;
	}

	public void setCep(Integer cep) {
		this.cep = cep;
	}

	public Integer getRua() {
		return rua;
	}

	public void setRua(Integer rua) {
		this.rua = rua;
	}

	public Integer getBairro() {
		return bairro;
	}

	public void setBairro(Integer bairro) {
		this.bairro = bairro;
	}

	public Integer getCidade() {
		return cidade;
	}

	public void setCidade(Integer cidade) {
		this.cidade = cidade;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Integer getComplemento() {
		return complemento;
	}

	public void setComplemento(Integer complemento) {
		this.complemento = complemento;
	}

	public Integer getUf() {
		return uf;
	}

	public void setUf(Integer uf) {
		this.uf = uf;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
	
	
}
