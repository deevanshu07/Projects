package com.info.factoryBean;


interface a{
int x=10;
void show();
}

interface b{
int a=20;
void show();
}

class superClass{
	protected int calaulate(){
		return 5;
	}

}


class subClass extends superClass{
	public int calculate(){
		return 10;
	}
}



public class ChainedExceptions implements a,b {
	public static void main(String[] args)  {
	
		superClass s= new subClass();
		System.out.println("Calculation result="+s.calaulate());

	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}



}
