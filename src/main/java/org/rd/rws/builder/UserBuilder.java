package org.rd.rws.builder;

import java.util.Date;

import org.rd.rws.rest.model.User;

public class UserBuilder {

	private User user;
	
	public UserBuilder(){
		this.user = new User();
	}
	
	public UserBuilder withId(int id){
		this.user.setId(id);
		return this;
	}
	
	public UserBuilder hasName(String name){
		this.user.setName(name);
		return this;
	}
	
	public UserBuilder wasBornOn(Date birthDate){
		this.user.setBirthDate(birthDate);
		return this;
	}
	
	public User build(){
		return user;
	}
}
