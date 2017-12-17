package org.rd.rws.rest.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {

	private static int usersCount = 3;
	private static List<User> users = new ArrayList<>();
	
	static{
		users.add(new User(1,"Ritesh",new Date()));
		users.add(new User(2,"Pranita",new Date()));
		users.add(new User(3,"Ved",new Date()));
	}
	
	public List<User> findAll(){
		return users;
	}
	
	public User save(User user){
		if(user.getId() == null){
			user.setId(++usersCount);
		}
		users.add(user);
		return user;
	}
	
	public User findOne(int id){
		for(User user: users){
			if(user.getId() ==  id){
				return user;
			}
		}
		return null;
	}
	
	public User deleteById(int id){
		Iterator<User> userIterator = users.iterator();
		while(userIterator.hasNext()){
			User user = userIterator.next();
			if(user.getId() == id){
				userIterator.remove();
				--usersCount;
				return user;
			}
		}
		return null;
	}
}
