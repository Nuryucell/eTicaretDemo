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
						System.out.println("Giriþ baþarýlý bir þekilde saðlandý!");
						tempUser.setStatus(true);
					} else {
						System.out.println("Giriþ daha önce gerçekleþti!");
					}
				}
			}
			if(!isFound) {
				System.out.println("Email veya parola hatalý. Kontrol ediniz!");
			}
		} else {
			System.out.println("Sistemde þuan kullanýcý bulunmamaktadýr.");
		}
		
	}

	@Override
	public void signOut(String email, String password) {
		boolean isFound = false;
		for(User tempUser :  userDao.getAllUsers()) {
			if(tempUser.getEmail() == email && tempUser.getPassword() == password) {
				isFound = true;
				if(tempUser.isStatus()) {
					System.out.println("Çýkýþ baþarýlý bir þekilde saðlandý!");
					tempUser.setStatus(false);
				}
				else {
					System.out.println("Kullanýcý henüz giriþ yapmadý!");
				}
			}
		}
		if(!isFound) {
			System.out.println("Email veya parola hatalý. Kontrol ediniz!");
		}
		
	}

	@Override
	public void register(User user) {
		if(this.controlService.checkInformations(user,this.userDao.getMailList())) {
			if(this.verifyService.verifyProcess()) {
				System.out.println("Kayýt baþarýlý bir þekilde gerçekleþti!");
				this.userDao.add(user);
			} else {
				System.out.println("Hatalý Kod. Kodunuzu tekrar kontrol ediniz!"); 
			}
		} else {
			System.out.println("Hatalý bilgi. Bilgilerinizi kontrol ediniz!");
		}
	}
		
	}
