
public class Account 
{

	private double balance;
	public double getBalance() 
	{
		return balance;
	}

	public void setBalance(double balance)
	{
		this.balance = balance;
	}
	
	synchronized public void addAmount(double amount) 
	{
		double tmp=balance;
		try 
		{
			Thread.sleep(100);
		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
		tmp+=amount;
		balance=tmp;
	}
	
	synchronized public void subtractAmount(double amount) 
	{
		double tmp=balance;
		try 
		{
			Thread.sleep(100);
		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
		
			tmp-=amount;
			balance=tmp;
	}
	
}
