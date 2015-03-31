import java.io.IOException;
import java.util.Scanner;

// This class get the required input for Quick Sort process and call Quick Sort Algorithm
public class QuickSort {
	
	public double[] dataSet;
	Scanner quickInput = new Scanner(System.in);
	String choice;
	int chunkValue;
	
	public QuickSort(double[] dataSet) {
		this.dataSet = dataSet;
	}
	
	// This method takes care of all the quick sort process
	public void doQuickSort() {
		
		while(true) {
			System.out.println("Enter 1, to choose the pivot as 1st element");
			System.out.println("Enter 2, to Choose the pivot as random number");
			System.out.println("Enter 3, to choose the pivot as median of 3 random numbers");
			//System.out.println("Enter any random number to choose the pivot from median of median method");
			choice = quickInput.nextLine();
				if(choice.equals("1") || choice.equals("2") || choice.equals("3")) {
					System.out.println("Please enter the value of L to run insertion Sort: (0 if not applicable) ");
					chunkValue = quickInput.nextInt();
					QuickAlgorithm quick = new QuickAlgorithm(dataSet, choice, chunkValue);
					quick.processFileData();
					dataSet = quick.getFinalDataSet();
					break;
				} else {
					System.out.println("Invalid value.. Try again..!!!");
				}
		}
		
		quickInput = new Scanner(System.in);
		
		
		System.out.println("Would you like to export the result array to a csv file?"
				+ "('Y' for yes)");
		if(quickInput.nextLine().equalsIgnoreCase("Y")) {
		
			// Write the output to a csv file
			try {
				WriteOutputToCSV.generateOutput(dataSet, "Quick");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println("Quick Sort Algorithm Process complete");
		
	}

}
