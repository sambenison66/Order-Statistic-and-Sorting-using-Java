/*
 * Algorithm Project - Order Statistics and Sorting
 * Developed by : Vivek Bhalala, Samuel Benison, Arun Pokharna, Sneha Kulkarni
 * Fall 2014 - CSE 5311
 */

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

// This is the main class of this project
public class OrderStatAndSorting {
	public static BufferedReader br = null;
	public static double[] dataSet;
	public static int k;

	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		String csvFilePath = "";
		Scanner getInput = new Scanner (System.in);
		
		System.out.println("Welcome to OrderStatistics and Sorting Algorithm Calculator");
		
		// It starts with an option to the user to generate the input or not
		// If 'Y', it goes into the generate input loop
		// Any other key skips this process
		System.out.println("Would you like to generate inputs? ('Y' for Yes)");
		if(getInput.nextLine().equalsIgnoreCase("Y")) {
			GenerateCSVInput csvInput = new GenerateCSVInput();
			csvInput.generateInput();
		} else {
			System.out.println("Generate input skipped..");
		}
		
		// this will ask for the path of the generated csv file
		while(true) {
			System.out.print("Enter your csv input file path & file name:");
			System.out.println("(Ex:C:\\xx\\filex.csv)");
			csvFilePath = getInput.nextLine();
			try {
				br = new BufferedReader(new FileReader(csvFilePath));
				break;
			}catch(FileNotFoundException e) {
				System.out.println("Invalid Path. Try again..!!");
			}
		}
		
		// Read the csv file
		readDatatoArray();
		br.close();
		System.out.println("Size : " + dataSet.length);
		
		// Start the Task
		TaskHandler handler = new TaskHandler(dataSet, k);
		handler.performTask();
	}

	// This process is to generate the basic array by reading the input file
	public static void readDatatoArray() throws IOException {
		int maxSize = 0;
		String[] lineData = br.readLine().split(","); // Row No 1 for general details
		maxSize = Integer.parseInt(lineData[1]); // k,n is the value
		k = Integer.parseInt(lineData[0]);
		dataSet = new double[maxSize];
		for(int i =0; i<maxSize; i++) {
			dataSet[i] = (Double.parseDouble(br.readLine()));
		}
		System.out.println("Input file loaded to Array successfully..");
	}
}