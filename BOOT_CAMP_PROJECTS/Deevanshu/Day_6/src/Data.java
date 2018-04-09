
public class Data {

	
	 public int getValue() {
		return value;
	}

	 public void setValue(int value) {
		this.value = value;
	}

	int value=100;
	synchronized public int inc()
	{
		return ++value;
		
	}
	
	synchronized public int dec()
	{
		return --value;
	}
	
	synchronized public int print()
	{
		return value;
	}

}
