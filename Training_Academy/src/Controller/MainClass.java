package Controller;
import java.util.*;
import java.sql.*;

import Configuration.DbConnection;
import DAO.DAOClass;

public class MainClass {

	public static void main(String[] args) {
		
		DAOClass obj=new DAOClass();
		Scanner sc=new Scanner(System.in);
		
		while(true) {
			System.out.println("1.Add Data.");
			System.out.println("2.Update Data.");
			System.out.println("3.Delete data.");
			System.out.println("4.Add Marks");
			System.out.println("5.Exit.");
			System.out.println("Enter Your Choice...");
			int choice=sc.nextInt();
			
			switch (choice) {
			case 1:
				obj.addStudent();
				
				break;
			case 2:
				System.out.println("1.Update Status of student.");
				System.out.println("2.Update Student Phone number.");
				System.out.println("3.Update Student Batch.");
				
				int ch1=sc.nextInt();
				switch(ch1)
				{
				case 1:
					System.out.println("Updating status of Student");
					System.out.println();
					obj.modifyStatus();
					System.out.println();
					
					break;
					
				case 2:
					System.out.println("Updating Student Phone Number");
					System.out.println();
					obj.updatePhoneNumber();
					System.out.println();
					
					break;
				case 3:
					System.out.println("Updating Batch Details");
					System.out.println();
					obj.changeBatch();
					System.out.println();
					break;
					
				case 4:
					System.out.println("Updating Student Id");
					System.out.println();
					
					break;
				}
				
				break;
			case 3:
				obj.deleteRecord();
				break;
			case 4:
				
				break;

			default:
				break;
			}
		}

	}

}
