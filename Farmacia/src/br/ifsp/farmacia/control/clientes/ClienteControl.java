package br.ifsp.farmacia.control.clientes;

import br.ifsp.farmacia.model.persistence.clientes.IClienteDAO;

import java.sql.SQLException;

import br.ifsp.farmacia.model.entities.Cliente;
import br.ifsp.farmacia.model.persistence.clientes.ClienteDAO;

public class ClienteControl {
	IClienteDAO cd = new ClienteDAO();
	
	public void CadastrarCliente (Cliente cli) throws SQLException{
		cd.insertCliente(cli);
	}
	
	public void AtualizarCliente (Cliente cli) throws SQLException{
		cd.updateCliente(cli);
	}
	
	public void DeletarCliente (Cliente cli) throws SQLException{
		cd.deleteCliente(cli);
	}
}
