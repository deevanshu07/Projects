
public class Bank implements Runnable 
{

	private Account account;

	public Bank(Account account) 
	{
		this.account=account;
	}

	public void run() 
	{
		for (int i=0; i<5; i++)
		{
			account.subtractAmount(100);
		}
	}

}
