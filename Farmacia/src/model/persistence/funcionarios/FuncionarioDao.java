package model.persistence.funcionarios;

import java.sql.SQLException;

import model.entities.Funcionario;

public interface FuncionarioDao {
	
	public boolean insertFuncionario(Funcionario func) throws SQLException;
	public boolean updateFuncionario(Funcionario func)throws SQLException;
	public boolean deleteFuncionario(Funcionario func)throws SQLException;
	public Funcionario[] selectFuncionario(String filter)throws SQLException;
	public Funcionario[] selectFuncionario()throws SQLException;
}
