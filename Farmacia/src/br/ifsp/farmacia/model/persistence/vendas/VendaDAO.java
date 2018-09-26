package br.ifsp.farmacia.model.persistence.vendas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.ifsp.farmacia.model.entities.ClasseTerapeutica;
import br.ifsp.farmacia.model.entities.Produto;
import br.ifsp.farmacia.model.entities.Venda;
import br.ifsp.farmacia.model.persistence.MySqlConnection;

public class VendaDAO implements IVendaDAO{

	@Override
	public boolean insertVenda(Venda ven) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			String query = "{call inserir_produto(?, ?, ?, ?, ?)}"; 

			conn = MySqlConnection.getConnection();
			ps = conn.prepareStatement(query);		

			ps.setString(1, ven.getDataNascFormatado());
			ps.setInt(2, ven.getIdCliente());
			ps.setInt(3, ven.getIdFuncionario());
			ps.setDouble(4, ven.getTotal());
			ps.setDouble(5, ven.getDesconto());

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
	public boolean updateVenda(Venda ven) throws SQLException {
		
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			String query = "{call inserir_produto(?, ?, ?, ?, ?)}"; 

			conn = MySqlConnection.getConnection();
			ps = conn.prepareStatement(query);		

			ps.setString(1, ven.getDataNascFormatado());
			ps.setInt(2, ven.getIdCliente());
			ps.setInt(3, ven.getIdFuncionario());
			ps.setDouble(4, ven.getTotal());
			ps.setDouble(5, ven.getDesconto());
			
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
	}		return false;
	}

	@Override
	public boolean deleteVenda(Venda ven) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		try {

			String query = "{call excluir_pedido(?)}"; 

			conn = MySqlConnection.getConnection();
			ps = conn.prepareStatement(query);		
			
			ps.setInt(0, ven.getId());

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
		}		return false;
	}

	@Override
	public ArrayList<Venda> selectVenda(String filter) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		
		ArrayList<Venda> listVendas = new ArrayList<>();
		Venda ven = new Venda();
		
		try {
			String query = "{call buscar_pedidos(?)}"; 

			conn = MySqlConnection.getConnection();
			ps = conn.prepareStatement(query);		

			ps.setString(1, filter);

			ResultSet result = ps.executeQuery();

			while(result.next()) {
				ven = new Venda();
				
				ven.setId(result.getInt("id"));
				ven.setData(result.getDate("data_compra"));
				ven.setIdCliente(result.getInt("apresentacao"));
				
				ven.setIdFuncionario(result.getInt("fabricante"));
				ven.setTotal(result.getDouble("unidade_medida"));
				ven.setDesconto(result.getDouble("registro_ms"));

				listVendas.add(ven);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			conn.close();
		}
		return listVendas;
	}

	@Override
	public ArrayList<Venda> selectVenda() throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		
		ArrayList<Venda> listVendas = new ArrayList<>();
		Venda ven = new Venda();
		
		try {
			String query = "{call buscar_pedidos()}"; 
			conn = MySqlConnection.getConnection();
			ps = conn.prepareStatement(query);		
			
			ResultSet result = ps.executeQuery();
			
			while(result.next()) {
				ven = new Venda();
				ven.setId(result.getInt("id"));
				ven.setIdCliente(result.getInt("cliente_id"));
				listVendas.add(ven);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			conn.close();
		}
		return listVendas;
	}
	
	

}
