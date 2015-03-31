import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// This class is to perform the MOM Algorithm for the input array
public class MedianAlgorithm {
	
	double[] a;
	double[] b;
	int n, medianType;
	int threshold;
	double[] kele;
	
	public MedianAlgorithm(double[] dataSet, int k, int medianType) {
		this.a = dataSet;
		this.b = dataSet;
		this.n = k;
		this.medianType = medianType;
		kele = new double[n];
	}
	
	// Primary method which performs all the operation
	public void processFileData() {
		 
		int middle_ele=0, par_size=0;
		long startkth, endkth, startk, endk;
		int difference, maxConstant;
		
		// This calculation is to perform a threshold
		// after which it will stop recursive operation
		// and perform Array.sort method
		maxConstant = n;
		difference = (a.length) / n;
		if(difference < 2) {
			maxConstant = (2* n) / 3 ;
		}
		difference += maxConstant;
		if(difference>1000) {
			difference = ((3* difference) / 4) + 100;
		}
		
        
        //selecting partition size based on user input and selecting median of partitioned array
        if (medianType==3){
        	
        	par_size=3;
        	middle_ele=1;
        	threshold = ((n*215)/300) + difference;
        	
        }
        else if (medianType==5){
        	
        	par_size=5;
        	middle_ele=2;
        	threshold = ((n*157)/300) + difference;
        	
        }
        else if (medianType==7){
        	par_size=7;
        	middle_ele=3;	
        	threshold = ((n*80)/300) + difference;
        }
		
      //top kth element
		startkth = System.currentTimeMillis();
		double res = select(a, n , par_size, middle_ele, threshold);		
		System.out.println(n+"th smallest element :"+res);
		endkth = System.currentTimeMillis();
		System.out.println("Time for "+n+"th (kth) smallest element by Median of median method :" +(endkth-startkth));
		
		//top k elements
		startk = System.currentTimeMillis();
		for(int i=1;i<=n;i++){
			//System.out.println("Array Length : " + b.length);
			double k_ele = select(b, i , par_size, middle_ele, threshold);
			kele[i-1]=k_ele;
			//System.out.println(kele[i]);
		}
		
		endk = System.currentTimeMillis();
		System.out.println("Time for top "+n+" (k) smallest element by Median of median method :" +(endk-startk));
	}
 
 
	// find the kth smallest element with an following parameters as input
	// double[] a: the input array
	// int k: kth element
	// int par_size: partition size selected by user from 3, 5 or 7
	// int middle_ele: the position of median in the partitioned array
		
		private static double select(double[] a, int k , int par_size, int middle_ele, int threshold)
		{
			if (a.length <= threshold)
			{
				Arrays.sort(a);
				return a[k-1];
			}
			int n = a.length;
			//partition L into subsets S[i] of 3,5 or 7 elements each
			//    (there will be n/3,n/5 or n/7 subsets total).
			List<double[]> list = new ArrayList<double[]>();
	 
			int cnt = 0;
			int m = n/par_size;
			for( int i = 0; i < m; i++ ) {
				double[] arr = new double[par_size];
				for( int j = 0; j < par_size; j++ ) {
					if( cnt == n ) 
						break;
					arr[j] = a[cnt++];
				}
				Arrays.sort(arr);
				list.add(arr);
			}
	 
			double[] x = new double[m];
			for (int i = 0; i< m; i++ ) {
				x[i] = list.get(i)[middle_ele];
			}
	 
			double v = x[0];
			if(x.length > 2) {
				v = (x.length%2 == 0)? x[x.length/2-1]: x[x.length/2];
			}
	 
			//    partition L into L1<M, L2=M, L3>M
			double[] l = partition_l( a, v );
			double[] r = partition_r( a, v );
			
			if( k == l.length+1 ) {
				return v;
			} else if( k <= l.length ){
				return select(l,k,par_size,middle_ele, threshold);								
			} else {
				return select(r,k-l.length-1,par_size,middle_ele, threshold);							
			}		
	 
		}
		
		// Perform the left partition
		private static double[] partition_l( double[] a, double pivot ) {
			if( a.length == 0)
				return a;
			int j = 0;
			double[] b = new double[a.length];
			for( int i = 0; i < a.length; i++ ) {
				if(a[i] < pivot) {
					b[j++] = a[i];
				}
			}
			double[] l = new double[j];
			System.arraycopy(b, 0, l, 0, j);
			return l;
		}
		
		// Perform the right partition
		private static double[] partition_r( double[] a, double pivot ) {
			if( a.length == 0)
				return a;
			int j = 0;
			double[] b = new double[a.length];
			for( int i = 0; i < a.length; i++ ) {
				if(a[i] > pivot) {
					b[j++] = a[i];
				}
			}
			double[] r = new double[j];
			System.arraycopy(b, 0, r, 0, j);
			return r;
		}
	
		// Return the latest updated data set
		public double[] getFinalDataSet() {
				return kele;
		}

}
