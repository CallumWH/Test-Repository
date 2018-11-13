import java.util.HashMap;

import org.json.JSONObject;

public class AccountManager 
{
	private HashMap<Integer, Account> hmap = new HashMap<Integer, Account>();
	private static AccountManager accountManager = null;
	
	private AccountManager()
	{
		hmap.put(25, new Account("firstName", "secondName", 25));
		hmap.put(21, new Account("Tux", "Deep", 21));
		hmap.put(14, new Account("Aldi", "Essentials", 14));
	}
	
	static public AccountManager createAccountManager()
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
	
	public void addAccount(int accountNumber, String forename, String surname)
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
		System.out.print(new JSONObject(hmap));
	}
}
