package MyDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import MyPojo.Employee;

public class Insert {
	
	private static final String Insert_Query = "INSERT INTO EMP (EID,ENAME) VALUES (?,?)";
	
	public Insert() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated constructor stub
		System.out.println("Hey I am insert class constructor");
		AddEmployees();
	}
	
	void AddEmployees() throws SQLException, ClassNotFoundException{
		
		Scanner scan = new Scanner(System.in);
		Employee emp = new Employee();
		
	//	2.Build Connection.
	//  Connection con = DriverManager.getConnection(url,username,password); - IN GET CONNECTION CLASS. 
		
		Connection con;
	
		con = GetConnection.Connect();
			
	//  3.Create Statement.
		
		System.out.print("Number of Entries : ");
		int num = Integer.parseInt(scan.nextLine());
		
		for(int i=1;i<=num;i++){
			
			System.out.println("\n\nEnter Details ... \n");
			
			System.out.print("ID : ");
			int id = Integer.parseInt(scan.nextLine());
			emp.setId(id);
			
			System.out.print("Name : ");
			String Name = scan.nextLine();
			emp.setName(Name);
			
			PreparedStatement ps = con.prepareStatement(Insert_Query);
			ps.setInt(1, emp.getId());
			ps.setString(2, emp.getName());
			
		//  4.Execute Update.
			
			int count = ps.executeUpdate();
					
			if(count>0){
				System.out.println("Record Inserted \n");
			}
			else{
				System.out.println("Record Not Inserted. \n");
			}
			
			System.out.print("Procceedding to new entry ");
			
			for(int a=3 ; a>=1 ; a--)
			{
				System.out.print(" . ");
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	
	// 5.Close Connection
		
			System.out.println("All Entries Done.");
			
			con.close();
			System.out.println("\nConnection Closed.");
			
			System.out.println("\nCheck out your DataBase Table");
				
	}
}
