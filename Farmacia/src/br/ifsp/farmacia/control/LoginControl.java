package br.ifsp.farmacia.control;

import java.sql.SQLException;

import br.ifsp.farmacia.model.entities.Login;
import br.ifsp.farmacia.model.persistence.LoginDAO;

public class LoginControl {
	
	/*Japa, chama a implementação, não a interface*/
	LoginDAO ld = new LoginDAO();
	
	public boolean validarLogin(Login login) throws SQLException {
		return ld.validarLogin(login);
	}
}
