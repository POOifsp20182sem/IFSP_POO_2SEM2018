package br.ifsp.farmacia.model.entities;

public class Endereco {
	private String logradouro;
	private String numero;
	private String cidade;
	private String complemento;

	
	public Endereco() {
		
	}
	//TODO:25-09-2018:ed:criei para simplificar a criação
	//porém pode ser melhorado
	public Endereco(String endereco) {
		String [] strings = endereco.split(";");
		this.logradouro = strings[0];
		this.numero = strings[1];
		this.cidade = strings[2];
		this.complemento = strings[3];
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

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	@Override
	public String toString() {
		return cidade + ", " + logradouro + ", " + numero + ", " + complemento; 
	}
}
