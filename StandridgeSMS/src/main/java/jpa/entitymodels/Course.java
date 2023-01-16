
/*
 * @author Caleb Standridge
 */
package jpa.entitymodels;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Course {
	
	private static final long serialVersionUID = 1L;
	
	/*
	 * Represents a course within a curriculum
	 * ------------------------
	 * @CourseInstanceVariables
	 * 
	 * @id - unique course identifier - pk - not null
	 * @name - name of course - not null
	 * @instructor - instructor's name - not null
	 */
	
	@Id
	@Column(name = "Id", nullable = false)
	private int cId;
	@Column(name = "Name", nullable = false, length = 50)
	private String cName;
	@Column(name = "Instructor", nullable = false, length = 50)
	private String cInstructor;

	public Course() {
		this.cId = 0;
		this.cName = "";
		this.cInstructor = "";
	}
	
	public Course(int id, String name, String instructor) {
		super();
		this.cId = id;
		this.cName = name;
		this.cInstructor = instructor;
	}
	public int getId() {
		return cId;
	}
	public void setId(int id) {
		this.cId = id;
	}
	public String getName() {
		return cName;
	}
	public void setName(String name) {
		this.cName = name;
	}
	public String getInstructor() {
		return cInstructor;
	}
	public void setInstructor(String instructor) {
		this.cInstructor = instructor;
	}
	
	@Override
	public String toString() {
		return "Course [cId=" + cId + ", cName=" + cName + ", cIString=" + cInstructor + "]";
	}
	
}
