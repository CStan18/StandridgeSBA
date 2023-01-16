package jpa.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import javax.persistence.PersistenceException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import jpa.entitymodels.Course;
import jpa.entitymodels.Student;

public class AppHelper {
	
	private Scanner scnr = new Scanner(System.in);
	private StudentService studentService = new StudentService();
	private CourseService courseService = new CourseService();
	private Student currentStudent;
	
	public void populateDB() {
    	try {
        	/*
        	 * populate db with students and courses
        	 * 
        	 * 1. open session, begin transaction
        	 * 2. create students/courses
        	 * 3. save students/courses
        	 * 4. commit data
        	 */
        	System.out.println("Populating db...");	
    	
        	SessionFactory factory = new Configuration().configure().buildSessionFactory();
        	Session session = factory.openSession();
        	Transaction transaction = session.beginTransaction();
       	
        	Course c1 = new Course(1, "English", "Andrea Scamaden");
        	Course c2 = new Course(2, "Mathematics", "Eustace Niemetz");
        	Course c3 = new Course(3, "Anatomy", "Reynolds Pastor");
        	Course c4 = new Course(4, "Organic Chemistry", "Odessa Belcher");
        	Course c5 = new Course(5, "Physics", "Dani Swallow");
        	Course c6 = new Course(6, "Digital Logic", "Glenden Reilingen");
        	Course c7 = new Course(7, "Object Oriented Programming", "Giselle Ardy");
        	Course c8 = new Course(8, "Data Structures", "Carolan Stoller");
        	Course c9 = new Course(9, "Politics", "Carmita De Maine");
        	Course c10 = new Course(10, "Art", "Kingsly Doxsey");
       	
        	session.save(c1);
        	session.save(c2);
        	session.save(c3);
        	session.save(c4);
        	session.save(c5);
        	session.save(c6);
        	session.save(c7);
        	session.save(c8);
        	session.save(c9);
        	session.save(c10);
        	
        	List<Course> studentCourses = new ArrayList<>();
        	
        	Student s1 = new Student("hluckham0@google.ru", "Hazel Luckham", "X1uZcoIh0dj", studentCourses);
        	Student s2 = new Student("sbowden1@yellowbook.com", "Sonnnie Bowden", "SJc4aWSU", studentCourses);
        	Student s3 = new Student("qllorens2@howstuffworks.com", "Quillan Llorens", "W6rJuxd", studentCourses);
        	Student s4 = new Student("cstartin3@flickr.com", "Clem Startin", "XYHzJ1S", studentCourses);
        	Student s5 = new Student("tattwool4@biglobe.ne.jp", "Thornie Attwool", "Hjt0SoVmuBz", studentCourses);
        	Student s6 = new Student("hguerre5@deviantart.com", "Harcourt Guerre", "OzcxzD1PGs", studentCourses);
        	Student s7 = new Student("htaffley6@columbia.edu", "Holmes Taffley", "xowtOQ", studentCourses);
        	Student s8 = new Student("aiannitti7@is.gd", "Alexandra Iannitti", "TWP4hf5j", studentCourses);
        	Student s9 = new Student("ljiroudek8@sitemeter.com", "Laryssa Jiroudek", "bXRoLUP", studentCourses);
        	Student s10 = new Student("cjaulme9@bing.com", "Cahra Jaulme", "FnVklVgC6r6", studentCourses);
    	
        	session.save(s1);
        	session.save(s2);
        	session.save(s3);
        	session.save(s4);
        	session.save(s5);
        	session.save(s6);
        	session.save(s7);
        	session.save(s8);
        	session.save(s9);
        	session.save(s10);
        	
        	transaction.commit();
        	
        	System.out.println("Database populated.");
    		
    	}catch (PersistenceException e) {
    		System.out.println("Database is already populated, please continue.\n");
		}
	}
	
	/*
	 * @displayMainMenu()
	 * displays main menu for user
	 */
	public void displayMainMenu() {
    	System.out.println("\nPlease select from the following options: \n"
    			+ "1. Student login\n"
    			+ "2. View all courses\n"
    			+ "3. View all students\n"
    			+ "4. Logout\n");
	}
	
	/*
	 * @displayStudentMenu()
	 * displays student menu for user
	 */
	private void displayStudentMenu() {
    	System.out.println("\nPlease select from the following options: \n"
    			+ "1. Register for courses\n"
    			+ "2. View my courses\n"
    			+ "3. Logout\n");
		
	}
	
	private void displayRegisterCoursesMenu() {
    	System.out.println("\nPlease select from the following courses by entering the Id: \n");
    	courseService.getAllCourses();
    	System.out.println("");

	}
	
	/*
	 * Takes in user input
	 * Tests user input is integer and within range: 
	 * 		(startRange to endRange)
	 * @parameter startRange - beginning of the desired range for user input
	 * @parameter endRange - end of the desired range for user input
	 */
	public int selectMenuOption(int startRange, int endRange) {
		
		String userChoice = "";
		
		while(isNumeric(userChoice) == false
				|| Integer.parseInt(userChoice) < startRange
				|| Integer.parseInt(userChoice) > endRange) 
		{
			System.out.println("Enter number " + startRange + " -> " + endRange + ": ");
			userChoice = scnr.next();
		}
		
		return Integer.parseInt(userChoice);
	}
	
	/*
	 * Logic from https://www.baeldung.com/java-check-string-number
	 * w/ slight modification
	 * 
	 * Checks if input is numeric
	 * @parameter stringNum - takes in string to parse
	 * 		if string is not integer, returns false
	 * 		if string is integer, return true
	 */
	public static boolean isNumeric(String stringNum) {
		if (stringNum == null) {
			return false;
		}
		try {
			int i = Integer.parseInt(stringNum);
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}
	
	/*
	 * Navigates user away from main menu based on user input
	 * @parameter userChoice - int parsed from String input
	 * @returnValue - program terminates if return 0
	 */
	public int navigateFromMainMenu(int userChoice) {
		switch (userChoice) {
		case 1: System.out.println("Navigating to login page...\n");
				boolean loginIsSuccessful = login();
				// TODO if loginIsSuccessful, go to other menu to
				// allow them to register for courses
				if(loginIsSuccessful) {
					displayStudentMenu();
					navigateFromStudentMenu(selectMenuOption(1, 3));
				}
			return 1;
		case 2: courseService.getAllCourses();
			return 1;
		case 3: studentService.getAllStudents();
	    	return 1;
		case 4: System.out.println("goodbye");
			return 0;
		default: System.out.println("try again");
			return 0;
		}
	}
	
	private void navigateFromStudentMenu(int userChoice) {
		switch (userChoice) {
		case 1: System.out.println("Navigating to register courses menu...");
		displayRegisterCoursesMenu();
		// TODO remove hard coding
		int courseOption = selectMenuOption(1, 10);
		if (studentService.registerStudentToCourse(currentStudent.getEmail(), courseOption) == true) {
			System.out.println("Registration successful");
			displayStudentMenu();
			navigateFromStudentMenu(selectMenuOption(1, 3));
		}
		else {
			System.out.println("You are already registered for that course.");
			displayStudentMenu();
			navigateFromStudentMenu(selectMenuOption(1, 3));
		}
			break;
		case 2: studentService.getStudentCourses(currentStudent.getEmail());
				displayStudentMenu();
				navigateFromStudentMenu(selectMenuOption(1, 3));
			break;
		case 3: System.out.println("goodbye");
			System.exit(0);
			break;
		}
		
	}

	/*
	 * Login - navigates here after choosing 1 from the main menu
	 * Take in email, password
	 * Validates student
	 * The next menu allows them to also register for courses
	 * 
	 * while login not successful (returns false)
	 * 		ask user to input email/password
	 * 		check against database
	 * 		increase login attempt counter (maybe print it out too)
	 */
	public boolean login() {
		
		String userEmail = "";
		String userPass = "";
		
		boolean studentValidated = false;
		
		int loginAttempts = 0;
		
		while(studentValidated != true) {
			if(loginAttempts > 3) {System.exit(0);}
			if(loginAttempts > 0) {System.out.println("Login attemps: " + loginAttempts);}
			
			System.out.println("Please enter email: ");
			userEmail = scnr.next();
			System.out.println("Please enter password: ");
			userPass = scnr.next();
			try {
				studentValidated = studentService.validateStudent(userEmail, userPass);
			} catch (Exception e) {
				System.out.println("\nWrong Credintials");
			}
			loginAttempts++;
		}
		currentStudent = studentService.getStudentByEmail(userEmail);
		return true;
	}
	

	
	
	
	
}
