package MyDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import MyPojo.Employee;

public class Delete {
	
	Scanner scan = new Scanner(System.in);
	Employee emp = new Employee();
	
	private static final String Delete_Query = "DELETE FROM EMP WHERE EID = ? ";
	
	public Delete() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated constructor stub
		DeleteEmployees();
	}
	
	void DeleteEmployees() throws SQLException, ClassNotFoundException{
		
		Connection con = GetConnection.Connect();
		
		System.out.print("\nHOW MANY ENTRIES YOU WANT TO DELETE ? : ");
		int num = Integer.parseInt(scan.nextLine());
		
		for(int i=1;i<=num;i++){
			
			System.out.print("\nEnter ID to Delete : ");
			int id = Integer.parseInt(scan.nextLine());
			emp.setId(id);
			
			PreparedStatement ps = con.prepareStatement(Delete_Query);
			
			ps.setInt(1, emp.getId());
			
			int count = ps.executeUpdate();
			
			if(count>0){
				System.out.println("Record Deleted\n");
			}
			else{
				System.out.println("Record Not Deleted.\n");
			}
			
			System.out.print("Procceedding to new record ");
			
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
		
		System.out.println("\nRecords of provided ID's are deleted Successfully .");
		
		con.close();
		System.out.println("\nConnection Closed.");
		
		System.out.println("\nCheck out your DataBase Table.");

	}
}
