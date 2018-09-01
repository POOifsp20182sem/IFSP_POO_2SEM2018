package model.persistence;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


// https://docs.oracle.com/javase/tutorial/jdbc/overview/index.html
public class MySqlConnection {
	public static Connection getConnection()
			throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {

		// read a properties file to access database
		DBProperties properties = new DBProperties();

		Class.forName(properties.getDriver());

		Connection connection = DriverManager.getConnection(properties.getUrl(),
															properties.getUser(),
															properties.getPasswd());

		if (connection == null)
			throw new SQLException("Connection class could not be created.");

		return connection;
	}
}
