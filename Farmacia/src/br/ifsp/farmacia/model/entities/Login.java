package br.ifsp.farmacia.model.entities;

public class Login {
	private String userName;
	//TODO:2018-09-19:ed:O tipo n�o � apropriado para o campo
	//por�m ser� mantido por quest�es pr�ticas
	private String password;
	
	public Login() {}
	
	public Login(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
