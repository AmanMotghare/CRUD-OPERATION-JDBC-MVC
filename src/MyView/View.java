package MyView;

import java.sql.SQLException;

import MyDao.Insert;

public class View {

	public View() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated constructor stub
		System.out.println("Hey I am view Constructor .");
		new Insert();
		
	}
	
}
