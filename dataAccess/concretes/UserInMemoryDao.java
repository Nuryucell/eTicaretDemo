package eTicaretDemo.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import eTicaretDemo.dataAccess.abstracts.UserDao;
import eTicaretDemo.entities.concrete.User;

public class UserInMemoryDao implements UserDao{
	
	List<String> eMailList = new ArrayList<String>();
	List<User> userList = new ArrayList<User>();
	
	@Override
	public void add(User user) {
		this.userList.add(user);
		this.eMailList.add(user.getEmail());
		System.out.println("Kullanýcý baþarýlý bir þekilde sisteme eklendi : " + user.getFirstName() + " " + user.getLastName());
		
		
	}

	@Override
	public List<String> getMailList() {
		return this.eMailList;
	}
	

	@Override
	public List<User> getAllUsers(){
		return this.userList;
	}

}
