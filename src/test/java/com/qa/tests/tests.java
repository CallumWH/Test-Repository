package com.qa.tests;

import com.qa.accounts.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class tests
{
	
	AccountManager accountManager = AccountManager.getAccountManager();
	
	@Test
	public void getSpecifiedSurname()
	{
		accountManager.addAccount("Aldi", "Essentials", 14);
		accountManager.addAccount("Arnie", "Value", 15);
		accountManager.addAccount("Aldi", "Gin", 16);
		accountManager.addAccount("Jim", "ReadyMeal", 17);
		accountManager.addAccount("Aldi", "OwnBrand", 18);
		accountManager.addAccount("Ross", "OwnBrand", 19);
		accountManager.addAccount("Ross", "Arsington", 20);
		
		
		assertEquals("Arnie : 1;Ross : 2;Aldi : 3;Jim : 1;", accountManager.getInstancesOfForenames());
	}
	 
 
	@Test
	public void getJSONofMap()
	{
		accountManager.addAccount("Aldi", "Essentials", 14);
		assertEquals("{\"14\":{\"forename\":\"Aldi\",\"surname\":\"Essentials\",\"accountNumber\":14}}", accountManager.printAccountsJSON());
	}
	
	@Test
	public void testStream()
	{
		accountManager.addAccount("Aldi", "Essentials", 14);
		accountManager.addAccount("Arnie", "Value", 15);
		accountManager.addAccount("Aldi", "Gin", 16);
		accountManager.addAccount("Jim", "ReadyMeal", 17);
		accountManager.addAccount("Aldi", "OwnBrand", 18);
		accountManager.addAccount("Ross", "OwnBrand", 19);
		accountManager.addAccount("Ross", "Arsington", 20);
		assertEquals(3, accountManager.getInstanceOfSpecifiedForename("Aldi"));
	}
	
	@Test
	public void setManualAccountDetails()
	{
		accountManager.addAccount("Aldi", "Essentials", 14);
		
		Account account = accountManager.getAccount(14);
		account.setSurname("Dotharl");
		account.setForename("Kyria");
		
		
		assertEquals("Kyria Dotharl", accountManager.getAccount(14).getForename() + " " + accountManager.getAccount(14).getSurname());
	}
}
