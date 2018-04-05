package com.info.apple;

public class WaveArray {
	public static void main(String[] args) {
		int arr[] = { 2,3,5,6,10,20,80,100 };
		int temp;
		/*int temp;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if (arr[i] < arr[j]) {
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}*/
		for (int i = 0; i < arr.length; i=i+2) {
			
			temp=arr[i];
			arr[i]=arr[i+1];
			arr[i+1]=temp;
			
		}
		
		for (int i = 0; i < arr.length; i++) {
			
			System.out.print(arr[i]+"\t");
		}

		
		
	}

}
