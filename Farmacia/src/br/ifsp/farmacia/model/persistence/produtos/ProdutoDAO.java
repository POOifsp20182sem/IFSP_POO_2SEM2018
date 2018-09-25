package br.ifsp.farmacia.model.persistence.produtos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import br.ifsp.farmacia.model.entities.ClasseTerapeutica;
import br.ifsp.farmacia.model.entities.Cliente;
import br.ifsp.farmacia.model.entities.PrincipioAtivo;
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
			ps.setString(5, prod.getUnidadeMedida());
			ps.setString(6, prod.getRegistroMS());
			ps.setString(7, prod.getCodigoBarras());
			ps.setInt(8, prod.getPrincipioAtivo().getId());
			ps.setInt(9, prod.getClasseTerapeutica().getId());
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
			ps.setString(6, prod.getUnidadeMedida());
			ps.setString(7, prod.getRegistroMS());
			ps.setString(8, prod.getCodigoBarras());
			ps.setInt(9, prod.getPrincipioAtivo().getId());
			ps.setInt(10, prod.getClasseTerapeutica().getId());
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
		Connection conn = null;
		PreparedStatement ps = null;
		
		ArrayList<Produto> listProdutos = new ArrayList<>();
		Produto prod = new Produto();
		
		try {
			String query = "{call buscar_produtos(?)}"; 

			conn = MySqlConnection.getConnection();
			ps = conn.prepareStatement(query);		

			ps.setString(1, filter);

			ResultSet result = ps.executeQuery();
			/***
			 * Gera um produto no mesmo espaço de memória
			 */
			while(result.next()) {
				prod = new Produto();
				
				prod.setId(result.getInt("id"));
				prod.setNomeComercial(result.getString("nome_comercial"));
				prod.setApresentacao(result.getString("apresentacao"));
				
				// TODO:2018-09-14:ed:criar sobrecarga para lidar com a conversão
				//prod.setFormaFarmaco(result.getString("forma_farmaco"));
				
				prod.setFabricante(result.getString("fabricante"));
				prod.setUnidadeMedida(result.getString("unidade_medida"));
				prod.setRegistroMS(result.getString("registro_ms"));
				prod.setCodigoBarras(result.getString("codigo_barras"));
				prod.setQtde(result.getInt("id"));
				
				// TODO:2018-09-14:ed:Por esses dados serem chaves estrangeiras
				// o modo de abordar o problema precisa mudar.
				//prod.setClasseTerapeutica(classeTerapeutica);
				//prod.setPrincipioAtivo();
				
				listProdutos.add(prod);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			conn.close();
		}
		
		return listProdutos;
		
	}

	@Override
	public ArrayList<Produto> selectProduto() throws SQLException {
		return selectProduto("");
	}
	
	public ArrayList<PrincipioAtivo> selectPrincipioAtivo() throws SQLException{
		Connection conn = null;
		PreparedStatement ps = null;
		
		ArrayList<PrincipioAtivo> principiosAtivos = new ArrayList<>();
		PrincipioAtivo princ = new PrincipioAtivo();
		
		try {
			String query = "{call buscar_principio_ativo()}"; 
			conn = MySqlConnection.getConnection();
			ps = conn.prepareStatement(query);		

			ResultSet result = ps.executeQuery();

			while(result.next()) {
				princ = new PrincipioAtivo();
				princ.setId(result.getInt("id"));
				princ.setNome(result.getString("nome"));
				principiosAtivos.add(princ);
			}
	
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			conn.close();
		}
		
		return principiosAtivos;
	}
	
	public ArrayList<ClasseTerapeutica> selectClasseTerapeutica() throws SQLException{
		Connection conn = null;
		PreparedStatement ps = null;
		
		ArrayList<ClasseTerapeutica> classesTerapeuticas = new ArrayList<>();
		ClasseTerapeutica cla = new ClasseTerapeutica();
		
		try {
			String query = "{call buscar_classe_terapeutica()}"; 
			conn = MySqlConnection.getConnection();
			ps = conn.prepareStatement(query);		
			
			ResultSet result = ps.executeQuery();
			
			while(result.next()) {
				cla = new ClasseTerapeutica();
				cla.setId(result.getInt("id"));
				cla.setNome(result.getString("nome"));
				classesTerapeuticas.add(cla);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			conn.close();
		}
		return classesTerapeuticas;
	}
}
