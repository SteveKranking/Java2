package com.project.login.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Transient;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.Email;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class User{
	public User(){
		this.createdAt = new Date();
		this.updatedAt = new Date();
	}

	@Id
	@GeneratedValue
	private long id;
	@Size(min=1,max=255,message="First name must be between 1-255 characters.")
	private String firstName;
	@Size(min=1,max=255,message="Last name must be between 1-255 characters.")
	private String lastName;
	@Email(message="Invalid Email. Ex: example@example.com")
	private String email;
	@Size(min=1,max=255,message="Password must be between 1-255 characters.")
	private String password;	
	
	private String fullDate;
	private int dueDate;	
	@DateTimeFormat(pattern="MM:dd:yyyy HH:mm:ss")
	private Date owed;
	
	private boolean admin;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="deal_id")
	private Deal deal;

		
	@Transient
	@Size(min=1,max=255)
	private String confirm;

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
	public void setFirstName(String firstName){
		this.firstName=firstName;
	}
	public String getFirstName(){
		return this.firstName;
	}
	public void setLastName(String lastName){
		this.lastName=lastName;
	}
	public String getLastName(){
		return this.lastName;
	}
	public void setConfirm(String confirm){
		this.confirm=confirm;
	}
	public String getConfirm(){
		return this.confirm;
	}
	public void setEmail(String email){
		this.email=email;
	}
	public String getEmail(){
		return this.email;
	}
	public void setAdmin(boolean admin){
		this.admin=admin;
	}
	public boolean isAdmin(){
		return this.admin;
	}
	public void setPassword(String password){
		this.password=password;
	}
	public String getPassword(){
		return this.password;
	}
	/**
	 * @return the dueDate
	 */
	public int getDueDate() {
		return dueDate;
	}
	/**
	 * @param dueDate the dueDate to set
	 */
	public void setDueDate(int dueDate) {
		this.dueDate = dueDate;
	}
	/**
	 * @return the deal
	 */
	public Deal getDeal() {
		return deal;
	}
	/**
	 * @param deal the deal to set
	 */
	public void setDeal(Deal deal) {
		this.deal = deal;
	}
	/**
	 * @return the owed
	 */
	public Date getOwed() {
		return owed;
	}
	/**
	 * @param owed the owed to set
	 */
	public void setOwed(Date owed) {
		this.owed = owed;
	}
	/**
	 * @return the fullDate
	 */
	public String getFullDate() {
		return fullDate;
	}
	/**
	 * @param fullDate the fullDate to set
	 */
	public void setFullDate(String fullDate) {
		this.fullDate = fullDate;
	}
	
}
