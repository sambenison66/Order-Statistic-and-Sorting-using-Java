import java.util.Scanner;

// This class handles all type of task which needs to be performed (Heart of all Methods)
public class TaskHandler {
	
	public double[] dataSet;
	public int k;
	
	public TaskHandler(double[] dataSet, int k) {
		this.dataSet = dataSet;
		this.k = k;
	}

	public void performTask() {
		
		int input;
		Scanner inputOptions = new Scanner(System.in);
		
		
		while(true) {
		
			System.out.println("List of Algorithms:");
			System.out.println("1. Median of Median");
			System.out.println("2. Linear Time");
			System.out.println("3. Quick Sort");
			System.out.println("4. Heap Sort");
			System.out.println("0. Exit");
			System.out.println("What do you want to do with the data set?");
			
			// Decides what operation needs to be performed and call the corresponding class accordingly
			try {
				input = Integer.parseInt(inputOptions.nextLine());
				switch (input) {
					case 1:
						MedianofMedian mm = new MedianofMedian(dataSet, k);
						mm.doMedianofMedian();
						break;
					case 2:
						RandomPivot rp = new RandomPivot(dataSet, k);
						rp.doRandomPivot();
						break;
					case 3:
						QuickSort qs = new QuickSort(dataSet);
						qs.doQuickSort();
						break;
					case 4:
						HeapSort hs = new HeapSort(dataSet);
						hs.doHeapSort();
						break;
					case 0:
						System.out.println("Existing the System..");
						break;
					default:
						System.out.println("Invalid Input.. Try again..!!");
						break;
					
				}
				if(input == 0) {
					break; // again out of while loop
				}
			} catch (Exception e) {
				System.out.println("Invalid Entry");
			}
		}
	}
	
}
