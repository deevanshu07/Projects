package com.infogain.one;

import java.io.*;


public class TestClass {


	public static void main(String[] args) {
		try
		{
			int arr[]= new int[10];
		BufferedReader br =new BufferedReader(new FileReader("C:/Users/DEEVANSHU.MAHAJAN/Desktop/dee1.txt"));
        String b="";
     for (int i = 0; i < 6; i++)
     {
         
        b=br.readLine();
        String k=b.substring(0,b.indexOf(","));
        b=b.substring(b.indexOf(",")+1);
        String m=b.substring(0,b.indexOf(","));
        b=b.substring(b.indexOf(",")+1);
        String n=b.substring(0,b.indexOf(","));
        String p=b.substring(b.indexOf(",")+1);
            
            arr[i]=Integer.parseInt(k);
            /*arr[i]=(int) m;*/
            arr[i]=Integer.parseInt(n);
            arr[i]=Integer.parseInt(p);
            
            System.out.print(arr[i]);
            System.out.print(arr[i]);
            System.out.print(arr[i]);
            System.out.println(arr[i]);
     
       
      }
		
      br.close();
     } catch (Exception e) 
     {
         e.printStackTrace();
     }

	}

}
