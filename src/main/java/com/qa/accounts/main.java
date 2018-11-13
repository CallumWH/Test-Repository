package com.qa.accounts;

public class main {

	public static void main(String[] args) 
	{
		AccountManager accountManager = AccountManager.getAccountManager();
		
		//accountManager.addAccount("Ross", "GEORGE", 70);
		//accountManager.addAccount("firstName", "secondName", 25);
		//accountManager.addAccount("Tux", "Deep", 21);
		accountManager.addAccount("Aldi", "Essentials", 14);
		
		accountManager.printAccountsJSON();
	}

}
