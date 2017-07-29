package com.aceprogrammer.basics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class NumberGuess {

	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		System.out.println("Let's play a game of number guessing");
		System.out.println("Enter the maximum no");
		int n = Integer.parseInt(br.readLine());
		Guesser g = new Guesser(n);
		g.guess();
		g.display();

	}

}

class Guesser
{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	int[] array;
	boolean found = false;
	ArrayList<Integer> guessList;
	int low;
	int mid;
	int high;
	int result;
	String guess;

	// initialize our array in which we will search
	public Guesser(int n) {
				
		array = new int[n];
		for (int i = 0; i < array.length; i++) {
			array[i]= i;
		}
		
	}

	public void display() {
		
		System.out.print("Intermediate results: ");
		for (Integer i : guessList) {
			System.out.print(i+" ");
		}
		System.out.println("\n"+result);
		
	}

	// main logic of our program
	public void guess() throws IOException {
				
		guessList  = new ArrayList<>();
		low = 0;
		high = array.length - 1;
		mid = (low + high)/ 2;
		
		// keep guessing until the result is found
		while(!found)
		{
			// check if there are only two elements to be searched
			
			if((high - low)== 1)
			{
			    // now we have narrowed down the search hence it must be either one of the two
				found = true;
				System.out.println("Is it "+array[low]+"?");
				guess = br.readLine();
				
				// set the result by asking the user last time whether it's low or high element
				if(guess.equalsIgnoreCase("y"))
				{
				  result = array[low];				  				  
			     }
				else
				{
					result = array[high];					
				}			
		
		}
			// keep dividing the array by half
			else
			{
				System.out.println("Is it between "+array[low] +" and "+ array[mid]);
				guess = br.readLine();
				
				// if in between the first half then search in that range
				if(guess.equalsIgnoreCase("y"))
				{
					
					// check for special case of odd elements
					if((high - low) == 2)
					{
						high = mid;
					}
					else
					{
					guessList.add(array[mid]);
					high = mid;
					mid = (low + high)/ 2;
					}
					
				}
				
				// else search the second half
				else
				{
					
					// check for special case of only 3 remaining elements
					if((high - low) == 2)
					{
						low = mid;
					}
					else
					{
					guessList.add(array[mid]);
					low = mid + 1;
					mid = (low + high) / 2;
					}
				}
			}
		
	}
	
	}
}






