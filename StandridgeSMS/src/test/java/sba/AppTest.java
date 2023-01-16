package sba;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.junit.Before;
import org.junit.Test;

import jpa.entitymodels.Student;
import jpa.entitymodels.Course;
import jpa.service.HibSessionHelper;
import jpa.service.StudentService;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
	private static StudentService studentService;
	
    /**
     * 
     */
    @Test
    public void testGetStudentByEmail() {
    
    	// Given
    	studentService = new StudentService();
		String expectedName = "Hazel Luckham";
		String expectedEmail = "hluckham0@google.ru";
		String expectedPassword = "X1uZcoIh0dj";
		List<Course> courses = new ArrayList<>();
        Student expectedStudent = new Student();
        expectedStudent.setEmail(expectedEmail);
        expectedStudent.setName(expectedName);
        expectedStudent.setPassword(expectedPassword);
        
        // When
        Student actualStudent = studentService.getStudentByEmail(expectedEmail);
        
        // Then
        assertEquals(expectedStudent.getEmail(), actualStudent.getEmail());
        assertEquals(expectedStudent.getName(), actualStudent.getName());
        assertEquals(expectedStudent.getPassword(), actualStudent.getPassword());
     
    }
}
