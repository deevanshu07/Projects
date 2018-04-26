import java.rmi.Remote;
import java.rmi.RemoteException;
public interface NewInterface extends Remote
{
	public String updateEmployee(Employee employee) throws RemoteException;
}
