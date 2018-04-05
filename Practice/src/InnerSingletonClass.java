import java.lang.reflect.Constructor;

interface ABCD{
	
}
class SingletonImpl {
	private static SingletonImpl single;

	private static class SingletonHolder{
		public static SingletonImpl getInstance() {
			if (single == null) {
				single = new SingletonImpl();
			}
			return single;
		}
	}

	private SingletonImpl() {
	}

	public static SingletonImpl getInstance() {
		return SingletonHolder.getInstance();
	}
}

public class InnerSingletonClass {
	public static void main(String[] args) throws Exception {

		SingletonImpl single = SingletonImpl.getInstance();
		SingletonImpl single1 = null;
		System.out.println(single.hashCode());
		Constructor[] constructor = SingletonImpl.class
				.getDeclaredConstructors();
		for (Constructor cons : constructor) {
			cons.setAccessible(true);
			single1 = SingletonImpl.getInstance();
		}

		System.out.println(single1.hashCode());
	}
}
