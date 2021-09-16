package Controller;
import java.util.*;
import java.sql.*;

import Configuration.DbConnection;
import DAO.DAOClass;

public class MainClass {

	public static void main(String[] args) {
		
		DAOClass ta=new DAOClass();
		Scanner sc=new Scanner(System.in);
		
		while(true) {
			System.out.println("1.Add Data.");
			System.out.println("2.Update Data.");
			System.out.println("3.Delete data.");
			System.out.println("4.Add/Update Marks.");
			System.out.println("5.Merit list of students for any given batch( top 5 students)");
			System.out.println("6.Merit list of students for all batches ( top 10 students)");
			System.out.println("7.Name of the batch where maximum students have failed");
			System.out.println("8.Batch name and trainer name of the batch whose average percentage result is best");
			System.out.println("9.Exit.");
			System.out.println("Enter Your Choice...");
			int choice=sc.nextInt();
			
			switch (choice) {
			case 1:
				ta.addStudent();
				
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
					ta.modifyStatus();
					System.out.println();
					
					break;
					
				case 2:
					System.out.println("Updating Student Phone Number");
					System.out.println();
					ta.updatePhoneNumber();
					System.out.println();
					
					break;
				case 3:
					System.out.println("Updating Batch Details");
					System.out.println();
					ta.changeBatch();
					System.out.println();
					break;
					
				case 4:
					System.out.println("Updating Student Id");
					System.out.println();
					
					break;
				}
				
				break;
			case 3:
				ta.deleteRecord();
				System.out.println();
				System.out.println("Record Deleted!!..");
				break;
			case 4:
				
				System.out.println("1.To Add Result");
				System.out.println("2.To Update Any Result");
				
				int ch2=sc.nextInt();
				switch(ch2) {
				case 1:
					ta.addResult();
					System.out.println();
					System.out.println("Result Added Successfully...");
					break;
				case 2:
					ta.updateResult();
					System.out.println();
					System.out.println("Result Updated Successfully...");
					break;
				}
				break;
			case 5:
				System.out.println();
				ta.meritListTopFive();
				System.out.println();
				break;
			case 6:
				System.out.println();
				ta.topTenMeritList();
				System.out.println();
				break;
			case 7:
				System.out.println();
				ta.maxFailStudents();
				System.out.println();
				break;
			case 8:
				System.out.println();
				ta.avgBestBatch();
				System.out.println();
				break;
			case 9:
				DbConnection.closeConnection();
				
				System.out.println(".......End.....");
				
				sc.close();
				System.exit(0);
				break;

			default:
				System.out.println("Invalid Choice!!... Try Again.");
				
			}
		}

	}

}
