package org.br.serratec.ecommerce.dtos;

public class ConsultaCepDTO {

	// cep, rua, bairro, localidade, numero, complemento, uf
	private String logradouro;
	private String bairro;
	private String localidade;
	private String uf;

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
