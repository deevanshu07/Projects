import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
public class RegisterClient {

	/**
	 * @param args
	 */
	public static void main(String args[]) {
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }
        try {
            String name = "personserver";
      Registry registry = LocateRegistry.getRegistry(args[0]);
           Register comp = ( Register) registry.lookup(name);
            Person person=new Person(args[1],args[2],args[3]);
             comp.addPerson(person);
        } catch (Exception e) {
            System.err.println("Client ex:");
            e.printStackTrace();
        }
    }    
}



