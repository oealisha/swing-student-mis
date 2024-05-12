package garnetGrit;

import java.util.Scanner;

public class User {
	
	public String firstName;
	public String lastName;
	public String gender;
	public String address;
	public double contact;
	public int rollNo;
	public String program;
	public int java;
	public int math;
    public int english;
	public int economics;
	
	
	public User(String firstName, String lastName, String gender, String address, double contact,int rollNo, 
			 String program, int java,int math,int english,int economics) //parameterized cons
	{
		this.firstName=firstName;
		this.lastName=lastName;
		this.gender=gender;
		this.address=address;
		this.contact=contact;
		this.rollNo=rollNo;
		this.program=program;
		this.java=java;
		this.math=math;
		this.english=english;
		this.economics=economics;
		
	}
	
	public User(){
	
	}
	
	
	
	
	//getters
	
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getGender() {
		return gender;
	}
	public String getAddress() {
		return address;
	}
	public double getContact() {
		return contact;
	}
	public int getRollNo() {
		return rollNo;
	}
	public String getProgram() {
		return program;
	}
	public int getJava() {
		return java;
	}
	public int getMath() {
		return math;
	}
	public int getEnglish() {
		return english;
	}
	public int getEconomics() {
		return economics;
	}
	
	//setters
	public void setFirstName(String firstName) {
		this.firstName=firstName;
	}
	public void setLastName(String lastName) {
		this.lastName=lastName;
	}
	public void setGender(String gender) {
		this.gender=gender;
	}
	public void setAddress(String address) {
		this.address=address;
	}
	public void setContact(double contact) {
		this.contact=contact;
	}
	public void setRollNo(int rollNo) {
		this.rollNo=rollNo;
	}
	public void setProgram(String program) {
		this.program=program;
	}
	public void setJava(int java) {
		this.java=java;
	}
	public void setMath(int math) {
		this.math=math;
	}
	public void setEnglish(int english) {
		this.english=english;
	}
	public void setEconomics(int economics) {
		this.economics=economics;
	}
	
	
	
	
		//creating object of User class inside main method
		
			public static void main(String []args) {
				User user=new User("Shrijana","Neupane"," Female","Balaju",9841789789d,9,"BCIS",40,58,71,77); //table info
			   FileOperation fo=new FileOperation();
			  
			   fo.writeFile(user);
				
			}

	}

	
	




