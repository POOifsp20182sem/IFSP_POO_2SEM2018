package model.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.io.IOException;
import java.sql.SQLException;

// https://docs.oracle.com/javase/tutorial/jdbc/overview/index.html
public class MySqlConnection {
	
	public static Connection getConnection()
			throws SQLException {
		DBProperties properties;

		try {
			properties = new DBProperties();

			Connection connection = DriverManager.getConnection(properties.getUrl(),
					properties.getUser(),
					properties.getPasswd());

			if (connection == null)
				throw new SQLException("Connection class could not be created.");

			return connection;
			
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

		return null;
	}
}
