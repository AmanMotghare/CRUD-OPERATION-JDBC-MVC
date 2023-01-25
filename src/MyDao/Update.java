package MyDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import MyPojo.Employee;

public class Update {
	
	Scanner scan = new Scanner(System.in);
	Employee emp = new Employee();
	Connection con = GetConnection.Connect();
	
	public Update() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated constructor stub
		UpdateEmployee() ;
	}
	
	void UpdateEmployee() throws ClassNotFoundException, SQLException{
		
		boolean flag = true;
		
		while(flag==true){
			
			System.out.println("\n<<<<<<<<<<<<<<<<<<<<<<*>>>>>>>>>>>>>>>>>>>>>");
			System.out.println("<<<<<<<         1. UPDATE NAME       >>>>>>>");
			System.out.println("<<<<<<<         2. UPDATE ADDREESS   >>>>>>>");
			System.out.println("<<<<<<<         0. EXIT              >>>>>>>");
			System.out.println("<<<<<<<<<<<<<<<<<<<<<<*>>>>>>>>>>>>>>>>>>>>>");
			
			System.out.print("ENTER YOUR CHOICE : ");
			int choice = Integer.parseInt(scan.nextLine());
			
			switch (choice) {
			case 1:
				UpdateName();
				break;
				
			case 2:
				UpdateId();
				break;
				
			case 0:
				flag = false;
				
				System.out.println("Adios !! \n");
				System.out.print("Taking Back To Homepage");
				
				for(int i=3;i>=1;i--){
					
					System.out.print(". ");
					try {
						TimeUnit.SECONDS.sleep(1);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				break;

			default:
				System.out.println("-------------------------");
				System.out.println("ALERT : INVALID CHOICE !!");
				System.out.println("-------------------------");
				break;
			}
		}

	}
	
	void UpdateId() throws SQLException{
		
		String Update_Query = "UPDATE EMP SET EADDR = ? WHERE EID = ?";
		
		System.out.print("\nHOW MANY EMPLOYEE'S ADDRESS YOU WANT TO UPDATE ? : ");
		int num = Integer.parseInt(scan.nextLine());
		
		for(int i=1;i<=num;i++){
			
			System.out.print("\nEnter ID to Update Address : ");
			int id = Integer.parseInt(scan.nextLine());
			emp.setId(id);
			
			System.out.print("\nEnter Updated Address :  ");
			String Address = scan.nextLine();
			emp.setName(Address);
			
			
			PreparedStatement ps = con.prepareStatement(Update_Query);
			
			ps.setString(1, emp.getAddress());
			ps.setInt(2, emp.getId());
			
			int count = ps.executeUpdate();
			
			if(count>0){
				System.out.println("Record Updated\n");
			}
			else{
				System.out.println("Record Not Updated.\n");
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
		
		System.out.println("\nRecords of provided ID's are Updated Successfully .");
		
		con.close();
		System.out.println("\nConnection Closed.");
		
		System.out.println("\nCheck out your DataBase Table.");
	}

	
	void UpdateName() throws SQLException{
		
		String Update_Query = "UPDATE EMP SET ENAME = ? WHERE EID = ?";
		
		System.out.print("\nHOW MANY EMPLOYEE'S NAME YOU WANT TO UPDATE ? : ");
		int num = Integer.parseInt(scan.nextLine());
		
		for(int i=1;i<=num;i++){
			
			System.out.print("\nEnter ID to Update NAME : ");
			int id = Integer.parseInt(scan.nextLine());
			emp.setId(id);
			
			System.out.print("\nEnter Updated Name :  ");
			String Name = scan.nextLine();
			emp.setName(Name);
			
			PreparedStatement ps = con.prepareStatement(Update_Query);
			
			ps.setString(1, emp.getName());
			ps.setInt(2, emp.getId());
			
			int count = ps.executeUpdate();
			
			if(count>0){
				System.out.println("Record Updated\n");
			}
			else{
				System.out.println("Record Not Updated.\n");
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
		
		System.out.println("\nRecords of provided ID's are Updated Successfully .");
		
		con.close();
		System.out.println("\nConnection Closed.");
		
		System.out.println("\nCheck out your DataBase Table.");
	}

}
