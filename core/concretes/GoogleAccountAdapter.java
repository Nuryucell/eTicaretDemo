package eTicaretDemo.core.concretes;

import eTicaretDemo.accounts.GoogleAccount;
import eTicaretDemo.core.abstracts.AccountService;

public class GoogleAccountAdapter implements AccountService{
	@Override
	public void signUpSocialAccounts(String email, String password) {
		GoogleAccount googleAccount = new GoogleAccount();
		googleAccount.signUpWithGoogle(email, password);
	}
}

