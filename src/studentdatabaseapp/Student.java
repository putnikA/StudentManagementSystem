package studentdatabaseapp;

import java.util.Scanner;

public class Student {
	
	private String firstName;
	private String lastName;
	private int gradeYear;
	private String studentID;
	private String courses = "";
	private int tuitionBalance = 0;
	private static int costOfCourse = 600;
	private static int id = 1000;
	Scanner in;
	
	//Constructor for name and year
	public Student() {
		in = new Scanner(System.in);
		System.out.print("Enter student first name: ");
		this.firstName = in.nextLine();
		
		System.out.print("Enter student last name: ");
		this.lastName = in.nextLine();
		
		System.out.print("1 - Freshmen\n2 - Sophmore\n3 - Junior\n4 - Senior\nEnter student grade level: ");
		this.gradeYear = in.nextInt();
		
		setStudentID();
	}
	
	//Generate ID
	private void setStudentID() {
		//Grade level + ID
		id++;
		this.studentID =  gradeYear + "" + id;
	}
	
 	//Enroll in courses
	public void enroll() {
		do {
			System.out.print("Enter course to enroll (Press Q to quit): ");
			in = new Scanner(System.in);
			String course = in.nextLine();
			if (!course.equals("Q")) {
				courses = courses + "\n  " + course;
				tuitionBalance = tuitionBalance + costOfCourse;
			} else {
				break;
			}
		} while(true);
	}
	//View balance
	public void viewBalance() {
		System.out.println("Your balance is: $" + tuitionBalance);
	}
	//Pay tuition
	public void payTuition() {
		viewBalance();
		System.out.print("Enter your payment: $");
		in = new Scanner(System.in);
		int payment = in.nextInt();
		tuitionBalance = tuitionBalance - payment;
		System.out.println("Thank you for your payment of $" + payment);
		viewBalance();
	}
	//Show status
	public String toString() {
		return "Name: " + firstName + "Last name: " + lastName + 
				"\nGrade level: " + gradeYear + 
				"\nStudent ID: " + studentID + 
				"\nCourses enrolled: " + courses + 
				"\nBalance: $" + tuitionBalance;
 	}
}
