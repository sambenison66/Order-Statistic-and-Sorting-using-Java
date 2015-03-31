import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/*
 * This method takes the type of Median (3, 5,7) which needs to be performed and perform the MoM
 * It call for both kth Smallest and Top K Smallest process
 */

public class MedianofMedian {
	
	public double[] dataSet, finalSet;
	public int k;
	Scanner medianInput = new Scanner(System.in);
	int medianType;
	String input;
	
	// Constructor Declaration
	public MedianofMedian(double[] dataSet, int k) {
		this.dataSet = dataSet;
		this.k = k;
	}
	
	// This method takes care of all the MoM process
	public void doMedianofMedian() {
		
		while(true) {
			System.out.println("Enter the number of size for partition from 3,5 or 7");
			try {
			  medianType = Integer.parseInt(medianInput.nextLine());
				if(medianType==3 || medianType==5 || medianType==7) {
					MedianAlgorithm median = new MedianAlgorithm(dataSet, k, medianType);
					median.processFileData();
					finalSet = median.getFinalDataSet();
					break;
				} else {
					System.out.println("Invalid value.. Try again..!!!");
				}
			} catch(Exception e) {
				System.out.println("Invalid Input... Enter an Integer");
			}
		}

		medianInput = new Scanner(System.in);

		
		
		System.out.println("Would you like to export the result array to a csv file?"
				+ "('Y' for yes)");
		if(medianInput.nextLine().equalsIgnoreCase("Y")) {
		
			// Write the output to a csv file
			try {
				WriteOutputToCSV.generateOutput(finalSet, "Median");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println("Median of Median Algorithm Process complete");
		
	}

}
