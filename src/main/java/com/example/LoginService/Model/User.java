package com.example.LoginService.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
	
	@Id
private	long id;
public User() {
		super();
	}
public User(long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
private String name;
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}


}
