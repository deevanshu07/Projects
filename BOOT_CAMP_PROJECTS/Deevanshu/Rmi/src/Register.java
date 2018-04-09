import java.rmi.Remote;
import java.rmi.RemoteException;


public interface Register extends Remote {
	
	public String addPerson(Person person) throws RemoteException;

}
