package br.ifsp.farmacia.model.persistence.funcionarios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import br.ifsp.farmacia.model.entities.Funcionario;
import br.ifsp.farmacia.model.persistence.MySqlConnection;

public class FuncionarioDAO implements IFuncionarioDAO{
	@Override
	public boolean insertFuncionario(Funcionario func) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			String query = "{call inserir_funcionario(?, ?, ?, ?, ?, ?, ?, ?, ?)}"; 

			conn = MySqlConnection.getConnection();
			ps = conn.prepareStatement(query);		

			ps.setString(1, func.getNome());
			ps.setString(2, func.getEmail());
			ps.setString(3, func.getEndereco().toString());
			ps.setString(4, func.getTelefone());
			ps.setString(5, func.getCelular());
			ps.setString(6, func.getDocumento());
			ps.setString(7, func.getStrDataNascimento());
			ps.setString(8, func.getTipoFuncionario().toString());


			if(ps.executeUpdate() == 0) {
				System.out.println("Erro ao inserir!");
			}
			else {
				System.out.println("Dado inserido com sucesso!");
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}

		return false;
	}

	@Override
	public boolean updateFuncionario(Funcionario func) throws SQLException {
		PreparedStatement ps = null;
		Connection conn = null;
		try {
			String query = "{call alterar_funcionario(?,?,?,?,?,?,?,?,?,?) }"; 

			conn = MySqlConnection.getConnection();
			ps = conn.prepareStatement(query);		

			ps.setInt(1, func.getId());
			ps.setString(2, func.getNome());
			ps.setString(3, func.getEmail());
			ps.setString(4, func.getEndereco().toString());
			ps.setString(5, func.getTelefone());
			ps.setString(6, func.getCelular());
			ps.setString(7, func.getDocumento());
			ps.setString(8, func.getStrDataNascimento());
			ps.setString(9, func.getTipoFuncionario().toString());
			ps.setDouble(10, func.getSalario());

			if(ps.executeUpdate() == 0) {
				System.out.println("Erro ao atualizar!");
			} else {
				System.out.println("Dado atualizado com sucesso!");
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}

		return false;
	}

	@Override
	public boolean deleteFuncionario(Funcionario func) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			String query = "{call excluir_funcionario(?) }"; 

			conn = MySqlConnection.getConnection();
			ps = conn.prepareStatement(query);		

			ps.setInt(1, func.getId());

			if(ps.executeUpdate() == 0) {
				System.out.println("Erro ao excluir!");
			} else {
				System.out.println("Dado excluido com sucesso!");
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}

		return false;
	}

	@Override
	public ArrayList<Funcionario> selectFuncionario(String filter) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Funcionario> selectFuncionario() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
