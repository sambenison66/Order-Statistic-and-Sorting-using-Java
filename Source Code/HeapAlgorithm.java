import java.io.BufferedReader;


public class HeapAlgorithm {
	
	public BufferedReader file = null;
	public double[] dataSet;
	public int maxSize = 0, availableIndex = 0;
	
	// Constructor assigns the array from the HeapSort call
	public HeapAlgorithm(double[] dataSet) {
		this.dataSet = dataSet;
		maxSize = dataSet.length;
		availableIndex = maxSize;
	}
	
	// This is the primary method to process all the activities based on input data
	public void processFileData() {
		long startTime = 0;
		try {
			startTime = System.currentTimeMillis();
			System.out.println("Performing Heap Sort...");
			buildHeap();
			heapSorting();
			System.out.println("Heap Sort Done successfully...!!!!");
			
		} catch (Exception e) {
			// Report the error if exception occurred during file reading
			e.printStackTrace();
		} finally {
			long endTime = System.currentTimeMillis();
			if(startTime != 0) {
				System.out.println("\n\nTime Taken to perform HeapSort on " + maxSize +
					" data is :" + (endTime - startTime) + "\n\n");
			}
		}
		
	}
	
	// Build a Heap based on the given array
	public void buildHeap() {
		for (int j = dataSet.length / 2 - 1; j >= 0; j--) {
			doHeapify(j);
		}
	}
	
	// Do Heapify process in the given index of an array
	public void doHeapify(int index) {
		int lagestChild;
		double rootNode = dataSet[index];
		
		while(index < availableIndex/2) {
			int leftChild = 2 * index + 1;
			int rightChild = leftChild + 1;
			
			if(rightChild < availableIndex && dataSet[leftChild] < dataSet[rightChild]) {
				lagestChild = rightChild;
			} else {
				lagestChild = leftChild;
			}
			
			if(rootNode >= dataSet[lagestChild]) {
				break;
			}
			
			dataSet[index] = dataSet[lagestChild];
			index = lagestChild;
		}
		dataSet[index] = rootNode;
	}
	
	// Sort the array from the given heap structure
	public void heapSorting() {
		double highestNode;
		for(int i = maxSize-1; i>=0; i--) {
			highestNode = pop();
			dataSet[i] = highestNode;			
		}
		
	}
	
	// Pop the root node from the array
	public double pop() {
		double root = dataSet[0];
		
		double lastLeaf = dataSet[availableIndex-1];
		dataSet[0] = lastLeaf;
		availableIndex--;
		
		doHeapify(0);
		
		return root;
	}
	
	// Return the latest updated data set
	public double[] getFinalDataSet() {
		return dataSet;
	}

}