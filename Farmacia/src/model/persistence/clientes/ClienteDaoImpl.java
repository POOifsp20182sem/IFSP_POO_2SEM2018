package model.persistence.clientes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;
import model.entities.Cliente;
import model.entities.EnumCliente;
import model.persistence.MySqlConnection;

public class ClienteDaoImpl implements ClienteDao{
	private Connection conn;

	//uma vez instanciado o objeto é inicializado com a conexão
	public ClienteDaoImpl() throws SQLException {
		this.conn = MySqlConnection.getConnection();;
	}

	private static String calendarToString(Calendar date) {

		return date.get(Calendar.YEAR) + "-" + 
		date.get(Calendar.MONTH) + "-" + 
		date.get(Calendar.DAY_OF_MONTH);
	}

	@Override
	public boolean insertCliente(Cliente cli) throws SQLException {
		try {

			//definir procedimento e quantidade de parametros
			String query = "{call inserir_cliente(?,?,?,?,?,?,?,?,?) }"; 

			//cria Statement que executa o procedimento e recebe os parâmetros
			PreparedStatement ps = conn.prepareStatement(query);		

			ps.setString(1, cli.getNome());
			ps.setString(2, cli.getEmail());
			ps.setString(3, cli.getEndereco().toString());
			ps.setString(4, cli.getTelefone());
			ps.setString(5, cli.getCelular());
			ps.setString(6, cli.getTipoCliente().toString());

			//depois eu posso deixar isso mais bonito mexendo no banco
			if(cli.getTipoCliente().equals(EnumCliente.FISICA)) {
				ps.setString(7, cli.getDocumento());
				ps.setString(8, "");
			}else {
				ps.setString(8, cli.getDocumento());
				ps.setString(7, "");
			}
			ps.setString(9,calendarToString(cli.getDataNascimento()));
			
			if(ps.executeUpdate() == 0) {
				System.out.println("Erro ao inserir!");
			}
			else {
				System.out.println("Dado inserido com sucesso!");
				ps.close();
				//teria que fechar a conexao aqui e nos métodos abaixo
				return true;
			}
			ps.close();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			conn.close();
		}

		return false;
	}

	@Override
	public boolean updateCliente(Cliente cli) throws SQLException {
		
		try {

			//definir procedimento e quantidade de parametros
			String query = "{call alterar_cliente(?,?,?,?,?,?,?,?,?) }"; 

			//cria Statement que executa o procedimento e recebe os parâmetros
			PreparedStatement ps = conn.prepareStatement(query);		
			
			ps.setInt(1, cli.getId());
			ps.setString(2, cli.getNome());
			ps.setString(3, cli.getEmail());
			ps.setString(4, cli.getEndereco().toString());
			ps.setString(5, cli.getTelefone());
			ps.setString(6, cli.getCelular());
			ps.setString(7, cli.getTipoCliente().toString());
			ps.setString(8, cli.getDocumento());
			ps.setString(9,calendarToString(cli.getDataNascimento()));

			if(ps.executeUpdate() == 0) {
				System.out.println("Erro ao alterar!");
			}
			else {
				System.out.println("Dado alterado com sucesso!");
				ps.close();
				return true;
			}
			ps.close();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			conn.close();
		}

		return false;
	}

	@Override
	public boolean deleteCliente(Cliente cli) throws SQLException {
		try {

			//definir procedimento e quantidade de parametros
			String query = "{call excluir_cliente(?) }"; 

			//cria Statement que executa o procedimento e recebe os parâmetros
			PreparedStatement ps = conn.prepareStatement(query);		
			
			ps.setInt(1, cli.getId());

			//retorna a quantidade de linhas afetadas,
			//caso não tenha executado nada retorna 0
			//talvez eu mude isso futuramente
			if(ps.executeUpdate() == 0) {
				System.out.println("Erro ao excluir!");
			}
			else {
				System.out.println("Dado excluído com sucesso!");
				ps.close();
				return true;
			}
			ps.close();

		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			conn.close();
		}
		return false;
	}

	@Override
	public Cliente[] selectCliente(String filter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cliente[] selectCliente() {
		// TODO Auto-generated method stub
		return null;
	}


}
