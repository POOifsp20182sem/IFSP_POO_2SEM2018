package br.ifsp.farmacia.model.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import br.ifsp.farmacia.model.entities.Cliente;
import br.ifsp.farmacia.model.entities.Endereco;
import br.ifsp.farmacia.model.entities.EnumCliente;

/*
 * TODO:
 * 		Handle `query-exceptions` by throwing it/new exceptions, except printing it out;
 */

public class ClienteDAO implements IClienteDAO {

	@Override
	public boolean insertCliente(Cliente cli) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = MySqlConnection.getConnection();

			String query = "{call inserir_cliente(?, ?, ?, ?, ?, ?, ?, ?)}"; 

			ps = conn.prepareStatement(query);

			ps.setString(1, cli.getNome());
			ps.setString(2, cli.getEmail());
			ps.setString(3, cli.getEndereco().toString());
			ps.setString(4, cli.getTelefone());
			ps.setString(5, cli.getCelular());
			ps.setString(6, cli.getTipoCliente().toString());
			ps.setString(7, cli.getDocumento());
			ps.setString(8, cli.getDataNascFormatado());

			if(ps.executeUpdate() != 0) 
				return true;

		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			conn.close();
		}
		return false;
	}

	@Override
	public boolean updateCliente(Cliente cli) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;

		try {

			String query = "{call alterar_cliente(?, ?, ?, ?, ?, ?, ?, ?, ?)}"; 

			conn = MySqlConnection.getConnection();
			ps = conn.prepareStatement(query);		

			ps.setInt(1, cli.getId());
			ps.setString(2, cli.getNome());
			ps.setString(3, cli.getEmail());
			ps.setString(4, cli.getEndereco().toString());
			ps.setString(5, cli.getTelefone());
			ps.setString(6, cli.getCelular());
			ps.setString(7, cli.getTipoCliente().toString());
			ps.setString(8, cli.getDocumento());
			ps.setString(9, cli.getDataNascFormatado());

			if(ps.executeUpdate() != 0)
				return true;

		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			conn.close();
		}
		return false;
	}

	@Override
	public boolean deleteCliente(Cliente cli) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			String query = "{call excluir_cliente(?)}"; 

			conn = MySqlConnection.getConnection();
			ps = conn.prepareStatement(query);		

			ps.setInt(1, cli.getId());

			if(ps.executeUpdate() != 0)
				return true;

			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				conn.close();
			}
			return false;
		}

		@Override
		public ArrayList<Cliente> selectCliente(String filter) throws SQLException {
			Connection conn = null;
			PreparedStatement ps = null;

			ArrayList<Cliente> listClientes = new ArrayList<>();
			Cliente cli = new Cliente();

			final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");

			try {
				String query = "{call buscar_clientes(?)}"; 

				conn = MySqlConnection.getConnection();
				ps = conn.prepareStatement(query);		

				ps.setString(1, filter);

				ResultSet result = ps.executeQuery();
				/***
				 * Gera um cliente no mesmo espa�o de mem�ria
				 */
				while(result.next()) {
					cli = new Cliente();

					cli.setId(result.getInt("id"));
					cli.setNome(result.getString("nome"));
					cli.setEmail(result.getString("email"));
					cli.setTelefone(result.getString("telefone"));
					cli.setCelular(result.getString("celular"));

					// TODO:2018-09-14:ed:problema ao inserir o tipo, mudar m�todo ou
					// fazer comparacao a cada objeto carregado o que seria dispendioso
					cli.setTipoCliente(
							(result.getString("tipo_cliente").
									equalsIgnoreCase(EnumCliente.FISICA.toString()))? 
											EnumCliente.FISICA:EnumCliente.JURIDICA);


					cli.setDocumento(result.getString("cpf")!= null? result.getString("cpf"):result.getString("cnpj"));

					// TODO:2018-09-14:ed:criar no tabela de endereco no banco de dados
					// e associar com cliente para facilitar o armazenamento e consulta
					//cli.setEndereco(result.getString("endereco"));

					// TODO:2018-09-14:ed:criar sobrecarga  no m�todo setDataNascimento
					//para convers�o de tipo internamente
					cli.setDataNascimento(LocalDate.parse(result.getString("data_nascimento"), dtf));

					listClientes.add(cli);
				}

			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				conn.close();
			}

			return listClientes;

		}

		@Override
		public ArrayList<Cliente> selectCliente() throws SQLException {
			return selectCliente("");
		}

		public Cliente buscarCliente(int id) throws SQLException {

			Connection conn = null;
			PreparedStatement ps = null;

			Cliente cli = new Cliente();

			final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");

			try {
				String query = "SELECT id, nome, email, endereco, telefone, celular, tipo_cliente, cpf, cnpj, data_nascimento FROM cliente WHERE id = ?;";

				conn = MySqlConnection.getConnection();
				ps = conn.prepareStatement(query);		

				ps.setInt(1, id);

				ResultSet result = ps.executeQuery();
				/***
				 * Gera um cliente no mesmo espa�o de mem�ria
				 */
				while(result.next()) {
					cli = new Cliente();

					cli.setId(result.getInt("id"));
					cli.setNome(result.getString("nome"));
					cli.setEmail(result.getString("email"));
					cli.setTelefone(result.getString("telefone"));
					cli.setCelular(result.getString("celular"));

					// TODO:2018-09-14:ed:problema ao inserir o tipo, mudar m�todo ou
					// fazer comparacao a cada objeto carregado o que seria dispendioso
					cli.setTipoCliente(
							(result.getString("tipo_cliente").
									equalsIgnoreCase(EnumCliente.FISICA.toString()))? 
											EnumCliente.FISICA:EnumCliente.JURIDICA);
					if(cli.getTipoCliente().equals(EnumCliente.FISICA))
						cli.setDocumento(result.getString("cpf"));
					else 
						cli.setDocumento(result.getString("cnpj"));

					// TODO:2018-09-14:ed:criar no tabela de endereco no banco de dados
					// e associar com cliente para facilitar o armazenamento e consulta
					String [] strs = result.getString("endereco").toString().split(",");
					cli.setEndereco(new Endereco(strs[0], strs[1], strs[2], strs[3]));

					// TODO:2018-09-14:ed:criar sobrecarga  no m�todo setDataNascimento
					//para convers�o de tipo internamente
					cli.setDataNascimento(LocalDate.parse(result.getString("data_nascimento"), dtf));

					return cli;
				}

			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				conn.close();
			}
			return null;
		}
	}
