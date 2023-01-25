package MyDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GetConnection {
	
	public static Connection Connect() throws ClassNotFoundException, SQLException{
		
		Connection con = null;
		
		//1. Register Driver
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//2. Build Connection
		
		String url="jdbc:mysql://localhost:3306/employees";
		String username="root";
		String password="abc123";
		
		con = DriverManager.getConnection(url,username,password);
		
		return con;
		
	}


}
