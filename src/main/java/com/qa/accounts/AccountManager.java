package com.qa.accounts;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

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
	
	public String getInstancesOfForenames()
	{
		HashMap<String, Integer> instancesOfNameMap = new HashMap<String, Integer>();
		Iterator it = hmap.entrySet().iterator();
		
		while(it.hasNext())
		{
			Map.Entry pair = (Map.Entry)it.next();
			Account account = (Account)pair.getValue();	
			
			if(instancesOfNameMap.containsKey(account.getForename()))
			{
				instancesOfNameMap.put(account.getForename(), instancesOfNameMap.get(account.getForename()) + 1);
			}
			else
			{
				instancesOfNameMap.put(account.getForename(), 1);
			}		
		}
		
		String returnString = "";
		it = instancesOfNameMap.entrySet().iterator();
		while(it.hasNext())
		{
			Map.Entry pair = (Map.Entry)it.next();
			returnString += new String(pair.getKey() + " : " + pair.getValue() + ";");
		}
		return returnString;
	}
	
	public int getInstanceOfSpecifiedForename(String name)
	{
		return (int)hmap.values().stream().filter(account -> account.getForename().equals(name)).count();
	}
	
	public String printAccountsJSON()
	{
		JSONObject JsonObject = new JSONObject(hmap);
		return JsonObject.toString();
	}
}
