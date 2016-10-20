package datastralgotuts;

import java.util.Arrays;

/** 
 * CSE 5003 - Data Structures -- Lesson on Insert Sort
 * @author Faisal Iqbal
 */
public class InsertSort {
	
	public static void main (String args[]){
		int[] A = {10,7,8,9};  
		/* Ascending order*/
		for(int j=1;j<A.length;j++){
			int t = A[j];
			int i = j - 1;
			while((i>=0)&&(A[i]>t)){
				A[i+1] = A[i];
				i--; 
			}
		A[i+1]=t;
		}
		
		int[] B = {1,2,3,4}; 				
		/* Descending order */
		for(int j = 1; j < B.length; j++){
			int temp = B[j]; 
			int i = j - 1;
			while((i>=0)&&(B[i]<temp)){
				B[i+1] = B[i];	//push to the right when it meets condition
				i--;
			}
		B[i+1] = temp;
		}				
	System.out.println(Arrays.toString(A));
	System.out.println(Arrays.toString(B));
	}
}
