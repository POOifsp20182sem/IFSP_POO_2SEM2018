package br.ifsp.farmacia.control;

import java.sql.SQLException;
import java.util.ArrayList;

import br.ifsp.farmacia.model.entities.Cliente;
import br.ifsp.farmacia.model.persistence.ClienteDAO;

public class ClienteControl {
	
	ClienteDAO cd = new ClienteDAO();
	
	public boolean CadastrarCliente (Cliente cli) throws SQLException{
		return cd.insertCliente(cli);
	}
	
	public boolean AtualizarCliente (Cliente cli) throws SQLException{
		return cd.updateCliente(cli);
	}
	
	public boolean DeletarCliente (Cliente cli) throws SQLException{
		return cd.deleteCliente(cli);
	}
	
	public ArrayList<Cliente> listarCliente (String filtro) throws SQLException {
		return cd.selectCliente();
	}
	
	public ArrayList<Cliente> listarCliente () throws SQLException {
		return cd.selectCliente();
	}

	public Cliente buscarCliente(int id) throws SQLException {
		return cd.buscarCliente(id);
	}
}
