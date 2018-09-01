package testes;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

import model.persistence.*;

public class TesteConexaoBanco {
	public static void main(String args[]) {
		try {
			Connection conn = MySqlConnection.getConnection();

			if (conn == null)
				throw new SQLException("Conexão não realizada.");

			System.out.println("Conectado.");			
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}

	}
}
