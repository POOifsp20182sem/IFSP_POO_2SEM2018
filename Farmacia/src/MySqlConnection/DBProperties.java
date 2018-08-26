package MySqlConnection;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DBProperties {
	private String propertiesFile = "dbSettings.properties";
	private Properties properties = new Properties();

	public DBProperties()
			throws FileNotFoundException, IOException {
		InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propertiesFile);

		if (inputStream == null)
			throw new FileNotFoundException("Could not found file " + this.propertiesFile + ".");

		this.properties.load(inputStream);
	}

	public String getDriver() {
		return properties.getProperty("driver");
	}

	public String getUrl() {
		return properties.getProperty("url");
	}

	public String getUser() {
		return properties.getProperty("user");
	}

	public String getPasswd() {
		return properties.getProperty("passwd", "");
	}
}
