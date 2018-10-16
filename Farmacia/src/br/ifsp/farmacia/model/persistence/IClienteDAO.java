package br.ifsp.farmacia.model.persistence;

import java.util.ArrayList;
import java.sql.SQLException;

import br.ifsp.farmacia.model.entities.Cliente;

public interface IClienteDAO {
	
	public boolean insertCliente(Cliente cli) throws SQLException;
	public boolean updateCliente(Cliente cli) throws SQLException;
	public boolean deleteCliente(Cliente cli) throws SQLException;
	public ArrayList<Cliente> selectCliente(String filter) throws SQLException;
	public ArrayList<Cliente> selectCliente() throws SQLException;
	public Cliente buscarCliente(int id) throws SQLException;
}
