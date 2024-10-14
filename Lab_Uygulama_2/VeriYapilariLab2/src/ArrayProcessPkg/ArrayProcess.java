package ArrayProcessPkg;

public class ArrayProcess {

	
	
	// kendine parametre olarak verilen dizinin tüm elemanlarını ekrana yazdırır
	public static void diziYaz(int[]dizi) {
		for(int i = 0;i<dizi.length;i++) {
			System.out.println(dizi[i]);
		}

	}
	
	//eleman ekleyen metot (var olan dizi boyutunun bir fazlası kadar yeni dizi oluşturup eleman eklenen metot)
	static int[] elemanEkle(int[]array,int yeni) {
		int[] yeniArray= new int[array.length+1]; 
		
		for(int i = 0;i<array.length;i++) {
			yeniArray[i] = array[i]; 
		}
		yeniArray[array.length]=yeni;
		return yeniArray;
	
}
	
	//eleman silen metot(var olan dizi boyutunun bir eksiği kadar dizi oluşturup ilk elemanını silen metot)
	static int[] elemanSil(int[]dizi) {
		int[] yeniArray = new int[dizi.length-1];
		
		for(int i = 0;i<yeniArray.length;i++) {
			yeniArray[i] = dizi[i+1];
		}
		return yeniArray;
		
	}
	
	//aranan eleman sayısını döndüren metot
	static int diziElemanSay(int[]dizi,int aranan) {
		 int say = 0;	
		for(int i = 0; i<dizi.length;i++) {
			if(dizi[i]==aranan) {
				say++;
			}
		}
		return say;
	}
	
	//aranan elemanın indeksini/indekslerini döndüren metot
	static int[] diziArananElemanIndeks(int[] dizi,int aranan) {
		int[] indexDizi = new int[dizi.length];
		int indexDiziSayacı = 0;
		for(int i = 0 ; i<dizi.length;i++) {
			if(dizi[i]==aranan) {
			indexDizi[indexDiziSayacı] = i;
			indexDiziSayacı++;
							
			}
		}
		return indexDizi;
	}
	
	/*
	public static void diziGezinme(int[] dizi) {
		// bu metot 1. soruda dizi yazdırma ile aynı işleve sahip olduğu için 
		//tekrardan oluşturulmaya ihtiyaç duyulmamıştır
	}
	*/
	
	// RECURSİVE metotlar 
	public static void recDiziGezinme(int[] dizi,int index) {
		if(index >=dizi.length) {
			return;
		}
		System.out.println(dizi[index]);
		recDiziGezinme(dizi,index+1);	
	}
	
	public static int recDiziAra(int[] dizi,int aranan,int index) {
		if(index >= dizi.length) {
			return -1;
		}
		if(dizi[index]==aranan) {
			return index;
		}
		return recDiziAra(dizi,aranan,index+1);
	}
	
	
	
	
	public static void main(String[] args) {

		int[] dizi= {9,3,5,6,3,1,4,1,10};
		
		// Recursive metotların kullanımı
		System.out.println("*****************");
		//recursive kullanarak dizide eleman arama metot kullanımı
		System.out.println(recDiziAra(dizi,9,0));
		//recursive kullanarak diziyi gezinme
		recDiziGezinme(dizi,0);
		
		//ödev yönergesindeki örnek main test kodları
		System.out.println("*****************");
		dizi=elemanEkle(dizi,5);
		diziYaz(dizi);
		System.out.println("*****************");
		dizi=elemanSil(dizi);
		diziYaz(dizi);
		System.out.println("*****************");
		System.out.println("el say: " +diziElemanSay(dizi,1));
		diziYaz(diziArananElemanIndeks(dizi,1));
		

	}

}
