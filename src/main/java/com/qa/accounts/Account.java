package com.qa.accounts;

public class Account
{
	private String forename;
	private String surname;
	private int accountNumber;
	
	public String getForename()
	{
		return forename;
	}

	public void setForename(String forename)
	{
		this.forename = forename;
	}

	public String getSurname()
	{
		return surname;
	}

	public void setSurname(String surname)
	{
		this.surname = surname;
	}

	public int getAccountNumber()
	{
		return accountNumber;
	}
	
	public Account(String forename, String surname, int accountNumber)
	{
		this.forename = forename;
		this.surname = surname;
		this.accountNumber = accountNumber;
	}
}
