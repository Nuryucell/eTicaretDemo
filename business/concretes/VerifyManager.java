package eTicaretDemo.business.concretes;

import java.util.Random;
import java.util.Scanner;

import eTicaretDemo.business.abstracts.VerifyService;

public class VerifyManager implements VerifyService {
	Scanner scanner = new Scanner(System.in);
	Random random = new Random();
	String verifyCode = "";
	String inputVerifyCode;
	
	@Override
	public boolean verifyProcess() {
		this.generateVerifyCode();
		this.sendVerifyCode();

		if (this.checkVerifyCode()) {
			return true;
		}
		else {
			return false;
		}
	}
		

	@Override
	public void generateVerifyCode() {
		Random random = new Random();
		int code = random.nextInt(999999);
		String mycode = String.format("%06d", code);
		this.verifyCode = mycode;
		
	}

	@Override
	public void sendVerifyCode() {
		System.out.println("doðrulama kodunuz : " + verifyCode);
		System.out.println("Lütfen doðrulama kodunuzu giriniz : ");
		this.inputVerifyCode = scanner.next();
		
	}

	@Override
	public boolean checkVerifyCode() {
		if (this.verifyCode.equals(inputVerifyCode)) {
			this.inputVerifyCode = "";
			this.verifyCode = "";
			return true;	
		}else {
			return false;
		}
	}

}
