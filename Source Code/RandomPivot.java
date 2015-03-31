import java.io.IOException;
import java.util.Scanner;

/*
 * This method selects a Random pivot and perform the Linear Time operation
 * It call for both kth Smallest and Top K Smallest process
 */

public class RandomPivot {
	
	public double[] dataSet, finalSet;
	public int k;
	Scanner randomInput = new Scanner(System.in);
	
	public RandomPivot(double[] dataSet, int k) {
		this.dataSet = dataSet;
		this.k = k;
	}
	
	// This method takes care of all the random pivot process
	public void doRandomPivot() {
		
		LinearTimeK randomK = new LinearTimeK(dataSet, k);
		randomK.linearTimeCalculate();
		
		TopKRandom random = new TopKRandom(dataSet, k);
		random.processFileData();
		finalSet = random.getFinalDataSet();
		
		
		System.out.println("Would you like to export the result array to a csv file?"
				+ "('Y' for yes)");
		if(randomInput.nextLine().equalsIgnoreCase("Y")) {
		
			// Write the output to a csv file
			try {
				WriteOutputToCSV.generateOutput(finalSet, "RandomP");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println("Linear Time Algorithm Process complete");
		
	}

}
