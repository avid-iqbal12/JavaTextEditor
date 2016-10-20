package datastralgotuts;

import java.util.Arrays;

/** 
 * CSE 5003 - Data Structures -- Lesson on Select Sort
 * @author Faisal Iqbal
 */

public class SelectSort {
	public static void main(String args[]){
		int[] A = {11,10,9,8,20,22,28,12,6,7,11};	
		int n = A.length;			
	System.out.println("Before select sort: \n" + Arrays.toString(A));
	//System.out.println("Total number of elements: " + n);
		
		int i,j,min,temp;
		//Ascending order
		for(i=0; i<n-1 ;i++){
			min = i;
			//System.out.println("min is: " + min);
			for(j=i+1; j < n; j++){
				if(A[j]<A[min]){
				min = j;
				}
				//System.out.println("min is: " + min);
			}		
			if(min != i){
				//System.out.println("Items swapped:\n" + "[" + A[i] + ", " + A[min] + "]");
				
				temp = A[min];
				A[min] = A[i];
				A[i] = temp;
			}
		}
		
		/*//Descending order
		for(i=0; i<=n-1 ;i++){
			min = i;
			for(j=i+1; j < n; j++){
				if(A[j]>A[min]){
				min = j;
				}
			}		
			if(min != i){
				temp = A[min];
				A[min] = A[i];
				A[i] = temp;
			}
		}*/
		
		
		
	System.out.println("After sorting: \n" + Arrays.toString(A));

	}
}