import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.TreeSet;

class Car {

	private int year;
	private String name;

	public Car(int year, String name) {
		super();
		this.year = year;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public int getYear() {
		return year;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setYear(int year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return "Car [year=" + year + ", name=" + name + "]";
	}

}

class NameCompare implements Comparator<Car> {

	@Override
	public int compare(Car c, Car c1) {
		// TODO Auto-generated method stub
		return c.getName().compareTo(c1.getName());
	}

}

class DateCompare implements Comparator<Car> {

	@Override
	public int compare(Car c, Car c1) {
		// TODO Auto-generated method stub
		return c.getYear() - c1.getYear();
	}

}

// Driver class
public class Comparison {
	public static void main(String[] args) {

		TreeMap<Car, Integer> carMap = new TreeMap<Car, Integer>(
				new NameCompare());
		carMap.put((new Car(2009, "Audi")), 12);
		carMap.put(new Car(2011, "Lamborgini"), 4);
		carMap.put(new Car(2000, "Bugatti"), 16);
		carMap.put(new Car(2017, "BMW"), 8);
		carMap.put(new Car(1994, "Maruti"), 5);

		TreeSet<Car> treeSet = new TreeSet<Car>(new NameCompare());
		treeSet.add(new Car(2009, "Audi"));

		treeSet.add(new Car(2011, "Lamborgini"));
		treeSet.add(new Car(2000, "Bugatti"));
		 //System.out.println(carMap); 

	}
}