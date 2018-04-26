 import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Insert extends Remote {
	public void insert(String name,String age,String sex) throws RemoteException;
	

}
