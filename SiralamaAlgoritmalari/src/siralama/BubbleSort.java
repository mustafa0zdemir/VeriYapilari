package siralama;

import java.util.Arrays;

public class BubbleSort {
	
	public static void bubbleSort(int[]a) {
		boolean exchanged = true;
		while(exchanged) {
			exchanged = false;
			for(int i = 0; i < a.length-1;i++) {
				if(a[i]>a[i+1]) {
					exchanged = true;
					int tmp = a[i];
					a[i] = a[i+1];
					a[i+1] = tmp;
				}
			}
		}
	}
	
	
	public static void main(String[] args) {
		int[] a = {44, 32, 5, 21, 55, 31, 8, 6, 9, 0};

        // Çalışma zamanını ölçme başlangıcı
        long startTime = System.nanoTime();
        
        bubbleSort(a);

        // Çalışma zamanını ölçme bitişi
        long endTime = System.nanoTime();

        // Toplam geçen süre
        long elapsedTime = endTime - startTime;

        System.out.println("Sıralanmış dizi: " + Arrays.toString(a));
        System.out.println("Çalışma zamanı (nanoseconds): " + elapsedTime);
        System.out.println("Çalışma zamanı (milliseconds): " + elapsedTime / 1_000_000);
		
		
	}
}
