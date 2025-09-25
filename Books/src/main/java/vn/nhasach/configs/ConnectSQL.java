package vn.nhasach.configs;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConnectSQL {
	private final String serverName = "NTH";
	private final String dbName = "Books";
	private final String portNumber = "1433";
	private final String instance = "";
	private final String userID = "sa";
	private final String password = "12345678";
	public Connection getConnection() throws Exception {
		String url;
		if (instance == null || instance.trim().isEmpty()) {
			// default instance
			url = "jdbc:sqlserver://" + serverName + ":" + portNumber + ";databaseName=" + dbName
					+ ";encrypt=true;trustServerCertificate=true";
		} else {
			// named instance
			url = "jdbc:sqlserver://" + serverName + ":" + portNumber + "\\" + instance + ";databaseName=" + dbName
					+ ";encrypt=true;trustServerCertificate=true";
		}

		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		return DriverManager.getConnection(url, userID, password);
	}

	public static void main(String[] args) {
		
		
	}

}
