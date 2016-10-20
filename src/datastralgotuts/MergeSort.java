package datastralgotuts;

/** Lesson on merge sort
 * Divide and Conquer
 * @author Faisal Iqbal
* */

public class MergeSort {
	    
	//Main f(x) that sort A[l..h] using merge()
    void mergeSort(int A[], int low, int high) {        
    	if (low < high) {
    		//Find the middle
    		int mid = (low + high) / 2;
            // Sort first and second halves
            mergeSort(A,low, mid);
            mergeSort(A,mid + 1, high);
            // Now merge both sides
            merge(A, low, mid, high);
        }
    }
    //Merges two sub-arrays of A[]
    //First is A[l..mid], second is A[mid+1,h] 
	void merge(int A[], int low, int mid, int high) { 
		//find sizes of two sub-arrays to be merged
		int n1 = mid-low+1;
		int n2 = high-mid; //high-(mid+1)+1
		
		//Create temp arrays 
		int lowHalf[] = new int[n1];
		int highHalf[] = new int[n2];
		
		//Copy data to temp arrays
		for (int i = 0; i < n1; i++)
			lowHalf[i] = A[low+i];	
		for (int j = 0; j < n2; j++)
			highHalf[j] = A[mid+1+j];
  
		//Merge the temp arrays
		//Initial indices of first and second sub-array
		int i = 0, j = 0;
		
		//initial index of merged array
		int k=low;
		while(i<n1 && j <n2){
			if(lowHalf[i] <= highHalf[j]){
				A[k] = lowHalf[i];
				i++;
			} else{
				A[k] = highHalf[j];
				j++;
			}
			k++;
		}
		//Copy remaining elements of lowHalf[i]
		while(i < n1){
			A[k] = lowHalf[i];
			i++;
			k++;
		}
		//Copy remaining elements of highHalf[j]
		while(j < n2){
			A[k] = highHalf[j];
			j++;
			k++;
		}
	}
	
	static void printArray(int A[]) {
    	int n = A.length;
    	for(int i=0;i<n;i++)
    		System.out.print(A[i] + " ");
    	System.out.print(" "); 	
    }
	
	public static void main(String[] args){
        
    	int A[] = {45,23,11,89,77,98,4,28,65,43};
  
    	System.out.println("Given Array: ");
    	printArray(A);
    	
    	MergeSort obj = new MergeSort();
    	obj.mergeSort(A, 0, A.length-1);
    	
    	System.out.println("\nSorted Array: ");
    	printArray(A);
    	
    }
}

