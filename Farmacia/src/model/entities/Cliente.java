package model.entities;

import java.util.Calendar;

public class Cliente extends Pessoa {
	//não inserido no construtor
	private int id;
	private EnumCliente tipoCliente;
	private String documento;  // CNPJ/CPF
	private boolean especial;  // aposentado
	//rever isso
	private String celular;

	public Cliente(String nome, Calendar dataNascimento, Endereco endereco, String email, String telefone,
			 String celular, EnumCliente tipoCliente, String documento, boolean especial) {
		super(nome, dataNascimento, endereco, email, telefone);

		this.setTipoCliente(tipoCliente);
		this.setDocumento(documento);
		this.setEspecial(especial);
		this.setCelular(celular);
	}

	public Cliente() {}

	public EnumCliente getTipoCliente() {
		return tipoCliente;
	}

	public void setTipoCliente(EnumCliente tipoCliente) {
		this.tipoCliente = tipoCliente;
	}

	public String getDocumento() {
		return this.documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public boolean isEspecial() {
		return this.especial;
	}

	public void setEspecial(boolean isEspecial) {
		this.especial = isEspecial;
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