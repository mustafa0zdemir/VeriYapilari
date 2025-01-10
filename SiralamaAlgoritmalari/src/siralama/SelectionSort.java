package siralama;

import java.util.Arrays;

public class SelectionSort {
	
	
	
	public static void selectionSort(int[] dizi) {
		int min = 0;
		for(int i = 0;i<dizi.length;i++) {
			min = i;
			for(int j = i+1; j<dizi.length;j++){
				if(dizi[j]< dizi[min]) {
					min = j;
				}
			}
			int tmp = dizi[min];
			dizi[min] = dizi[i];
			dizi[i] = tmp;
			//System.out.println(Arrays.toString(dizi));
		}
	}
	
	public static void main(String[] args) {
		
		int[] dizi = {15,40,-3,7,-69,10,0,6,29};
		selectionSort(dizi);
		System.out.println(Arrays.toString(dizi));
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
