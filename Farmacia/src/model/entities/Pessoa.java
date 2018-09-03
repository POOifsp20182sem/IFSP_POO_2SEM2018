package model.entities;

import java.util.Calendar;

public abstract class Pessoa {
	private String nome;
	private Calendar dataNascimento;
	private Endereco endereco;
	private String email;
	private String telefone;  // rever isso

	public Pessoa(String nome, Calendar dataNascimento, Endereco endereco, String email, String telefone) {
		this.setNome(nome);
		this.setDataNascimento(dataNascimento);
		this.setEndereco(endereco);
		this.setEmail(email);
		this.setTelefone(telefone);
	}

	public Pessoa() {}	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Calendar getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
}