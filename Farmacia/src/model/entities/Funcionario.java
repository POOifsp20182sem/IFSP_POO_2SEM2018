package model.entities;

import java.util.Calendar;

public class Funcionario extends Pessoa {
	private double salario;
	private EnumFuncionario tipoFuncionario;

	public Funcionario(String nome, Calendar dataNascimento, Endereco endereco, String email, String contato,
			double salario, EnumFuncionario tipoFuncionario) {
		super(nome, dataNascimento, endereco, email, contato);

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
}