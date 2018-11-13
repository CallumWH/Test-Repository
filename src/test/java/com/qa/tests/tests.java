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
		accountManager.addAccount("Aldi", "Value", 15);
		accountManager.addAccount("Aldi", "Gin", 16);
		accountManager.addAccount("Aldi", "ReadyMeal", 17);
		accountManager.addAccount("Aldi", "OwnBrand", 18);
		
		assertEquals(5, accountManager.getInstancesOfForename("Aldi"));
	}
	
}
