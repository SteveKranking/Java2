package com.project.LOTBeltReview.models;

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

@Entity
public class Guild{
	@Id
	@GeneratedValue
	private long id;

	@Size(min=1, max=15, message="Guild name must be between 1-15 characters!")
	private String guildName;

	@Size(max = 10, message="You can only have a max on 10 people in your Guild!")
	private int guildSize;

	// Member variables and annotations go here.
	
	@DateTimeFormat(pattern="MM:dd:yyyy HH:mm:ss")
	private Date createdAt;
	
	@DateTimeFormat(pattern="MM:dd:yyyy HH:mm:ss")
	private Date updatedAt;

	@ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "users_guilds", 
        joinColumns = @JoinColumn(name = "guild_id"), 
        inverseJoinColumns = @JoinColumn(name = "user_id")
    )
	private List<User> members;

	private Date age;

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
	
	public Guild(){
		this.createdAt = new Date();
		this.updatedAt = new Date();
	}

	public String getGuildName() {
		return guildName;
	}
	public void setGuildName(String guildName) {
		this.guildName=  guildName;
	}

	public int getGuildSize() {
		return guildSize;
	}
	public void setGuildSize(int guildSize) {
		this.guildSize = guildSize;
	}

	public Date getAge() {
		return age;
	}
	public void setAge(Date age) {
		this.age = age;
	}

	public List<User> getMembers() {
		return members;
	}
	public void setMembers(List<User> members) {
		this.members = members;
	}
	
}
