package br.ifsp.farmacia.testes;

import br.ifsp.farmacia.model.entities.Login;
import br.ifsp.farmacia.model.persistence.LoginDAO;

public class TesteLogin {

	public static void main(String[] args) {
		
		try {
			Login login = new Login("eder","123");
			LoginDAO loginDao = new LoginDAO();
			loginDao.validarLogin(login);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
