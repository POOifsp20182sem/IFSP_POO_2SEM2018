package Model.Entities;

import java.util.Calendar;

public class Cliente extends Pessoa {
	private EnumCliente tipoCliente;
	private String documento;  // CNPJ/CPF
	private boolean especial;  // aposentado 

	public Cliente(String nome, Calendar dataNascimento, Endereco endereco, String email, String contato,
			EnumCliente tipoCliente, String documento, boolean especial) {
		super(nome, dataNascimento, endereco, email, contato);

		this.setTipoCliente(tipoCliente);
		this.setDocumento(documento);
		this.setEspecial(especial);
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
}