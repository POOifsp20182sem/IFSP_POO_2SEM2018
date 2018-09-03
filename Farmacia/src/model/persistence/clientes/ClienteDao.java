package model.persistence.clientes;

import model.entities.Cliente;

public interface ClienteDao {
	
	public boolean insertCliente(Cliente cli);
	public boolean updateCliente(Cliente cli);
	public boolean deleteCliente(Cliente cli);
	public Cliente[] selectCliente(String filter);
	public Cliente[] selectCliente();
}
