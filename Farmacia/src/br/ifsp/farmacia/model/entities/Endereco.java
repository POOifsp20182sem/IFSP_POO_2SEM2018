package br.ifsp.farmacia.model.entities;

public class Endereco {
	private String logradouro;
	private String numero;
	private String cidade;
	private String bairro;

	
	public Endereco() {
		
	}
	//TODO:25-09-2018:ed:criei para simplificar a cria��o
	//por�m pode ser melhorado
	
	public Endereco(String logradouro, String numero, String bairro, String cidade) {
		this.logradouro = logradouro;
		this.numero = numero;
		this.cidade = cidade;
		this.bairro = bairro;
	}
	
	
	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	@Override
	public String toString() {
		return cidade + ", " + logradouro + ", " + numero + ", " + bairro; 
	}
}
