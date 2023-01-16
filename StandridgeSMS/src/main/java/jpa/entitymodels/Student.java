
/*
 * @author Caleb Standridge
 */
package jpa.entitymodels;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

@Entity
@Table
public class Student {
	
	private static final long serialVersionUID = 1L;
						
	/*
	 * Represents a student. Students can register for courses.
	 * ------------------------
	 * @StudentInstanceVariables
	 * 
	 * @email - student's email - pk - not null
	 * @name - student's name - not null
	 * @password - student's password to log into db - not null
	 */
	
	@Id
	@Column(name = "Email", nullable = false, length = 50)
	private String sEmail;
	@Column(name = "Name", nullable = false, length = 50)
	private String sName;
	@Column(name = "Password", nullable = false, length = 50)
	private String sPassword;
	@ManyToMany(targetEntity = Course.class)
	private List<Course> sCourses;
	

	
	public Student() {
		
		this.sEmail = "";
		this.sName = "";
		this.sPassword = "";
	}
	
	public Student(String email, String name, String password, List<Course> courseList) {
		super();
		this.sEmail = email;
		this.sName = name;
		this.sPassword = password;
		this.sCourses = courseList;
	}
	
//	public Set getCourseSet() {
//		return CourseSet;
//	}

	public String getEmail() {
		return sEmail;
	}
	
	public void setEmail(String email) {
		this.sEmail = email;
	}
	
	public String getName() {
		return sName;
	}
	
	public void setName(String name) {
		this.sName = name;
	}
	
	public String getPassword() {
		return sPassword;
	}
	
	public void setPassword(String password) {
		this.sPassword = password;
	}
	
	public void addCourse(Course course) {
		sCourses.add(course);
	}
	
	public void removeCourse(Course course) {
		sCourses.remove(course);
	}
	
	public List<Course> getStudentCourses() {
		return this.sCourses;
	}

	@Override
	public String toString() {
		return "Student [sEmail=" + sEmail + ", sName=" + sName + ", sPassword=" + sPassword + ", CourseSet="
				+ sCourses + "]";
	}



}
