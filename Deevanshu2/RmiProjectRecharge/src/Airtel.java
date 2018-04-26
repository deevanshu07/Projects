import java.rmi.Remote;
import java.rmi.RemoteException;
public interface Airtel extends Remote
{
	public String getBalance(PrepaidCustomer customer)throws RemoteException;
}
