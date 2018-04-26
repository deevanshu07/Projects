

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Testinterface extends Remote 
{
	public String showMessage() throws RemoteException;

}
