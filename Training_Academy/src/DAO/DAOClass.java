package DAO;

import java.sql.*;

import java.util.*;

import Configuration.DbConnection;
import Bean.Student_Details;
import Bean.Results;

public class DAOClass implements DAOInterface {

	private Connection con = DbConnection.connect();
	public Scanner sc = new Scanner(System.in);

	@Override
	public void addStudent() {
		String sql = "insert into Students_details(student_id,student_name,phone_no,batch_id,status) values(?,?,?,?,?)";
		Student_Details student = new Student_Details();
		student.setStudent();
		try {
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, student.getStudentId());
			ps.setString(2, student.getStudentName());
			ps.setString(3, student.getPhoneNo());
			ps.setInt(4, student.getBatchId());
			ps.setString(5, student.getStatus());

			boolean flag = ps.execute();
			if (flag == false)
				System.out.println("Record added Successfully...");
			else
				System.out.println("Unable to Add Record....");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error while adding record");
			e.printStackTrace();
		}

	}

	@Override
	public void modifyStatus() {
		String sql = "update Students_details set status=? where student_id=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			System.out.println("Enter the Student Id:");
			int id = sc.nextInt();
			ps.setInt(2, id);
			System.out.println("Status :\n 1.Active \n 2.Inactive");
			int ch = sc.nextInt();
			if (ch == 1)
				ps.setString(1, "Active");
			else
				ps.setString(1, "Inactive");

			int row = ps.executeUpdate();
			System.out.println(row + " rows updated.");

		} catch (Exception e) {
			System.out.println("Error While Updating...");
			// TODO: handle exception
		}
	}

	@Override
	public void addResult() {

		String sql = "insert into Results(student_id,marks) values(?,?)";
		Results result = new Results();
		result.setResults();

		try {
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, result.getStudentId());

			ps.setInt(2, result.getMarks());
			int row = ps.executeUpdate();
			if (row > 0)
				System.out.println(row + " Rows Updated.");
			else
				System.out.println("Unable To Update");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error");
			e.printStackTrace();
		}

	}

	public void updateResult() {
		String sql = "update Results set marks=? where student_id=?";
		Results re = new Results();
		re.setResults();
		try {
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(2, re.getStudentId());

			ps.setInt(1, re.getMarks());
			int row = ps.executeUpdate();
			System.out.println(row + " Rows Updated.");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error While Updating...");
			e.printStackTrace();
		}
	}

	@Override
	public void deleteRecord() {
		String sql = "delete s,r from Students_details s inner join Results r on s.student_id=r.student_id where s.student_id=?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			System.out.println("Enter the Student ID:");
			ps.setInt(1, sc.nextInt());
			int row = ps.executeUpdate();
			System.out.println(row + " Rows Deleted.");
		} catch (Exception e) {
			System.out.println("Error While deleting data...");
			e.printStackTrace();
			// TODO: handle exception
		}

	}

	public void updatePhoneNumber() {
		String sql = "update Students_details set phone_no=? where student_id=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			System.out.println("Enter Student id:");
			ps.setInt(2, sc.nextInt());
			System.out.println("Enter New Phone Number:");
			ps.setString(1, sc.next());

			int row = ps.executeUpdate();
			System.out.println(row + " row Updated");
		} catch (Exception e) {

			// TODO: handle exception
			System.out.println("Error While Updating...");
			e.printStackTrace();
		}
	}

	public void changeBatch() {
		String sql = "update Students_details set batch_id=? where student_id=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			System.out.println("Enter the Student id.");
			ps.setInt(2, sc.nextInt());

			System.out.println("Enter Batch Id:");
			ps.setInt(1, sc.nextInt());
			int row = ps.executeUpdate();
			System.out.println(row + " Updated.");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error While Updating...");
			e.printStackTrace();
		}

	}

	public void updateStudentId() {
		String sql = "update Students_details set batch_id=? where student_id=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			System.out.println("Enter the Student id.");
			ps.setInt(2, sc.nextInt());

			System.out.println("Enter Batch Id:");
			ps.setInt(1, sc.nextInt());
			int row = ps.executeUpdate();
			System.out.println(row + " Updated.");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error While Updating...");
			e.printStackTrace();
		}
	}

	public void meritListTopFive() {

		String sql = "select s.student_id,s.student_name,r.marks from Students_details s inner join Results r on s.student_id=r.student_id where batch_id=? && marks>24 order by marks desc limit 5";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			System.out.println("Enter the Batch Id:");
			int id = sc.nextInt();
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			System.out.println("Top 5 Merit Students Are: ");
			while (rs.next()) {
				System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getInt(3));
			}

			ps.close();

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Unable to get list");
			e.printStackTrace();
		}
	}

	public void topTenMeritList() {

		String sql = "select s.student_id,s.student_name,r.marks,bd.batch_name from Students_details s inner join Results r on s.student_id=r.student_id inner join Batches bd on bd.batch_id=s.batch_id where marks>24 order by marks desc limit 10";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			System.out.println("Top 10 Students in Academy");
			while (rs.next()) {
				System.out
						.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getInt(3) + "\t" + rs.getString(4));
			}

			ps.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Unable to get list.");
		}

	}

	public void maxFailStudents() {

		String sql = "select bd.batch_name,count(*) from Students_details s inner join Results r on s.student_id=r.student_id inner join Batches bd on bd.batch_id=s.batch_id where marks<25";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			System.out.println("Batch Name  \t No. Of Failed Students");
			while (rs.next()) {
				System.out.println(rs.getString(1) + "\t \t" + rs.getInt(2));
			}

			ps.close();

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Unable to get record.");
		}
	}

	public void avgBestBatch() {
		String sql = "select teacher_name,batch_name,count(*) from Students_details s inner join Results r on s.student_id=r.student_id inner join Teacher_details t on t.batch_id=s.batch_id inner join Batches bd on bd.batch_id=s.batch_id  where r.marks>24 group by teacher_name limit 1";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println("Batch name : " + rs.getString(2));
				System.out.println("Teacher name : " + rs.getString(1));
				System.out.println("No. of passed students : " + rs.getInt(3));

			}

			ps.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Unable to get record.");
		}
	}

	public void studentInfo() {
		String sql = "select * from Students_details";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			System.out.println("Student ID\tStudent Name \t Phone No.     \t Batch Id       \t Status\n ");
			while (rs.next()) {
				System.out.println(rs.getInt(1) + "\t\t" + rs.getString(2) + "\t\t" + rs.getString(3) + "\t\t"
						+ rs.getInt(4) + "\t\t" + rs.getString(5));
			}

			ps.close();

		} catch (Exception e) {
			System.out.println("Unable to get List.");
		}
	}

	public void teacherInfo() {
		String sql = "select * from Teacher_details";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			System.out.println("Teacher Id  \tTeacher Name  \t\t Batch Id\t\tContact No. \n ");
			while (rs.next()) {
				System.out.println(
						rs.getInt(1) + "\t\t" + rs.getString(2) + "\t\t" + rs.getInt(3) + "\t\t" + rs.getString(4));
			}

			ps.close();

		} catch (Exception e) {
			System.out.println("unable to get records.");
		}

	}

	public void batchInfo() {
		String sql = "select * from Batches";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			System.out.println("Batch Id\tBatch Name\n ");
			while (rs.next()) {
				System.out.println(rs.getInt(1) + "\t\t" + rs.getString(2));
			}

			ps.close();

		} catch (Exception e) {
			System.out.println("unable to get records.");
		}
	}

}
