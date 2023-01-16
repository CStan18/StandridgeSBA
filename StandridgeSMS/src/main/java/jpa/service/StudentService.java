package jpa.service;

import java.util.List;
import java.util.Set;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import jpa.dao.StudentDAO;
import jpa.entitymodels.Course;
import jpa.entitymodels.Student;

public class StudentService extends HibSessionHelper implements StudentDAO {

	@Override
	public List<Student> getAllStudents() {
	
		Session session = getSession();
		String hql = "FROM Student";
		TypedQuery<Student> query = session.createQuery(hql, Student.class);
		List<Student> studentResultList = query.getResultList();
		
		for (Student student : studentResultList) {
			System.out.println("Student: " + student.getName() + " | Email: " + student.getEmail());
		}
		return studentResultList;
	}

	@Override
	public Student getStudentByEmail(String email) {
		Session session = getSession();
		String hql = "FROM Student s WHERE s.sEmail = :email";
		TypedQuery<Student> query = session.createQuery(hql, Student.class).setParameter("email", email);
		Student student = (Student) query.getSingleResult();
		System.out.println("Student: " + student.getName() + " | Email: " + student.getEmail());
		session.close();
		return student;
	}

	/*
	 * Get student by email
	 * Acquire the password associated with that email
	 * Check it against password given
	 */
	@Override
	public boolean validateStudent(String email, String password) {
		Session session = getSession();
		Student student = getStudentByEmail(email);
		String hql = "FROM Student s WHERE s.sPassword = :password";
		TypedQuery<Student> query = session.createQuery(hql, Student.class).setParameter("password", password);
		Student studentReceived = (Student) query.getSingleResult();
		try {
			if(student.getEmail().equals(studentReceived.getEmail())) {
				return true;
			}
		}catch(NoResultException e) {
			return false;
		}
		 return false;
	}

	/*
	 * Checks if student is already registered for that course
	 * Returns true if student registered for a new course
	 * Returns false if student already registered for that course
	 */
	@Override
	public boolean registerStudentToCourse(String email, int courseId) {
		Session session = getSession();
		Transaction transaction = session.beginTransaction();
		Student currentStudent = (Student) session.get(Student.class, email);
		Course course = (Course) session.get(Course.class, courseId);
		if(currentStudent.getStudentCourses().contains(course)) {
			session.close();
			return false;
		}else {
			currentStudent.addCourse(course);
			session.save(currentStudent);
			transaction.commit();
			session.close();
			return true;
		}
	}

	@Override
	public List<Course> getStudentCourses(String email) {
		Session session = getSession();
		Student currentStudent = (Student) session.get(Student.class, email);
		for(Course course: currentStudent.getStudentCourses()) {
			System.out.println("Id: " + course.getId() + " || " + "Name: " + course.getName()
			+ " || " + "Instructor: " + course.getInstructor());
		}
		
		return null;
	}

}
