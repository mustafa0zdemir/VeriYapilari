package siralama;

import java.util.Arrays;

public class InsertionSort {
	
	
	
	public static void  insertionSort(int[] A) { 
		for(int j = 1; j< A.length;j++) {
			int t = A[j];
			int i = j-1;
			while(i>=0&&A[i]>t) {
				A[i+1] = A[i];
				i--;
			}
			A[i+1] = t;
		}
	}
	
	
	
	
	public void insertionSortInstance(int[] B) {
		for(int j = 1;j<B.length;j++) {
			int t = B[j];
			int i = j -1;
			while(i>=0&&B[i]>t) {
				B[i+1] = B[i];
				i--;
			}
			B[i+1] = t;
		}
	}

	public static void main(String[] args) {
		int[] a = {1,4,2,7,5,9,3};
		
		InsertionSort sorter = new InsertionSort();
		
		sorter.insertionSortInstance(a);
		System.out.println(Arrays.toString(a));
		insertionSort(a);
		System.out.println(Arrays.toString(a));

	}

}
