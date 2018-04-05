
interface Bike{
	public void bikeName(String bikeName);
}
class BikeFactory{
	String bikeName;
	public static Bike getInstance(String bikeName) throws Exception{
		return (Bike)Class.forName(bikeName).newInstance();
	}
}
class Kawasaki implements Bike{
	@Override
	public void bikeName(String bikeName) {
		System.out.println("Name of the bike is= "+bikeName);	
	}	
}
public class FactoryPattern {
	public static void main(String[] args) throws Exception{
		Bike bike=BikeFactory.getInstance("Kawasaki");
	}
}
