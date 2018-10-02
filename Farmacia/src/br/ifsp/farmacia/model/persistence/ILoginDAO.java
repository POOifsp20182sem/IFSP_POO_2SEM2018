package br.ifsp.farmacia.model.persistence;

import java.sql.SQLException;

import br.ifsp.farmacia.model.entities.Login;

public interface ILoginDAO {

	public boolean validarLogin(Login login) throws SQLException;
}
