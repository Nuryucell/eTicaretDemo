package eTicaretDemo;

import eTicaretDemo.business.abstracts.UserService;
import eTicaretDemo.business.concretes.ControlManager;
import eTicaretDemo.business.concretes.UserManager;
import eTicaretDemo.business.concretes.VerifyManager; 
import eTicaretDemo.core.concretes.GoogleAccountAdapter; 
import eTicaretDemo.dataAccess.concretes.UserInMemoryDao;
import eTicaretDemo.entities.concrete.User;

public class Main {

		public static void main(String[] args) {
			
			User user1 = new User(1,"Nur ", "Yucel", "nuryucel@gmail.com", "123456"); // bilgilerin tamam� do�ru

			User user2 = new User(2,"Fatma", "Kaya", "fatmakaya@", "010203"); // yanl�� mail adresi

			User user3 = new User(3,"A", "Ka", "alikanca@gmail.com", "125ali"); // K�sa isim ve soyisim

			User user4 = new User(4,"Ahmet", "�erefli", "ahmetserefli@gmail.com", "1234"); // K�sa parola

			User user5 = new User(5,"Nur ", "Yucel", "nuryucel@gmail.com", "123456");
			
			User user6 = new User(6, "habibegokcul@gmail.com", "654321", new GoogleAccountAdapter());
			user6.setFirstName("Habibe");
			user6.setLastName("G�k��l");

			User user7 = new User(7,"Azize", "Yo�utrtcu", "azizeygrtc@mail.com", "123456");
			
			UserService userManager = new UserManager(
					new UserInMemoryDao(), 
					new ControlManager(), 
					new VerifyManager());

			userManager.register(user1);
			System.out.println("-------------------------------------------");

			userManager.register(user2);
			System.out.println("-------------------------------------------");

			userManager.register(user3);
			System.out.println("-------------------------------------------");

			userManager.register(user4);
			System.out.println("-------------------------------------------");

			userManager.register(user5);
			System.out.println("-------------------------------------------");

			userManager.register(user6);
			System.out.println("-------------------------------------------");

			userManager.register(user7);
			System.out.println("-------------------------------------------");

			
			userManager.signIn("nuryucel@gmail.com", "123456"); // ba�ar�l� giri�
			System.out.println("\n");
			userManager.signIn("nuryucel@gmail.com", "123456"); // Daha �nce giri� yap�lm��
			System.out.println("-------------------------------------------");

			userManager.signOut("nuryucel@gmail.com", "123456"); // ba�ar�l� ��k��
			System.out.println("-------------------------------------------");

			userManager.signOut("nuryucel@gmail.com", "123456"); // Giri� yapmadan ��k�� yapmak
		}

	}
