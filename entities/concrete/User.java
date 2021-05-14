package eTicaretDemo.entities.concrete;

import eTicaretDemo.core.abstracts.AccountService;
import eTicaretDemo.entities.abstracts.Entity;

public class User implements Entity {
	private boolean status;
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	
	AccountService accountService;
	
	public User(int id, String eMail, String password, AccountService accountService) {
		super();
		this.email = eMail;
		this.password = password;
		this.accountService = accountService;
		this.status = false;
	}
	public User() {
		
	}

	public User(int id, String firstName, String lastName, String email, String password) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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

}
