package br.ifsp.farmacia.model.persistence.produtos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import br.ifsp.farmacia.model.entities.Produto;
import br.ifsp.farmacia.model.persistence.MySqlConnection;

public class ProdutoDAO implements IProdutoDAO {

	@Override
	public boolean insertProduto(Produto prod) throws SQLException {
		
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			String query = "{call inserir_produto(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}"; 

			conn = MySqlConnection.getConnection();
			ps = conn.prepareStatement(query);		

			ps.setString(1, prod.getNomeComercial());
			ps.setString(2, prod.getApresentacao());
			ps.setString(3, prod.getFormaFarmaco().toString());
			ps.setString(4, prod.getFabricante());
			ps.setString(5, prod.getPrincipioAtivo());
			ps.setString(6, prod.getUnidadeMedida());
			ps.setString(7, prod.getRegistroMS());
			ps.setString(8, prod.getCodigoBarras());
			ps.setString(9, prod.getClasseTerapeutica());
			ps.setInt(10, prod.getQtde());

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
	public boolean updateProduto(Produto prod) throws SQLException {

		Connection conn = null;
		PreparedStatement ps = null;
		try {
			String query = "{call alterar_produto(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}"; 

			conn = MySqlConnection.getConnection();
			ps = conn.prepareStatement(query);		
			
			ps.setInt(1, prod.getId());
			ps.setString(2, prod.getNomeComercial());
			ps.setString(3, prod.getApresentacao());
			ps.setString(4, prod.getFormaFarmaco().toString());
			ps.setString(5, prod.getFabricante());
			ps.setString(6, prod.getPrincipioAtivo());
			ps.setString(7, prod.getUnidadeMedida());
			ps.setString(8, prod.getRegistroMS());
			ps.setString(9, prod.getCodigoBarras());
			ps.setString(10, prod.getClasseTerapeutica());
			ps.setInt(11, prod.getQtde());

			if(ps.executeUpdate() == 0) {
				System.out.println("Erro ao alterar!");
			}
			else {
				System.out.println("Dado alterado com sucesso!");
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
	public boolean deleteProduto(Produto prod) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			
			//TODO:2018-09-10:ed:refatorar o procedure de produto para
			//que ele seja somente omitido caso ele esteja associado a
			//algum pedido ou coisa do tipo
			String query = "{call excluir_produto(?)}"; 

			conn = MySqlConnection.getConnection();
			ps = conn.prepareStatement(query);		
			
			ps.setInt(1, prod.getId());

			if(ps.executeUpdate() == 0) {
				System.out.println("Erro ao alterar!");
			}
			else {
				System.out.println("Dado alterado com sucesso!");
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
	public ArrayList<Produto> selectProduto(String filter) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Produto> selectProduto() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
