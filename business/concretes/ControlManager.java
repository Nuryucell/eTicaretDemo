package eTicaretDemo.business.concretes;

import java.util.List;
import java.util.regex.Pattern;

import eTicaretDemo.business.abstracts.ControlService;
import eTicaretDemo.entities.concrete.User;

public class ControlManager implements ControlService{

	@Override
	public boolean checkInformations(User user, List<String> emailList) {
		if(this.checkeMail(user, emailList) && 
				this.checkName(user.getFirstName(), user.getLastName()) && 
				this.checkPassword(user.getPassword().length())) {
			return true;
		}else {
			return false;
		}
	}
	@Override
	public boolean checkeMail(User user, List<String> emailList) {
		String emailRegex = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])";

		for(String item : emailList) {
			if(item == user.getEmail()) {
				System.out.println("Sistemde bu mail adresine ait bir kayýt zaten bulunmaktaktadýr!");
				return false;
			}
		}
		if(!Pattern.matches(emailRegex, user.getEmail())) {
			System.out.println("Mail adresinizi kontrol ediniz!");
			return false;
		}else {
			return true;
	}
	}

	@Override
	public boolean checkPassword(int passwordLength) {
		if(passwordLength < 6) {
			System.out.println("Parolanýz en az 6 karakterden oluþmalýdýr! ");
			return false;
		}else {
			return true;
		}
	}
	
	@Override
	public boolean checkName(String firstName, String lastName) {
		if(firstName.length() < 3 && lastName.length() < 3) {
			System.out.println("Ad veya Soyad minimum 3 karakterden oluþmalýdýr!");
			return false;
		}else {
			return true;
		}
	}
}

