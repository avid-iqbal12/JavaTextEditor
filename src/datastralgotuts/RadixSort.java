package datastralgotuts;

import java.util.Arrays;

public class RadixSort {
	
	public static void main(String[] args){
		System.out.println("Radix Sort Test\n");
    
	    int[] A = {12, 16, 333, 50, 1000, 5, 897, 1, 3, 66, 13};

	    System.out.println("Array A: " + Arrays.toString(A));
	    
	    /** Call method sort **/
		sort(A);
		
		/** Print sorted Array **/
	    System.out.println("Elements after sorting: " + Arrays.toString(A)); 
	} 
	
	public static void sort(int[] A){
		int i, m=A[0], exp=1, n = A.length;
		int[] b = new int[n];
		
		for(i=1;i<n;i++){
			if(A[i]>m)
				m = A[i];			
		}
		
		while(m/exp>0){
			int bucket[] = new int[n];
			
			for(i=0;i<n;i++)				
				bucket[(A[i]/exp)%n]++;
			for (i = 1; i < n; i++)
				bucket[i] += bucket[i - 1];
			for (i = n - 1; i >= 0; i--)
				b[--bucket[(A[i] / exp) % n]] = A[i];
			for (i = 0; i < n; i++)
				A[i] = b[i];
			exp *= n;        
		}
	}
	   
}
