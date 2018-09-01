package model.entities;

public enum EnumFuncionario {
	GERENTE("gerente"), ATENDENTE("atendente");

	private String tipoFuncionario;

	private EnumFuncionario(String tipoFuncionario) {
		this.tipoFuncionario = tipoFuncionario;
	}

	@SuppressWarnings("unused")
	private String getTipoFuncionario() {
		return this.tipoFuncionario;
	}
}