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
	@Id
	@GeneratedValue
	private long id;

	// Member variables and annotations go here.
	
	@DateTimeFormat(pattern="MM:dd:yyyy HH:mm:ss")
	private Date createdAt;
	
	@DateTimeFormat(pattern="MM:dd:yyyy HH:mm:ss")
	private Date updatedAt;

	@Size(min=1, message="Username cannot be blank")
	private String username;

	@Email
	private String email;
	
	@Size(min=8, message="Password must be at least eight characters")
	private String password;

	@Transient
	@Size(min=1, message="Password confirmation is required")
	private String confirm;	

	@ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "users_guilds", 
        joinColumns = @JoinColumn(name = "user_id"), 
        inverseJoinColumns = @JoinColumn(name = "guild_id")
	)
	private List<Guild> guilds;
	
	@OneToMany(mappedBy="user", fetch = FetchType.LAZY)
    private List<Ring> rings;


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
	
	public void setUsername(String username) {
		this.username=username;
	}

	public String getUsername() {
		return username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirm() {
		return confirm;
	}
	public void setConfirm(String confirm) {
		this.confirm = confirm;
	}

	// Setters and Getters go here
	public List<Ring> getRings() {
		return rings;
	}
	public void setRings(List<Ring> rings) {
		this.rings = rings;
	}

	public List<Guild> getGuilds() {
		return guilds;
	}
	public void setGuilds(List<Guild> guilds) {
		this.guilds = guilds;
	}

	public User(){
		super();
		this.createdAt = new Date();
		this.updatedAt = new Date();
	}

}

	
