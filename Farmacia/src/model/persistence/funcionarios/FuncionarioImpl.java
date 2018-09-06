package model.persistence.funcionarios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;

import model.entities.Funcionario;
import model.persistence.MySqlConnection;

public class FuncionarioImpl implements FuncionarioDao{

	private Connection conn;

	//uma vez instanciado o objeto é inicializado com a conexão
	public FuncionarioImpl() throws SQLException {
		this.conn = MySqlConnection.getConnection();;
	}

	public static String CalendarToString(Calendar date) {

		return date.get(Calendar.YEAR) + "-" + date.get(Calendar.MONTH) + "-" + date.get(Calendar.DAY_OF_MONTH);
	}
	
	@Override
	public boolean insertFuncionario(Funcionario func) throws SQLException {
		try {

			//definir procedimento e quantidade de parametros
			String query = "{call inserir_funcionario(?,?,?,?,?,?,?,?,?) }"; 

			//cria Statement que executa o procedimento e recebe os parâmetros
			PreparedStatement ps = conn.prepareStatement(query);		

			ps.setString(1, func.getNome());
			ps.setString(2, func.getEmail());
			ps.setString(3, func.getEndereco().toString());
			ps.setString(4, func.getTelefone());
			ps.setString(5, func.getCelular());
			ps.setString(6, "cpf");
			//ps.setString(6, func.getCpf());
			ps.setString(7,CalendarToString(func.getDataNascimento()));
			ps.setString(8, func.getTipoFuncionario().toString());
			ps.setDouble(9, func.getSalario());
			

			if(ps.executeUpdate() == 0) {
				System.out.println("Erro ao inserir!");
			}
			else {
				System.out.println("Dado inserido com sucesso!");
				ps.close();
				//repensar para que eu não tenha que fechar a conexao novamente
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
	public boolean updateFuncionario(Funcionario func) throws SQLException {
		try {

			//definir procedimento e quantidade de parametros
			String query = "{call alterar_funcionario(?,?,?,?,?,?,?,?,?,?) }"; 

			//cria Statement que executa o procedimento e recebe os parâmetros
			PreparedStatement ps = conn.prepareStatement(query);		

			ps.setInt(1, func.getId());
			ps.setString(2, func.getNome());
			ps.setString(3, func.getEmail());
			ps.setString(4, func.getEndereco().toString());
			ps.setString(5, func.getTelefone());
			ps.setString(6, func.getCelular());
			ps.setString(7, "cpf");
			//ps.setString(7, func.getCpf());
			ps.setString(8,CalendarToString(func.getDataNascimento()));
			ps.setString(9, func.getTipoFuncionario().toString());
			ps.setDouble(10, func.getSalario());

			if(ps.executeUpdate() == 0) {
				System.out.println("Erro ao atualizar!");
			}
			else {
				System.out.println("Dado atualizado com sucesso!");
				ps.close();
				//repensar para que eu não tenha que fechar a conexao novamente
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
	public boolean deleteFuncionario(Funcionario func) throws SQLException {
		try {

			//definir procedimento e quantidade de parametros
			String query = "{call excluir_funcionario(?) }"; 

			//cria Statement que executa o procedimento e recebe os parâmetros
			PreparedStatement ps = conn.prepareStatement(query);		

			ps.setInt(1, func.getId());

			if(ps.executeUpdate() == 0) {
				System.out.println("Erro ao excluir!");
			}
			else {
				System.out.println("Dado excluido com sucesso!");
				ps.close();
				//repensar para que eu não tenha que fechar a conexao novamente
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
	public Funcionario[] selectFuncionario(String filter) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Funcionario[] selectFuncionario() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
