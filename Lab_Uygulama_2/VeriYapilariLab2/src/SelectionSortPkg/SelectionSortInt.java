package SelectionSortPkg;
import ArrayProcessPkg.ArrayProcess;

public class SelectionSortInt {

	 static void selectionSort(int[] dizi) {
	        int n = dizi.length;

	        for (int i = 0; i < n - 1; i++) {
	            int minIndex = i;
	            for (int j = i + 1; j < n; j++) {
	                if (dizi[j] < dizi[minIndex]) {
	                    minIndex = j;
	                }
	            }
	            //swap
	            int temp = dizi[minIndex];
	            dizi[minIndex] = dizi[i];
	            dizi[i] = temp;
	        }
	    }
	 
	public static void main(String[] args){
		int[] dizi = {64, 25, 12, 22, 11,33,44};
	        selectionSort(dizi);
	        ArrayProcess.diziYaz(dizi);//ArrayProcess sınıfı üzerinden diziYaz metodu çağırıldı

	}
}

	
