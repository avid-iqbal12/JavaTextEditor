package datastralgotuts;

public class RecurBinarySearch {

	public static int recurBSearch(int[] sortedA, int low, int high, int key) { 
		if (low < high){			
			int mid = (low+high)/2; 
			if (key < sortedA[mid]) { 
				return recurBSearch(sortedA, low, mid, key); 
			}else if (key > sortedA[mid]) {
				return recurBSearch(sortedA, mid+1, high, key); 
			} else { 
				return mid; 
			}
		} 
		return -(low+1);	
	} 
		
	public static void main(String[] args) { 
		int[] A = {2,45,234,567,876,900,976,999}; 
		int n = A.length;
		
		int index = recurBSearch(A,0,n,45); 
		System.out.println("Found 45 at "+index+" index"); 
		
		index = recurBSearch(A,0,n,999); 
		System.out.println("Found 999 at "+index+" index"); 
		
		index = recurBSearch(A,0,n,876); 
		System.out.println("Found 876 at "+index+" index"); 
		
		index = recurBSearch(A,0,n,886); 
		System.out.println("Found 886 at "+index+" index"); 
	} 	
}
