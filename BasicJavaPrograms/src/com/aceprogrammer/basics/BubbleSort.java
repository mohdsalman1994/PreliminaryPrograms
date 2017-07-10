package com.aceprogrammer.basics;

import java.util.Scanner;

public class BubbleSort {
	
	int[] array;
	int n;

	public static void main(String[] args) {
		
		
		BubbleSort bs = new BubbleSort();
		
		
		// read the input from the user
		bs.read();
		
		// sort the array
		bs.sort();
		
		// display the sorted output
		bs.display();

	}
	
	private void read()
	{
		System.out.println("Enter the total nos to be read");
		
		try(Scanner sc = new Scanner(System.in))
		{
			n = sc.nextInt();
			
			array = new int[n];
			
			System.out.println("Enter the elements");
			
			for (int i = 0; i < array.length; i++) {
				array[i] = sc.nextInt();
			}
									
			
		}
	}
	
	private void sort()
	{
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = 0; j < array.length - i -1; j++) {
				if(array[j] > array[j+1])
				{
					int temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
					
				}
			}
		}
	}
	
	private void display()
	{
		System.out.println("The sorted array :");
		for (int i = 0; i < array.length; i++) {
			System.out.printf(" %d \t", array[i]);
		}
	}

}
