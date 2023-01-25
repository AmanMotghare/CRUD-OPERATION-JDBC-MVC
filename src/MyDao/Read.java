package MyDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Read {
	
	private static final String Select_Query = "SELECT * FROM EMP ";
	
	Connection con = GetConnection.Connect();
	
	public Read() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated constructor stub
		ReadEmployees();
	}

	 void ReadEmployees() throws SQLException {
		// TODO Auto-generated method stub
		 
		 PreparedStatement ps = con.prepareStatement(Select_Query);
		 
		 ResultSet rs = ps.executeQuery();
		 
		 System.out.println("ID     NAME      ADDRESS");
		 
		 while (rs.next()) {
			
		 System.out.println(rs.getInt(1)+"    "+rs.getString(2)+"     "+rs.getString(3));
			
		}
		 
	}
}
