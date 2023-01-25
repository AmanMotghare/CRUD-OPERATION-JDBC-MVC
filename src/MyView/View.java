package MyView;

import java.sql.SQLException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import MyDao.Delete;
import MyDao.Insert;
import MyDao.Read;
import MyDao.Update;


public class View {
	
	Scanner scan = new Scanner(System.in);
		

	public View() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated constructor stub
		
//		System.out.println("Hey I am view Constructor .");
		
		ViewUI();
		
	}
	
	void ViewUI() throws ClassNotFoundException, SQLException{
		
		System.out.println("Hey, Welcome to the Asterisc Technocrat !!!");
		
		boolean flag = true;
		
		while (flag == true){
			
			System.out.println("\n<<<<<<<<<<<<<<<<<<<<<<*>>>>>>>>>>>>>>>>>>>>>");
			System.out.println("<<<<<<<           1. REGISTER        >>>>>>>");
			System.out.println("<<<<<<<           2. SHOW            >>>>>>>");
			System.out.println("<<<<<<<           3. UPDATE          >>>>>>>");
			System.out.println("<<<<<<<           4. DELETE          >>>>>>>");
			System.out.println("<<<<<<<           0. EXIT            >>>>>>>");
			System.out.println("<<<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>");
			
			System.out.print("ENTER YOUR CHOICE : ");
			int choice = Integer.parseInt(scan.nextLine());
			
			switch (choice) {
			case 1:
				new Insert();
				break;
				
			case 2:
				new Read();
				break;
				
			case 3:
				new Update();
				break;
				
			case 4:
				new Delete();
				break;
				
			case 0:
				flag = false;
				
				System.out.println("Adios !! \n");
				System.out.print("Shutting Down ");
				
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
	
}
