import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

class Myclass {
	private static int id;
	private String name;

	public Myclass(int id, String name) {
		// TODO Auto-generated constructor stub
		this.id = id;
		this.name = name;
	}

	public static int getId() {
		return id;
	}

	public static void setId(int id) {
		Myclass.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Myclass [name=" + name + "]";
	}

	protected Object clone() throws CloneNotSupportedException {
		return super.clone();

	}
}

public class StaticCloning {
	public static void main(String[] args) throws Exception {

		Queue<String> queue= new LinkedList<String>();
		queue.add("V");
		queue.add("G");
		queue.add("H");
		queue.add("R");
		System.out.println(queue.peek());
		System.out.println(queue);

		PriorityQueue<String> pQueue= new PriorityQueue<String>();
		pQueue.add("xX");
		pQueue.add("b");
		pQueue.add("t");
		pQueue.add("1");
		System.out.println(pQueue);
		System.out.println(pQueue.poll());
		System.out.println(pQueue);
		
		
	}
}
