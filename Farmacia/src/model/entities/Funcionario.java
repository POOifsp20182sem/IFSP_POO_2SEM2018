package model.entities;

import java.util.Calendar;

public class Funcionario extends Pessoa {
	//n�o inserido no construtor
	private int id;
	private double salario;
	private EnumFuncionario tipoFuncionario;
	private String celular;
	
	/*
	 * Ser� que o melhor � usar id mesmo? Ou usar o cpf do funcion�rio?
	 * */
	

	public Funcionario(String nome, Calendar dataNascimento, Endereco endereco, String email, String telefone,
			String celular,double salario, EnumFuncionario tipoFuncionario) {
		super(nome, dataNascimento, endereco, email, telefone);

		this.setCelular(celular);
		this.setSalario(salario);
		this.setTipoFuncionario(tipoFuncionario);
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public EnumFuncionario getTipoFuncionario() {
		return tipoFuncionario;
	}

	public void setTipoFuncionario(EnumFuncionario tipoFuncionario) {
		this.tipoFuncionario = tipoFuncionario;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}	
	
	
}