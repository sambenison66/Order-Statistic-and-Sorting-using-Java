
/* This class takes care of all the Linear Time Random Pivot calculation process
 * To find kth Smallest element in an array
 */
public class LinearTimeK {
	
    public double[] dataSet;
	public int k, N;
	
	// Constructor Initialization
	public LinearTimeK(double[] dataSet, int k) {
		this.dataSet = dataSet;
		this.k = k;
		N= dataSet.length;
	}
	
	// Primary method called from its parent class
	public void linearTimeCalculate() 
	{
		long startTime = System.currentTimeMillis();
	    
	    quick_sort(0, N, k);
	    
	    long endTime = System.currentTimeMillis();
		System.out.println("Time for "+k+" (k) smallest element by Random Pivot method :" +(endTime-startTime));

	}
    
	// Swap the values in array
    private void swap(int dex1, int dex2) 
    {
        double temp = dataSet[dex1];
        dataSet[dex1] = dataSet[dex2];
        dataSet[dex2] = temp;
    }
    
    // Partition the input and perform the calculation
    private int partition(int start, int end) 
    {
        int i = start + 1;
        int j = i;
        int pivot = start;
        for (; i < end; i++) 
        {
            if (dataSet[i] < dataSet[pivot]) 
            {
                swap(i, j);
                j++;
            }
        }
        if (j <= end)
            swap(pivot, (j - 1));
 
        return j - 1;
    }
    
    // This method does a process similar to quick sort to take a random pivot and perform recursive calculation
    private void quick_sort(int start, int end, int K) {
        int part;
        if (start < end) 
        {
            part = partition(start, end);
            if (part == K - 1)
                System.out.println(k + "th smallest element in the set is : " + dataSet[part]);
            if (part > K - 1)
                quick_sort(start, part, K);
            else
                quick_sort(part + 1, end, K);
        }
        return;
    }

}