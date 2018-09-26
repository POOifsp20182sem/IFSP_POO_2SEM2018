package br.ifsp.farmacia.model.persistence.login;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.CallableStatement;

import br.ifsp.farmacia.model.entities.Login;
import br.ifsp.farmacia.model.persistence.MySqlConnection;


public class LoginDAO implements ILoginDAO{

	@Override
	//TODO:2018-09-19:ed:Talvez esse método possa ser estático
	public boolean validarLogin(Login login) throws SQLException {
		Connection conn = null;
		CallableStatement cs = null;
		
		try {
			/***
			 * Faz a validação do login
			 * recebe nome e senha e busca no banco
			 * @param outputValue recebe o valor de validacao (TRUE or FALSE)
			 * Caso a validação seja válida ou não, retorna mensagem
			 * que descreve o status atual
			 */
			boolean outputValue;
			String query = "{? = call validar_login(?, ?)}"; 

			conn = MySqlConnection.getConnection();
			cs = conn.prepareCall(query);	

			cs.registerOutParameter(1, java.sql.Types.BOOLEAN);
			cs.setString(2, login.getUserName());
			cs.setString(3, login.getPassword());
			cs.execute();
			
			outputValue = cs.getBoolean(1);
			
			//Essas mensagens são apenas para teste
			//porém podem ser adaptadas para serem usadas
			//no acesso
			if(outputValue) {
				System.out.println("Acesso permitido!");
				return true;
			}
			else 
				System.out.println("Acesso negado!");
	
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}

		return false;
	}

	

}
