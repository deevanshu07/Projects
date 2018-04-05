import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.util.Collections;



class Singleton implements Cloneable,Serializable{
	private static Singleton single=null;
	private Singleton(){
	}
	public static Singleton getInstance(){
		if(single==null)
			single= new Singleton();
		return single;
	}
	
	protected Object clone() throws CloneNotSupportedException{
		return single;
	}
	
	protected Object readResolve(){
		return single;
	}
}


public class SingletonPatternBreakage {
	public static void main(String[] args) throws Exception {
		
		Singleton single= Singleton.getInstance();
		Singleton single1= null;
		Singleton single2=(Singleton) single.clone();
		@SuppressWarnings("rawtypes")
		Constructor []constructor=Singleton.class.getDeclaredConstructors();
		for(Constructor<?> cons:constructor){
			cons.setAccessible(true);
			single1= (Singleton) cons.newInstance();
		}
		
		System.out.println(single.hashCode());
		System.out.println(single1.hashCode());
		System.out.println(single2.hashCode());
		
		String fileName="C:\\Users\\deevanshu.mahajan\\Desktop\\data.txt";
		FileOutputStream file= new FileOutputStream(fileName);
		ObjectOutputStream out= new ObjectOutputStream(file);
		out.writeObject(single);
		out.flush();
		System.out.println("Success");
		
		ObjectInputStream in= new ObjectInputStream(new FileInputStream(fileName));
		Singleton deserializeSingle=(Singleton)in.readObject();
		System.out.println(deserializeSingle.hashCode());
		
		
	}
}
