import java.io.BufferedReader;
import java.util.Random;
import java.util.Scanner;

// This method implements the Quick Sort Algorithm for the given input array
public class QuickAlgorithm {
	public BufferedReader file = null;
	public int stackCtr=0, chunkValue;
	public int maxSize = 0, availableIndex = 0;
	public Scanner sc;
	public double[] dataSet;
	public String choice;
	
	// Constructor Declaration
	public QuickAlgorithm(double[] dataSet, String choice, int chunkValue) {
		this.dataSet = dataSet;
		this.choice = choice;
		this.chunkValue = chunkValue;
	}
	
	// Primary Method which performs Quick Sort Algorithm
	public void processFileData(){
		long startTime = 0;
		startTime = System.currentTimeMillis();
		quickSort(dataSet, choice, chunkValue);
		long endTime = System.currentTimeMillis();
		int maximumSize = maxSize+1;
		if(startTime != 0) {
			System.out.println("Time Taken to perform Quick Sort on " + maximumSize +
					" data is :" + (endTime - startTime));
			System.out.println("Total number of recursive calls pushed in the stack are: "+ stackCtr);
			stackCtr = 0;
			maximumSize=0;
		}
	}
	
	// Check the given input and call Recursive quick sort method
	public void quickSort(double[] doubleArray, String choice, int chunkValue) {
		maxSize = doubleArray.length-1;
		if (doubleArray.length <= 1)
			return;
		else {
			if (doubleArray.length>1){
			stackCtr++;
			recQuickSort(doubleArray, 0, maxSize, choice, chunkValue);
			}
		}
	}
	
	// Perform Recursive Quick Sort
	public void recQuickSort(double[] doubleArray, int start, int end, String choice, int chunkValue){
		int len = end - start + 1;
		if (len < chunkValue)
			insertionSort(doubleArray, start, end);
		else{
			double pivot = chooseOption(doubleArray, start, end, choice);
			int partition = partition(doubleArray, start, end, pivot);
			if (start < partition-1){
			stackCtr++;
			recQuickSort(doubleArray, start, partition - 1, choice, chunkValue);
			}
			if (partition < end){
			stackCtr++;
			recQuickSort(doubleArray, partition, end, choice, chunkValue);
			}
		}
	}
	
	// Decides what type of Quick Sort to be performed and call according methods
	public double chooseOption(double[] doubleArray, int start, int end, String choice){
		double pivot = 0;
		if (choice.equals("1"))
		pivot = doubleArray[start];
		else if (choice.equals("2")){
		int len = end - start + 1;
		Random rand = new Random();
		int randElement1 = rand.nextInt(len);
		int chosenElem = randElement1+start;
		pivot = doubleArray[chosenElem];
		}
		else if (choice.equals("3")){
		//double chosenElem 
		pivot = medianof3Randoms(doubleArray, start, end);
		}
		//System.out.println("pivot element is: "+ pivot);
		return pivot;
	}
	
	// Perform the Median of 3 Random (as Pivot) process
	public static double medianof3Randoms(double[] doubleArray, int start, int end){
		int len = end - start + 1;
		double chosenOne = 0;
		Random rand = new Random();
		int randElement1 = rand.nextInt(len);
		int randElement2 = rand.nextInt(len);
		int randElement3 = rand.nextInt(len);
		int chosenElem1 = randElement1+start;
		int chosenElem2 = randElement2+start;
		int chosenElem3 = randElement3+start;
		if ((doubleArray[chosenElem1] <= doubleArray[chosenElem2] && doubleArray[chosenElem1] >= doubleArray[chosenElem3]) || (doubleArray[chosenElem1] >= doubleArray[chosenElem2] && doubleArray[chosenElem1] <= doubleArray[chosenElem3])){
		chosenOne = doubleArray[chosenElem1];
		}
		else if ((doubleArray[chosenElem2] <= doubleArray[chosenElem1] && doubleArray[chosenElem2] >= doubleArray[chosenElem3]) || (doubleArray[chosenElem2] >= doubleArray[chosenElem1] && doubleArray[chosenElem2] <= doubleArray[chosenElem3])){
		chosenOne = doubleArray[chosenElem2];
		}
		else if ((doubleArray[chosenElem3] <= doubleArray[chosenElem1] && doubleArray[chosenElem3] >= doubleArray[chosenElem2]) || (doubleArray[chosenElem3] >= doubleArray[chosenElem1] && doubleArray[chosenElem3] <= doubleArray[chosenElem2])){
		chosenOne = doubleArray[chosenElem3];
		}
		return chosenOne;
	}
	
	// Partition the given array based on the given pivot
	public int partition(double[] doubleArray, int start, int end, double pivot){
		while (start <= end){
			while (doubleArray[start] < pivot)
				start++;
			while (doubleArray[end] > pivot)
				end--;
			if (start <= end) {
				double tmp = doubleArray[start];
				doubleArray[start] = doubleArray[end];
				doubleArray[end] = tmp;
				start++;
				end--;
			}
		}
		return start;
	}
	
	// Perform Insertion Sort
	public void insertionSort(double[] doubleArray, int left, int right) {
		int in, out;
		for (out = left + 1; out <= right; out++) {
			double temp = doubleArray[out];
			in = out;
			while (in > left && doubleArray[in - 1] >= temp) {
				doubleArray[in] = doubleArray[in - 1];
				--in;
			}
			doubleArray[in] = temp;
		}
	}
	// Return the latest updated data set
	public double[] getFinalDataSet() {
		return dataSet;
	}
}