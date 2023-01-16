package jpa.dao;

import java.util.List;

import jpa.entitymodels.Course;
import jpa.entitymodels.Student;

public interface StudentDAO {
	
	public List<Student> getAllStudents();
	
	public Student getStudentByEmail(String email);
	
	public boolean validateStudent(String email, String password);
	
	public boolean registerStudentToCourse(String email, int courseId);
	
	public List<Course> getStudentCourses(String email);
}
