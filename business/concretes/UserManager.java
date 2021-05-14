package eTicaretDemo.business.concretes;

import eTicaretDemo.business.abstracts.ControlService;
import eTicaretDemo.business.abstracts.UserService;
import eTicaretDemo.business.abstracts.VerifyService;
import eTicaretDemo.dataAccess.abstracts.UserDao;
import eTicaretDemo.entities.concrete.User;

public class UserManager implements UserService{
	UserDao userDao;
	ControlService controlService;
	VerifyService verifyService;
	
	public UserManager(UserDao userDao, ControlService controlService, VerifyService verifyService) {
		super();
		this.userDao = userDao;
		this.controlService = controlService;
		this.verifyService = verifyService;
	}
	
	@Override
	public void signIn(String email, String password) {
		boolean isFound = false;
		if(userDao.getAllUsers() != null) {
			for(User tempUser :  userDao.getAllUsers()) {
				if(tempUser.getEmail() == email && tempUser.getPassword() == password) {	
					isFound = true;
					if(!tempUser.isStatus()) {
						System.out.println("Giri� ba�ar�l� bir �ekilde sa�land�!");
						tempUser.setStatus(true);
					} else {
						System.out.println("Giri� daha �nce ger�ekle�ti!");
					}
				}
			}
			if(!isFound) {
				System.out.println("Email veya parola hatal�. Kontrol ediniz!");
			}
		} else {
			System.out.println("Sistemde �uan kullan�c� bulunmamaktad�r.");
		}
		
	}

	@Override
	public void signOut(String email, String password) {
		boolean isFound = false;
		for(User tempUser :  userDao.getAllUsers()) {
			if(tempUser.getEmail() == email && tempUser.getPassword() == password) {
				isFound = true;
				if(tempUser.isStatus()) {
					System.out.println("��k�� ba�ar�l� bir �ekilde sa�land�!");
					tempUser.setStatus(false);
				}
				else {
					System.out.println("Kullan�c� hen�z giri� yapmad�!");
				}
			}
		}
		if(!isFound) {
			System.out.println("Email veya parola hatal�. Kontrol ediniz!");
		}
		
	}

	@Override
	public void register(User user) {
		if(this.controlService.checkInformations(user,this.userDao.getMailList())) {
			if(this.verifyService.verifyProcess()) {
				System.out.println("Kay�t ba�ar�l� bir �ekilde ger�ekle�ti!");
				this.userDao.add(user);
			} else {
				System.out.println("Hatal� Kod. Kodunuzu tekrar kontrol ediniz!"); 
			}
		} else {
			System.out.println("Hatal� bilgi. Bilgilerinizi kontrol ediniz!");
		}
	}
		
	}
