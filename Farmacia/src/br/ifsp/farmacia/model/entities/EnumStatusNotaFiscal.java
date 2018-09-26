package br.ifsp.farmacia.model.entities;

public enum EnumStatusNotaFiscal {
	AUTORIZADA("autorizada"), CANCELADA("cancelada"), PROCESSANDO("processando");
	
	private String status;
	
	private EnumStatusNotaFiscal(String status) {
		this.status = status;
	}

	public String getFormaFarmaco() {
		return status;
	}
}
