package datastralgotuts;

import java.util.Arrays;

/** 
 * CSE 5003 - Data Structures -- Lesson on Bubble Sort
 * @author Faisal Iqbal
 */
public class BubbleSort {
	
	public static void main(String[] args){
		
		int[] A = {10,5,9,8, 11, 15, 19, 10, 12};		 
		int n = A.length;
		//Ascending order
		for(int i = 0; i <= n-2 ; i++ )
			for(int j = 0; j <= n-i-2;j++)
				if(A[j]>A[j+1]){
					int temp;
					temp = A[j];
					A[j] = A[j+1];
					A[j+1] = temp;
				}
		
		//Descending order
		int[] B = {10,5,9,8, 11, 15, 19, 10, 12};
		int num = B.length;
		for(int i = 0; i<=num-2; i++){
			for(int j = 0; j<=num-i-2; j++)
				if(B[j]<B[j+1]){
					int temp = B[j];
					B[j] = B[j+1];
					B[j+1] = temp;
				}
		}
		
		
		System.out.println(Arrays.toString(A)); 
		System.out.println(Arrays.toString(B));		
	}
	
	
	
}
