package sba;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.PersistenceException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.exception.ConstraintViolationException;

import jpa.entitymodels.Course;
import jpa.entitymodels.Student;
import jpa.service.AppHelper;
import jpa.service.CourseService;
import jpa.service.StudentService;

/*
 * @pseudo:
 * 		Populate db with data
 * 		Student logs in
 * 		Student can register courses or logout
 * 		Students and courses can be viewed
 */
public class App extends AppHelper{
	
	/*
	 * @menuStartRange, @menuEndRange
	 * Determines range of values accepted for navigating the current menu
	 */
	private static int menuStartRange = 1;
	private static int menuEndRange = 4;
	
	
    public static void main( String[] args )
    {
    	/*
    	 * created to call helper methods
    	 * increases readability for main method
    	 */
    	AppHelper appHelper = new AppHelper();
    	appHelper.populateDB();
    	
    	/*
    	 * DB is now populated
    	 * 		if already populated, handles exception and continues
    	 * Begin main loop
    	 * User interacts with menus
    	 */
    	
    	/*
    	 * @binaryMainLoopControl - 
    	 * 		if 1, program continues/loops
    	 * 		if 0, program terminates/breaks while
    	 */
    	int binaryMainLoopControl = 1;
    	while(binaryMainLoopControl != 0)
    	{
    		appHelper.displayMainMenu();
    		binaryMainLoopControl = appHelper.navigateFromMainMenu(appHelper.selectMenuOption(menuStartRange, menuEndRange));
    	}

    	
	}

    	

//    	studentService.getStudentByEmail("qllorens2@howstuffworks.com");

    	

    	// TODO Write methods for StudentService
    	// TODO Exception handling (user input especially for wrong characters etc)
    	// TODO Test methods with JUnit (at least one)
    	
    	

    	
    	
//    	CourseService courseService = new CourseService();

//    	courseService.getAllCourses();
    
    
    
}
