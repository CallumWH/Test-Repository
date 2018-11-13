
public class main {

	public static void main(String[] args) 
	{
		AccountManager accountManager = AccountManager.createAccountManager();
		
		accountManager.addAccount(70, "Ross", "GEORGE");
		
		accountManager.printAccountsJSON();
	}

}
