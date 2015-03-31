/* This class takes care of all the Linear Time Random Pivot calculation process
 * To find Top k Smallest element in an array
 */
public class TopKRandom {
	
	public double[] dataSet, kelement;
	public int k;
	
	// Constructor Declarations
	public TopKRandom(double[] dataSet, int k) {
		this.dataSet = dataSet;
		this.k = k;
		kelement = new double[k];
	}
	
	// Primary Method which does all the process
	public void processFileData() {
		long startTime = System.currentTimeMillis();
		if (dataSet.length == 0) {
			System.out.println("Sorry!!! array is empty.");
			System.exit(0);
		} else if (dataSet.length == 1) {
			System.out.println("Congrats!! array saved my time.. its already sorted.");
		} else {
			pivot_select(dataSet, 0, dataSet.length-1, dataSet.length-k);
		}
		//System.out.println("Top K elements: ");
		int count = 0;
		for (int i = 0; i <= k-1; i++) {
			//System.out.println(dataSet[i]);
			kelement[count] = dataSet[i];
			count++;
		}
		long endTime = System.currentTimeMillis();
		System.out.println("Time for top "+k+" (k) smallest element by Random Pivot method :" +(endTime-startTime));
	}
	
	// This method sort the input array by using partition technique
	private static int partition_input(double[] input, int p, int q) {
		double x = input[p];
		int i = p;
		for (int j = (p + 1); j <= q; j++) {
			if (input[j] <= x) {
			i = i + 1;
				if(i < j){
				double temp = input[j];
				input[j] = input[i];
				input[i] = temp;
				}
			}
		}
		double temp1 = input[p];
		input[p] = input[i];
		input[i] = temp1;
		return i;
	}
	
	// This method will perform a recursive call by selecting a random pivot
	private void pivot_select(double[] list, int left, int right, int k){
		int pivotIndex = partition_input(list, left, right);
		if(pivotIndex == k){
		return;
		}
		else if(k < pivotIndex){
			pivot_select(list, left, pivotIndex -1, k);
		}else{
			pivot_select(list, pivotIndex +1 , right, k);
		}
	}
	
	// Return the latest updated data set
	public double[] getFinalDataSet() {
			return kelement;
	}

}