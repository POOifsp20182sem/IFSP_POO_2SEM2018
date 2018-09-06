package model.persistence.clientes;

import java.sql.SQLException;

import model.entities.Cliente;

public interface ClienteDao {
	
	//repensar sobre o retorno
	public boolean insertCliente(Cliente cli) throws SQLException;
	public boolean updateCliente(Cliente cli) throws SQLException;
	public boolean deleteCliente(Cliente cli) throws SQLException;
	public Cliente[] selectCliente(String filter) throws SQLException;
	public Cliente[] selectCliente() throws SQLException;
}
