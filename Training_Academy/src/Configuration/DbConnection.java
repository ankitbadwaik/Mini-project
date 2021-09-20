package Configuration;

import java.util.*;

import java.sql.*;

public class DbConnection {

	public final static String url = "jdbc:mysql://localhost:3306/Training_Academy";
	public static Connection con = null;

	public static Connection connect() {

		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter the Username:");
			String username = sc.next();
			System.out.println("Enter the Password:");
			String pass = sc.next();

			con = DriverManager.getConnection(url, username, pass);
			System.out.println("Connected successfully to the database.");

		} catch (Exception e) {
			System.out.println("Error in Connection");
			System.out.println("Username or Password is Wrong!! Try Again.");
			connect();
		}
		return con;

	}

	public static void closeConnection() {
		try {
			con.close();

			System.out.println("Connection closed.");
		} catch (Exception e) {
			System.out.println("Error while closing the connection");

			e.printStackTrace();
		}

	}

}
