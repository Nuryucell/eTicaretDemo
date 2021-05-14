package eTicaretDemo.business.abstracts;

import java.util.List;

import eTicaretDemo.entities.concrete.User;

public interface ControlService {

	public boolean checkInformations(User user, List<String> emailList);
	public boolean checkeMail(User user, List<String> emailList);
	public boolean checkPassword(int passwordLength);
	public boolean checkName(String firstName,String lastName);
}
