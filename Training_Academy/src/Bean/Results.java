package Bean;

import java.util.*;

public class Results {

	private int studentId;
	private int marks;
	public Scanner sc = new Scanner(System.in);

	public Results() {

	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	public void setResults() {

		System.out.println("Enter Student id:");
		this.setStudentId(sc.nextInt());

	}

	public void getResults() {

		System.out.println("Student Id: " + this.getStudentId());
		System.out.println("Marks:" + this.getMarks());
	}

	public void validateMarks() {

		System.out.println("Enter the Marks:");
		{
			int score = sc.nextInt();
			if (score <= 50 && score > 0)
				this.setMarks(marks);
			else {
				System.out.println("Value/Marks must be between 1 to 50");
				validateMarks();
			}
		}
	}

}
