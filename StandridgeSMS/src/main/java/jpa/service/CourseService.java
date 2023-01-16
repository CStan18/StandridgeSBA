package jpa.service;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import jpa.dao.CourseDAO;
import jpa.entitymodels.Course;

public class CourseService implements CourseDAO{

	@Override
	public List<Course> getAllCourses() {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		String hql = "FROM Course";
		TypedQuery<Course> query = session.createQuery(hql, Course.class);
		List<Course> courseResultList = query.getResultList();
		
		for (Course course : courseResultList) {
			System.out.println("Id: " + course.getId() + " || " + "Name: " + course.getName()
			+ " || " + "Instructor: " + course.getInstructor());
		}
		return courseResultList;
		
	}

}
