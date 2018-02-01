package com.project.OneToOne.models;

import java.util.Date;
import javax.persistence.CascadeType;
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
@Table(name="persons")
public class Person {
    
    @Id
    @GeneratedValue
    private Long id;
    private String first;
    private String last;

    @Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;

	@OneToOne(mappedBy="person", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name="license_id")
	private License license;

    
    public Person() {
        
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

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
    
    public Long getId() {
		return id;
    }
    
    public String getFirst() {
		return first;
	}

	public String getLast() {
		return last;
    }
    
    public void setId(Long id) {
		this.id = id;
	}

	public void setFirst(String first) {
		this.first = first;
	}

	public void setLast(String last) {
		this.last = last;
	}

	public License getLicense() {
		return license;
    }
    
    public void setLicense(License license) {
		this.license = license;
	}
    // ...
    // getters and setters removed for brevity
    // ...


}