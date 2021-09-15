package Bean;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Student_Details {
	private int studentId;
	private String studentName;
	private String phoneNo;
	private int batchId;
	private String status;
	public Scanner  sc=new Scanner(System.in);



public Student_Details() {
	
}



public int getStudentId() {
	return studentId;
}



public void setStudentId(int studentId) {
	this.studentId = studentId;
}



public String getStudentName() {
	return studentName;
}



public void setStudentName(String studentName) {
	this.studentName = studentName;
}



public String getPhoneNo() {
	return phoneNo;
}



public void setPhoneNo(String phoneNo) {
	this.phoneNo = phoneNo;
}



public int getBatchId() {
	return batchId;
}



public void setBatchId(int batchId) {
	this.batchId = batchId;
}



public String getStatus() {
	return status;
}



public void setStatus(String status) {
	this.status = status;
}



public void setStudent() {
	System.out.println("Enter the Student Id:");
	this.setStudentId(sc.nextInt());
	
	this.validateName();
	
	
	this.phoneValidation();
	
	this.validateStatus();
	
	System.out.println("Enter Batch ID:");
	this.setBatchId(sc.nextInt());
}

public void getStudent() {
	System.out.println("Student Id : "+this.studentId);
	System.out.println("Phone Number : "+this.phoneNo);
	System.out.println("Batch Id : "+this.batchId);
	System.out.println(" Status : "+this.status);
}

public boolean checkName(String name) 
{
	String regex= "^[A-Z][A-Za-z]+";
	Pattern p=Pattern.compile(regex);
	Matcher m=p.matcher(name);
	return m.matches();
				
}

public void validateName()
{
	System.out.println("Enter Student Name:");
	String n=sc.next();
	if(checkName(n))
		this.setStudentName(n);
	else
	{
		System.out.println("Invalid Try Again");
		validateName();
	}
}

public void phoneValidation()
{
	Pattern p=Pattern.compile("[7-9][0-9]{9}");
	System.out.println("Enter Phone Number:");
	String no=sc.next();
	Matcher m=p.matcher(no);
	
	if(m.find() && m.group().equals(no))
		this.setPhoneNo(no);
	else
	{
		System.out.println("Invalid Try Again.");
		phoneValidation();
	}
}

public void validateStatus()
{
	System.out.println("Enter the Status");
	String st=sc.next();
	if(st.equalsIgnoreCase("Active") || st.equalsIgnoreCase("Inactive"))
		this.setStatus(st);
	else
	{
		System.out.println("Status can only be 'Active' or 'Inactive'");
		validateStatus();
	}
}
}
