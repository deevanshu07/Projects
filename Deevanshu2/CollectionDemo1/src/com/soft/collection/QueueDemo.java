package com.soft.collection;

import java.util.Deque;
import java.util.LinkedList;

public class QueueDemo 
{

	
	public static void main(String[] args) 
	{
		Deque<Integer> queue= new LinkedList<Integer>();
		queue.add(100);
		queue.add(101);
		queue.add(103);
		
		System.out.println("The Queue is "+queue.getFirst());
		System.out.println(queue);
		queue.remove();
		System.out.println(queue);

	}

}
