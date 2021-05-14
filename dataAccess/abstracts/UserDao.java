package eTicaretDemo.dataAccess.abstracts;

import java.util.List;

import eTicaretDemo.entities.concrete.User;

public interface UserDao {
	
	void add(User user);
		List<String> getMailList();
		List<User> getAllUsers();
	

}
