package sba;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import jpa.entitymodels.Course;
import jpa.entitymodels.Student;

public class StudentTest {

	/*
	 * These tests test if students are instantiated and edited correctly
	 */
	@Test
	public void testStudentConstructor() {
		// Given
		Student student = new Student();
		String expectedName = "";
		String expectedEmail = "";
		String expectedPassword = "";
		List<Course> courses = new ArrayList<>();
		
		// When
		String actualName = student.getName();
		String actualEmail = student.getName();
		String actualPassword = student.getName();
		
		// Then
		assertEquals(expectedName, actualName);
		assertEquals(expectedEmail, actualEmail);
		assertEquals(expectedPassword, actualPassword);
	}
	
	@Test
	public void testStudentParamConstructor() {
		// Given
		String expectedName = "Hazel Luckham";
		String expectedEmail = "hluckham0@google.ru";
		String expectedPassword = "X1uZcoIh0dj";
		List<Course> expectedCourses = new ArrayList<>();
		
		Student student = new Student(
				expectedEmail,
				expectedName,
				expectedPassword,
				expectedCourses);

		// When
		String actualName = student.getName();
		String actualEmail = student.getEmail();
		String actualPassword = student.getPassword();
		
		// Then
		assertEquals(expectedName, actualName);
		assertEquals(expectedEmail, actualEmail);
		assertEquals(expectedPassword, actualPassword);
		assertTrue(expectedCourses.isEmpty());
		
	}
	
	@Test
	public void testSetInstanceVariables() {
		// Given
		Student student = new Student();
		String expectedName = "Hazel Luckham";
		String expectedEmail = "hluckham0@google.ru";
		String expectedPassword = "X1uZcoIh0dj";
		
		// When
		student.setName(expectedName);
		student.setEmail(expectedEmail);
		student.setPassword(expectedPassword);
		
		// Then
		assertEquals(expectedName, student.getName());
		assertEquals(expectedEmail, student.getEmail());
		assertEquals(expectedPassword, student.getPassword());
		
	}
	
}
