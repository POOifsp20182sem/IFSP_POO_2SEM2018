package br.ifsp.farmacia.model.entities;

public class Produto {
	
	private int id;
	private String nomeComercial;
	private String apresentacao;
	private EnumFormaFarmaco formaFarmaco;
	private String fabricante; //TODO: Verificar necessidade
	private String principioAtivo;
	private String unidadeMedida; //TODO: verificar necessidade, caso necessario criar enumUnidadeMedida
	//TODO: Verificar necessidade do campo "popular" 
	//TODO: Verificar necessidade do campo "generico"
	private String registroMS;
	private String codigoBarras;
	private String classeTerapeutica;
	private int qtde;

	public Produto(String nomeComercial, String apresentacao, EnumFormaFarmaco formaFarmaco, String fabricante,
			String principioAtivo, String unidadeMedida, String registroMS, String codigoBarras,
			String classeTerapeutica, int qtde) {
		super();
		this.nomeComercial = nomeComercial;
		this.apresentacao = apresentacao;
		this.formaFarmaco = formaFarmaco;
		this.fabricante = fabricante;
		this.principioAtivo = principioAtivo;
		this.unidadeMedida = unidadeMedida;
		this.registroMS = registroMS;
		this.codigoBarras = codigoBarras;
		this.classeTerapeutica = classeTerapeutica;
		this.qtde = qtde;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomeComercial() {
		return nomeComercial;
	}

	public void setNomeComercial(String nomeComercial) {
		this.nomeComercial = nomeComercial;
	}

	public String getApresentacao() {
		return apresentacao;
	}

	public void setApresentacao(String apresentacao) {
		this.apresentacao = apresentacao;
	}

	public EnumFormaFarmaco getFormaFarmaco() {
		return formaFarmaco;
	}

	public void setFormaFarmaco(EnumFormaFarmaco formaFarmaco) {
		this.formaFarmaco = formaFarmaco;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public String getPrincipioAtivo() {
		return principioAtivo;
	}

	public void setPrincipioAtivo(String principioAtivo) {
		this.principioAtivo = principioAtivo;
	}

	public String getUnidadeMedida() {
		return unidadeMedida;
	}

	public void setUnidadeMedida(String unidadeMedida) {
		this.unidadeMedida = unidadeMedida;
	}

	public String getRegistroMS() {
		return registroMS;
	}

	public void setRegistroMS(String registroMS) {
		this.registroMS = registroMS;
	}

	public String getCodigoBarras() {
		return codigoBarras;
	}

	public void setCodigoBarras(String codigoBarras) {
		this.codigoBarras = codigoBarras;
	}

	public String getClasseTerapeutica() {
		return classeTerapeutica;
	}

	public void setClasseTerapeutica(String classeTerapeutica) {
		this.classeTerapeutica = classeTerapeutica;
	}

	public int getQtde() {
		return qtde;
	}

	public void setQtde(int qtde) {
		this.qtde = qtde;
	}
	
}
