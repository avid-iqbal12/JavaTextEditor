package datastralgotuts;

import java.util.Arrays;

/** 
 * CSE 5003 - Data Structures -- Lesson on Quick Sort
 * @author Faisal Iqbal
 */

public class QuickSort{
	
	public static void quickSort(int A[], int f, int l){
		int i = f, j = l;
		int temp;
		int pivot = A[f];
				
		while(i<=j){
			while(A[i] < pivot & i <= l)				
				i++;
			while(A[j] > pivot && j > f)
				j--;
			if(i<=j){
				temp = A[i];
				A[i] = A[j];
				A[j] = temp;
				i++;
				j--;
			//System.out.println("i: " + i);
			//System.out.println("j: " + j);
			}
		
		int partition = i; 		
					
		if(f < partition-1)
			quickSort(A,f,partition-1);
		if(partition < l)
			quickSort(A,partition,l);
		}
	}
	
	public static void main(String[] args){
		int A[]= {27, 8, 18, 39, 19, 50, 22, 33, 40, 31, 122, 323, 4, 1};
		System.out.println("Unsorted: " + Arrays.toString(A));
		int n = A.length;
		quickSort(A,0,n-1);
		System.out.println("Sorted: " + Arrays.toString(A));
	}
	
}


