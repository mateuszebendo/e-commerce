package org.br.serratec.ecommerce.dtos;

public class ConsultaCepDTO {

	private String logradouro;
	private String bairro;
	private String localidade;
	private String uf;

	public ConsultaCepDTO() {

	}

	public ConsultaCepDTO(String logradouro, String bairro, String localidade, String uf) {
		super();
		this.logradouro = logradouro;
		this.bairro = bairro;
		this.localidade = localidade;
		this.uf = uf;
	}

	public String getlogradouro() {
		return logradouro;
	}

	public void setlogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getlocalidade() {
		return localidade;
	}

	public void setlocalidade(String localidade) {
		this.localidade = localidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

}
