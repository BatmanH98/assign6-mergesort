package mergesort;

public class MergeSort {

	public static void main(String[] args) {
		int[] array1 = {11,43,87,27,54,8,32,71,44,12};
		
		showArray(array1);
		mergeSort(array1);
		showArray(array1);
		
	}
	
	public static void showArray(int[] theArray) {
		int index;
		
		System.out.printf("[");
		for(index=0;index<theArray.length;index++) {
			if(index!=0) {
				System.out.printf(", ");
			}
			System.out.printf("%d",theArray[index]);
		}
		System.out.printf("]\n");
	}
	

	
	private static void mergeSort(int[] theArray, int left, int right) {
		//**************************************************************
		//*  Recursive Merge Sort                                      *
		//*------------------------------------------------------------*
		//*  1. Divide or partition the array section into 2 halves.   *
		//*  2. Create a subArray for each partition (half)            *
		//*  3. Merge the two subArrays to create one sorted array     *
		//*  4. Replace the original array section with the merged     *
		//*     array.                                                 *
		//**************************************************************
		
		if (left >= right) {
			return; 
		}
		
		int middle = left + (right - left) / 2;
		
		mergeSort(theArray, left, middle);
		mergeSort(theArray, middle + 1, right);
		
		int[] leftHalf = new int[middle - left + 1];
		int[] rightHalf = new int[right - middle];
		
		for (int i = 0; i < middle - left + 1; i++) {
			leftHalf[i] = theArray[left + i];
		}
		
		for (int i = 0; i < right - middle; i++) {
			rightHalf[i] = theArray[middle + i + 1];
		}
		
		int[] mergedArray = new int[(middle - left + 1) + (right - middle)];
		
		int leftIndex = 0;
		int rightIndex = 0;
		int mergedIndex = 0;
		
		while ((leftIndex < middle - left + 1) && (rightIndex < right - middle)) {
			
			if (leftHalf[leftIndex] <= rightHalf[rightIndex]) {
				
				mergedArray[mergedIndex] = leftHalf[leftIndex];
				leftIndex++;
				
			} else {
				
				mergedArray[mergedIndex] = rightHalf[rightIndex];
				rightIndex++;
			}
			
			mergedIndex++;
		}
		
		
		while (leftIndex < middle - left + 1) {
			mergedArray[mergedIndex] = leftHalf[leftIndex];
			leftIndex++;
			mergedIndex++;
		}
		
		while (rightIndex < right - middle) {
			mergedArray[mergedIndex] = rightHalf[rightIndex];
			rightIndex++;
			mergedIndex++;
		}
		
		for (int i = 0; i < mergedArray.length; i++) {
			theArray[left + i] = mergedArray[i];
		}
	}
	
	public static void mergeSort(int[] array) {
		//**********************************************
		//*  Class Wrapper for the recursive mergeSort *
		//**********************************************
		mergeSort(array,0,array.length-1);
	}
}
