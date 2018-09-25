package br.ifsp.farmacia.control.login;

import br.ifsp.farmacia.model.persistence.login.LoginDAO;

import java.sql.SQLException;

import br.ifsp.farmacia.model.entities.Login;

public class LoginControl {
	
	/*Japa, chama a implementação, não a interface*/
	LoginDAO ld = new LoginDAO();
	
	public boolean validarLogin(Login login) throws SQLException {
		return ld.validarLogin(login);
	}
}
