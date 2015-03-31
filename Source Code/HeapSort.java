import java.io.IOException;
import java.util.Scanner;

// Perform Heap Sort Operation

public class HeapSort {
	
	public double[] dataSet;
	Scanner heapInput = new Scanner(System.in);
	
	public HeapSort(double[] dataSet) {
		this.dataSet = dataSet;
	}
	
	// This method takes care of all the heap sort process
	public void doHeapSort() {
		HeapAlgorithm heap = new HeapAlgorithm(dataSet);
		heap.processFileData();
		dataSet = heap.getFinalDataSet();
		
		System.out.println("Would you like to export the result array to a csv file?"
				+ "('Y' for yes)");
		if(heapInput.nextLine().equalsIgnoreCase("Y")) {
		
			// Write the output to a csv file
			try {
				WriteOutputToCSV.generateOutput(dataSet, "Heap");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println("Heap Sort Algorithm Process complete");
	}
}