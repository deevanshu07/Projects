package com.soft.classes;

import java.util.Scanner;

public class Touristclass 
{
	public void showMenu()
	{
		System.out.println("This Is Main Menu");
	}
	public static void main(String[] args) 
	{
	
		
		
		System.out.println("Welcome");
		
		int choice;
		Scanner sc= new Scanner(System.in);
		do
		{
			Touristclass t= new Touristclass();
			System.out.println("1 Show Menu");
			System.out.println("2 Give Order");
			System.out.println("Enter choice");
			choice=sc.nextInt();
			switch(choice)
			{
			case 1: 
					t.showMenu();
					
			break;
			
			case 2: 
				break;
				
			
			}
			
		}while(true);

	}

}
