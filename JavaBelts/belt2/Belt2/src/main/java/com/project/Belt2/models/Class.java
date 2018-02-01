package com.project.Belt2.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Transient;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.Email;
import org.springframework.format.annotation.DateTimeFormat;

import com.project.Belt2.models.*;


@Entity
public class Class{
	@Id
	@GeneratedValue
	private long id;

	private String days;
	 
	private Date times;

	private String instructor; 

	private String course;
	
	private int numStudents;

	private int maxStudents;

	@ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "students_classes", 
        joinColumns = @JoinColumn(name = "class_id"), 
        inverseJoinColumns = @JoinColumn(name = "user_id")
	)
	private List<User> students;

	@ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "semesters_classes", 
        joinColumns = @JoinColumn(name = "class_id"), 
        inverseJoinColumns = @JoinColumn(name = "semester_id")
	)
	private List<Semester> semesters;

	// Member variables and annotations go here.
	
	@DateTimeFormat(pattern="MM:dd:yyyy HH:mm:ss")
	private Date createdAt;
	
	@DateTimeFormat(pattern="MM:dd:yyyy HH:mm:ss")
	private Date updatedAt;

	@PrePersist
	public void onCreate(){this.createdAt = new Date();}
	@PreUpdate
	public void onUpdate(){this.updatedAt = new Date();}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	// Setters and Getters go here
	
	public Class(){
		this.createdAt = new Date();
		this.updatedAt = new Date();
	}
	/**
	 * @return the days
	 */
	public String getDays() {
		return days;
	}
	/**
	 * @param days the days to set
	 */
	public void setDays(String days) {
		this.days = days;
	}
	/**
	 * @return the times
	 */
	public Date getTimes() {
		return times;
	}
	/**
	 * @param times the times to set
	 */
	public void setTimes(Date times) {
		this.times = times;
	}
	/**
	 * @return the instructor
	 */
	public String getInstructor() {
		return instructor;
	}
	/**
	 * @param instructor the instructor to set
	 */
	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}
	/**
	 * @return the course
	 */
	public String getCourse() {
		return course;
	}
	/**
	 * @param course the course to set
	 */
	public void setCourse(String course) {
		this.course = course;
	}
	/**
	 * @return the numStudents
	 */
	public int getNumStudents() {
		return numStudents;
	}
	/**
	 * @param numStudents the numStudents to set
	 */
	public void setNumStudents(int numStudents) {
		this.numStudents = numStudents;
	}

	public List<User> getStudents() {
		return students;
	}

	public void setStudents(List<User> students) {
		this.students = students;
	}
	/**
	 * @return the maxStudents
	 */
	public int getMaxStudents() {
		return maxStudents;
	}
	/**
	 * @param maxStudents the maxStudents to set
	 */
	public void setMaxStudents(int maxStudents) {
		this.maxStudents = maxStudents;
	}

	public List<Semester> getSemesters() {
		return semesters;
	}

	public void setSemesters(List<Semester> semesters) {
		this.semesters = semesters;
	}
}
