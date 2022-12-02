package day1;

import java.io.BufferedReader;
import java.io.FileReader;

public class CalorieCounter {
	
	public static void main(String[] args) {
		
		FileReader file;
		BufferedReader stream;
		String fileName = "input/d1.txt";
		
		int total = 0;
		
		int [] topCalories = new int[3]; 
		
		try {	
			file = new FileReader(fileName);
			stream = new BufferedReader(file);
			String line;
			int current, sum = 0;
			
			while ( (line = stream.readLine()) != null) { // null = EOF
				
				if ( !line.isEmpty() ) {
					current = Integer.parseInt(line);
					
					sum += current;
					
				} else {
					
					//System.out.println(sum);
					
					for (int i = topCalories.length-1; i >= 0; i--) {
						if (sum > topCalories[i]) {
							topCalories[i] = sum;
							
							//have to sort so that position of greatest # is consistent
							//otherwise, it could be possible to overwrite and discard a value
							sort(topCalories);
							
							break;
						}
					}
					
					sum = 0; //reset for next iteration
					
				}					
			}
			
			//List contents of array
			System.out.println("Top "+topCalories.length+" most calories:");
			for (int i = 0; i < topCalories.length; i++) {
				System.out.println((i+1)+": "+topCalories[i]);
				
				total += topCalories[i];
				
				
			}
			
			//List total
			System.out.println("Total of the top "+topCalories.length+": "+total);
			
			
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		
	}
	
	//recursive sorting
	public static void sort(int[] arr) {
		
		int n = arr.length-1;
		int counter = 0;
		
		//length of 1 - no need to sort
		if (n == 1) {
			return;
		}
		
		for (int i = 0; i < n; i++) {
			
			//is n greater than n+1
			//if yes, then swap
			if ( arr[i] < arr[i+1] ) {
				
				int temp = arr[i];
				arr[i] = arr[i+1];
				arr[i+1] = temp;
				
			} else {
				counter++;
			}
		}
		
		if (counter == n) {
			return;
		}
		
		sort(arr);
		
	}
	
}
