package datastralgotuts;

import java.util.Arrays;

public class LinearSearch {

	static int i, search;
	static int[] A = {40, 31, 122, 323, 4, 1};
	static int n=A.length;
	
	public static void main(String[] args){

		System.out.println("A: " + Arrays.toString(A));
		lSearch(A, 40);
	}
	
	
	static void lSearch(int[] A, int search){
		for(i=0;i<n;i++){
			if(A[i] == search){
				System.out.println(search + " is at location " + (i+1));
				break;
			}
		}
		if(i == n)
			System.out.println(search + " doesn't exist");
	}
}
