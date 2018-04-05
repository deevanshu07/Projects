import java.util.LinkedList;
import java.util.Queue;



class StackByQueue{
	Queue<String> mainQueue= new LinkedList<String>();
	Queue<String> tempQueue= new LinkedList<String>();
	
	public void push(String data){
		mainQueue.add(data);
		System.out.println(mainQueue);
	}
	
	public void pop(){
		if(mainQueue.size()<1){
			System.out.println("Queue already Empty");
			return;
		}
		
		while(mainQueue.size()>1){
			tempQueue.add(mainQueue.poll());
		}
		System.out.println(mainQueue.poll());
		mainQueue=tempQueue;
		tempQueue= new LinkedList<String>();
	}
	
}


public class StackUsingQueue {
	public static void main(String[] args) {
		StackByQueue stackUsingQueue = new StackByQueue();
		stackUsingQueue.push("10");
		  stackUsingQueue.push("20");
		  stackUsingQueue.push("30");
		  stackUsingQueue.push("40");
		 
		  stackUsingQueue.pop();
		  stackUsingQueue.pop();
		  stackUsingQueue.pop();
		 
		  stackUsingQueue.push("50");	
		  stackUsingQueue.push("60");
		 
		  stackUsingQueue.pop();
		  stackUsingQueue.pop();
		  stackUsingQueue.pop();
		  stackUsingQueue.pop();
		  stackUsingQueue.pop();
		  stackUsingQueue.pop();
		  stackUsingQueue.pop();
		  
		  
		  
		  
	}

}
