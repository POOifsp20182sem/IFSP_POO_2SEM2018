package br.ifsp.farmacia.model.persistence;

import java.util.ArrayList;
import java.util.Random;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.ifsp.farmacia.model.entities.NotaFiscal;
import br.ifsp.farmacia.model.entities.EnumStatusNotaFiscal;


public class NotaFiscalDAO implements INotaFiscalDAO {
	
	public boolean emitirNotaFiscal(NotaFiscal nfe) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			String query = "{call inserir_nota_fiscal(?, ?, ?, ?)}";
			Random rand = new Random();

			/*
			 * Chave e protocolo são definidos pela receita federal
			 */
			String chaveNfe = rand.nextLong() + "";
			String protocoloNfe = rand.nextLong() + "";
					
			conn = MySqlConnection.getConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, nfe.getNumero());
			/*
			 * O correto erra criar como PROCESSANDO, validar e depois autorizar,
			 * 	mas vamos pular essa parte.
			 */
			ps.setString(2, EnumStatusNotaFiscal.AUTORIZADA.toString());
			ps.setString(3, chaveNfe);
			ps.setString(4, protocoloNfe);
			
			if (ps.executeUpdate() == 0)
				return false;
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			conn.close();
		}
		return false;
	}
	
	public boolean cancelarNotaFiscal(NotaFiscal nfe) throws SQLException  {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = MySqlConnection.getConnection();
			String query = "{call alterar_nota_fiscal(?)}";
			ps = conn.prepareStatement(query); 
			
			ps.setString(1, EnumStatusNotaFiscal.CANCELADA.toString());
			
			if (ps.executeUpdate() == 0)
				return false;
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			conn.close();
		}
		return false;
	}

	@Override
	public ArrayList<NotaFiscal> selectNotaFiscal() throws SQLException {
		ArrayList<NotaFiscal> nfes = new ArrayList<>();
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = MySqlConnection.getConnection();
			String query = "{call alterar_nota_fiscal()}";
			ps = conn.prepareStatement(query); 
			
			/*
			 * TODO
			 * 		- iterar e criar a lista
			 */
			
			return nfes;
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			conn.close();
		}
		return nfes;
	}

	@Override
	public ArrayList<NotaFiscal> selectNotaFiscal(String filtr) throws SQLException {
		ArrayList<NotaFiscal> nfes = new ArrayList<>();
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = MySqlConnection.getConnection();
			String query = "{call alterar_nota_fiscal(?)}"; // precisa criar no banco
			ps = conn.prepareStatement(query); 
			
			/*
			 * TODO
			 * 		- iterar e criar lista
			 */
			
			
			return nfes;
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			conn.close();
		}
		return nfes;
	}
}
