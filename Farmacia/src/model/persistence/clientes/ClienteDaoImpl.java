package model.persistence.clientes;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

import model.entities.Cliente;
import model.entities.EnumCliente;
import model.persistence.MySqlConnection;

public class ClienteDaoImpl implements ClienteDao{
	private Connection conn;
	
	//uma vez instanciado o objeto é inicializado com a conexão
	public ClienteDaoImpl() throws SQLException {
		this.conn = MySqlConnection.getConnection();;
	}
	
	public static String dateToString(Date date) {
		//vou procurar o modo mais adequado depois
		int ano =  date.getYear();
		int mes = date.getMonth();
		int dia = date.getDay();
		
		return ano + "-" + mes + "-" + dia;
	}
		
	@Override
	public boolean insertCliente(Cliente cli) {
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
			ps.setString(9,dateToString(cli.getDataNascimento().getTime()));
			
			if(ps.executeQuery() == null) {
				System.out.println("Erro ao inserir!");
				return false;
			}
			else {
				System.out.println("Dado inserido com sucesso!");
				return true;
			}
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean updateCliente(Cliente cli) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteCliente(Cliente cli) {
		// TODO Auto-generated method stub
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
