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
	
	//TODO: formatada para o banco
	public String getDataNascFormatado() {
		return this.dataNascimento.getYear() + "-" +
				this.dataNascimento.getMonthValue() + "-" +
				this.dataNascimento.getDayOfMonth();
	}
	
	
	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	//TODO:25-09-2018:ed:Overloading de setNascimento
	//acho que da pra usar lambda ou fazer de modo mais bonito
	public void setDataNascimento(String dataNascimento) {
		String [] strings = dataNascimento.split("/"); 
		int dia,mes,ano;
		dia = Integer.parseInt(strings[0]);
		mes = Integer.parseInt(strings[1]);
		ano = Integer.parseInt(strings[2]);
		this.dataNascimento = LocalDate.of(ano, mes, dia);
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	//TODO: Criado para auxiliar no retorno dos dados do banco
	public void setEndereco(String endereco) {
		String[] strings = endereco.split(",");
		String logradouro, numero, bairro, cidade;
		
		logradouro = strings[0];
		numero = strings[1];
		bairro = strings[2];
		cidade = strings[3];
		this.endereco = new Endereco(logradouro, numero, bairro, cidade);	
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