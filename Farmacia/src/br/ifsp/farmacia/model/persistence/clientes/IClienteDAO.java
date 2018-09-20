package br.ifsp.farmacia.model.persistence.clientes;

import java.util.ArrayList;
import java.sql.SQLException;

import br.ifsp.farmacia.model.entities.Cliente;

public interface IClienteDAO {
	
	public boolean insertCliente(Cliente cli);
	public boolean updateCliente(Cliente cli);
	public boolean deleteCliente(Cliente cli);
	public ArrayList<Cliente> selectCliente(String filter) throws SQLException;
	public ArrayList<Cliente> selectCliente() throws SQLException;
}
