package com.qa.accounts;
import java.util.HashMap;

import org.json.JSONObject;

public class AccountManager 
{
	private HashMap<Integer, Account> hmap = new HashMap<Integer, Account>();
	private static AccountManager accountManager = null;
	
	private AccountManager()
	{
	}
	
	static public AccountManager getAccountManager()
	{
		if(accountManager != null)
		{
			return accountManager;
		}
		else
		{
			accountManager = new AccountManager();
			return accountManager;
		}
	}
	
	public void addAccount(Account accountToAdd)
	{
		hmap.put(accountToAdd.getAccountNumber(), accountToAdd);
	}
	
	public void addAccount(String forename, String surname, int accountNumber)
	{
		Account accountToAdd = new Account(forename, surname, accountNumber);
		hmap.put(accountToAdd.getAccountNumber(), accountToAdd);
	}
	
	public Account getAccount(int accountNumber)
	{
		Account returnAccount = hmap.get(accountNumber);

		if(returnAccount != null)
		{
			return returnAccount;
		}
		else
		{
			throw new NullPointerException();
		}
	}
	
	public void printAccountsJSON()
	{
		JSONObject JsonObject = new JSONObject(hmap);
		System.out.print(JsonObject);
	}
}
