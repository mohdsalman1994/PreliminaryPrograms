package com.aceprogrammer.basics;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;

public class BinaryWordSearch {
	
	private String[] words;
	private String filePath = "src/resources/words.txt";

	public static void main(String[] args) throws IOException {
		
		
		String s;
		try(Scanner sc = new Scanner(System.in);)
		{
		// get user's input
		System.out.println("Enter the word to search");
		s = sc.next();		
		}
		
		BinaryWordSearch bs = new BinaryWordSearch();
		
		bs.readFile();
		bs.sort();
		bs.searchAndDisplay(s);		

	}
	

	private void sort() {
		
		Arrays.sort(words);		
		
	}


	private void readFile() throws IOException {
		
		//read the file and store it in a String array
				Path p = Paths.get(filePath);
				
				String content	= new	String(Files.readAllBytes(p));
				
				words = content.split(" ");							
		
	}

	
	private void searchAndDisplay(String s) {
		int i = Arrays.binarySearch(words, s);
		if(i >=0)
			System.out.println("Match found");
		else
			System.out.println("No Match Found");
		
	}


}
