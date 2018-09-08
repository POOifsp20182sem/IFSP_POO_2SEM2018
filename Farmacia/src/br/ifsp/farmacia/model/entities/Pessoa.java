package br.ifsp.farmacia.model.entities;

import java.time.LocalDate;

public abstract class Pessoa {
	private String nome;
	private LocalDate dataNascimento;
	private Endereco endereco;
	private String email;
	private String telefone;
	private String documento;


	public Pessoa(String nome, LocalDate dataNascimento, Endereco endereco, String email, String telefone, String documento) {
		this.setNome(nome);
		this.setDataNascimento(dataNascimento);
		this.setEndereco(endereco);
		this.setEmail(email);
		this.setTelefone(telefone);
		this.setDocumento(documento);
	}

	public Pessoa() {}	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public String getStrDataNascimento() {
		return this.dataNascimento.getDayOfMonth() + "." +
				this.dataNascimento.getMonthValue() + "." +
				this.dataNascimento.getYear();
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

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}
}