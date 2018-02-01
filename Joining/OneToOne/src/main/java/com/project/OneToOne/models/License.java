package com.project.OneToOne.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.project.OneToOne.services.LicenseService;
import com.project.OneToOne.services.PersonService;


@Entity
@Table(name="licenses")
public class License {
    
    @Id
    @GeneratedValue
	private Long id;
	private int number = 0;

	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date expirationDate;
	
	@Size(min=2, max=2, message = "Must be abbreviation of State")
	private String state;
	
    @Column(updatable=false)
    private Date createdAt;
	private Date updatedAt;
	
    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="person_id")
    private Person person;
    
    public License() {
        number = number + 1;
    }

    protected Date getCreatedAt() {
		return createdAt;
	}

	protected void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

    public Date getUpdatedAt() {
		return updatedAt;
	}
    
    public Long getId() {
		return id;
    }
    
    public Date getExpirationDate() {
		return expirationDate;
	}

	public String getState() {
		return state;
    }
    
    public void setId(Long id) {
		this.id = id;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public Person getPerson() {
		return person;
	}
	
	public void setPerson(Person person) {
		this.person = person;
	}
   
    
    // ...
    // getters and setters removed for brevity
    // ...
}