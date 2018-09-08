package br.ifsp.farmacia.model.persistence.funcionarios;

import java.util.ArrayList;
import java.sql.SQLException;

import br.ifsp.farmacia.model.entities.Funcionario;

public interface IFuncionarioDAO {
	public boolean insertFuncionario(Funcionario func) throws SQLException;
	public boolean updateFuncionario(Funcionario func)throws SQLException;
	public boolean deleteFuncionario(Funcionario func)throws SQLException;
	public ArrayList<Funcionario> selectFuncionario(String filter)throws SQLException;
	public ArrayList<Funcionario> selectFuncionario()throws SQLException;
}