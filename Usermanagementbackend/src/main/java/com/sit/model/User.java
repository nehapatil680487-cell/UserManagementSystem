package com.sit.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class User {
	
	@Id
	@GeneratedValue
	private Long id;
	private String username;
	private String name;
	private String email;
	
	public User() {
		super();
	}
	
	public User(Long id,String username,String name,String email) {
		super();
		this.id=id;
		this.username=username;
		this.name=name;
		this.email=email;
	}
	
	public Long getId() {
		return id;
	}
	
	
	public void setId(Long id) {
		this.id=id;
	}
	
	public String getusername() {
		return username;
	}
	
	public void setusername(String username) {
		this.username=username;
	}
	public String getname() {
		return name;
	}
	
	public void setname(String name) {
		this.name=name;
	}
	
	public String getemail() {
		return email;
	}
	
	public void setemail(String email) {
		this.email=email;
	}
	
	@Override
	public String toString() {
	    return "User{" +
	            "id=" + id +
	            ", username=" + username +
	            ", name=" + name +
	            ", email=" + email +
	            '}';
	}
}
