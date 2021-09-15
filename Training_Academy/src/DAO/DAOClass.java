package DAO;
import java.sql.*;
import java.util.*;

import Configuration.DbConnection;
import Bean.Student_Details;

public class DAOClass implements DAOInterface {
	
	private Connection con=DbConnection.connect();
	public Scanner  sc=new Scanner(System.in);

	@Override
	public void addStudent() {
		String sql="insert into Students_details(student_id,student_name,phone_no,batch_id,status) values(?,?,?,?,?)";
		Student_Details student=new Student_Details();
		student.setStudent();
		try
		{
			PreparedStatement ps=con.prepareStatement(sql);
			
			ps.setInt(1, student.getStudentId());
			ps.setString(2, student.getStudentName());
			ps.setString(3, student.getPhoneNo());
			ps.setInt(4, student.getBatchId());
			ps.setString(5, student.getStatus());
			
			 boolean flag=ps.execute();
			 if(flag==false)
				 System.out.println("Record added Successfully...");
			 else
				 System.out.println("Unable to Add Record....");
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error while adding record");
			e.printStackTrace();
		}
		
	}

	@Override
	public void modifyStatus() {
		String sql="update Students_details set status=? where student_id=?";
		try
		{
			PreparedStatement ps=con.prepareStatement(sql);
			System.out.println("Enter the Student Id:");
			int id=sc.nextInt();
			ps.setInt(2, id);
			System.out.println("Status :\n 1.Active \n 2.Inactive");
			int ch=sc.nextInt();
			if(ch==1)
				ps.setString(1, "Active");
			else
				ps.setString(1, "Inactive");
			
			int row=ps.executeUpdate();
			System.out.println(row+" rows updated.");
				
		}
		catch (Exception e) {
			System.out.println("Unable to Update");
			// TODO: handle exception
		}
	}

	@Override
	public void addResult() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteRecord() {
		String sql="delete s,r from Students_details s inner join result r on s.student_id=r.student_id where s.student_id=?";
		
		try
		{
			PreparedStatement ps=con.prepareStatement(sql);
			System.out.println("Enter the Student ID:");
			ps.setInt(1, sc.nextInt());
			int row=ps.executeUpdate();
			System.out.println(row+" Rows Deleted.");
		}
		catch (Exception e) {
			System.out.println("Unable to delete data");
			e.printStackTrace();
			// TODO: handle exception
		}
		
	}
	
	public void updatePhoneNumber() {
		String sql="update Students_details set phone_no=? where student_id=?";
		try
		{
			PreparedStatement ps=con.prepareStatement(sql);
			System.out.println("Enter Student id:");
			ps.setInt(2, sc.nextInt());
			System.out.println("Enter New Phone Number:");
			ps.setString(1, sc.next());
			
			int row=ps.executeUpdate();
			System.out.println(row+" row Updated");
		}
		catch (Exception e) {
			
			// TODO: handle exception
			System.out.println("Unable to update");
			e.printStackTrace();
		}
	}
	
	public void changeBatch() {
		String sql="update Students_details set batch_id=? where student_id=?";
		try
		{
			PreparedStatement ps=con.prepareStatement(sql);
			System.out.println("Enter the Student id.");
			ps.setInt(2, sc.nextInt());
			
			System.out.println("Enter Batch Id:");
			ps.setInt(1, sc.nextInt());
			int row=ps.executeUpdate();
			System.out.println(row+" Updated.");
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("Unable to update.");
			e.printStackTrace();
		}
		
		
	}
	
	public void updateStudentId() {
		String sql="update Students_details set batch_id=? where student_id=?";
		try
		{
			PreparedStatement ps=con.prepareStatement(sql);
			System.out.println("Enter the Student id.");
			ps.setInt(2, sc.nextInt());
			
			System.out.println("Enter Batch Id:");
			ps.setInt(1, sc.nextInt());
			int row=ps.executeUpdate();
			System.out.println(row+" Updated.");
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("Unable to update.");
			e.printStackTrace();
		}
	}



}
