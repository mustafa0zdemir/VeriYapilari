package YeniPkg;

import java.util.Scanner;

public class AnaSinif {
	
	String ad;
	String soyad;
	int okulNo;
	int yas;
	
	// Parametresiz constructor
	public AnaSinif() {
		ad = "Mustafa";
		soyad = "Özdemir";
		okulNo = 5076019;
		yas = 19;
	}
	
	// Ad ve soyad parametreli constructor
	public AnaSinif(String ad, String soyad) {
		this.ad = ad;
		this.soyad = soyad;
		this.okulNo = 0000000;
		this.yas = 18;
	}

	// Ad ve okulNo parametreli constructor
	public AnaSinif(String ad, int okulNo) {
		this.ad = ad;
		this.okulNo = okulNo;
	}
	
	// Tüm parametreli constructor
	public AnaSinif(String ad, String soyad, int okulNo, int yas) {
		this.ad = ad;
		this.soyad = soyad;
		this.okulNo = okulNo;
		this.yas = yas;
	}
	
	// Statik metot                  //yan etkisinden dolayı mı çağlırıyor !!!!
	public static void yazdir() {
		String NeSınıfı = "Öğretmen Bilgi Sınıfı";
		System.out.println(NeSınıfı);
	}
	
	// İkinciSinif parametreli metot
	public void ikinciSinifDegerYazdir(İkinciSinif iks) {
		System.out.println("Ad: " + iks.getOgretmen());
		System.out.println("Branş: " + iks.getBrans());
		System.out.println("Akademik Yayın Sayısı: " + iks.getAkademikYayinSayisi());
	}
	
	// İkinciSinifa değer atayan metot
	public İkinciSinif ikinciSinifaDegerAta(String ogretmen, String brans, int akademikYayinSayisi) {
		İkinciSinif iks = new İkinciSinif();
		iks.setOgretmen(ogretmen);
		iks.setBrans(brans);
		iks.setAkademikYayin(akademikYayinSayisi);
		return iks;
	}
	

	public static void main(String[] args) {
		AnaSinif.yazdir(); //yazdır metodu çağrılıyor 
		
		AnaSinif anasinif = new AnaSinif(); // AnaSinif nesnesi oluşturuluyor
		Scanner scanner = new Scanner(System.in);
		
		// İkinciSinif türünde dizi oluşturuluyor
		İkinciSinif[] iksArray = new İkinciSinif[10];
		
		// Kullanıcıdan veri alarak diziye değer atama
		for (int i = 0; i < iksArray.length; i++) {
			System.out.println((i + 1) + ". öğretmenin adı:");
			String ogretmen = scanner.nextLine();
			
			System.out.println("Branşı:");
			String brans = scanner.nextLine();
			
			System.out.println("Akademik Yayın Sayısı:");
			int akademikYayinSayisi = scanner.nextInt();
			scanner.nextLine();

			// ikinciSinifaDegerAta metodu ile değerler atanıyor
			iksArray[i] = anasinif.ikinciSinifaDegerAta(ogretmen, brans, akademikYayinSayisi);
		}
		
		// Değerleri yazdırma
		for (İkinciSinif iks : iksArray) {
			anasinif.ikinciSinifDegerYazdir(iks);
			System.out.println();
		}
		
		// Manuel olarak bir nesneye değer atama
		İkinciSinif iks = new İkinciSinif();
		iks.setOgretmen("Mustafa Özdemir");
		iks.setBrans("Veri Yapıları");
		iks.setAkademikYayin(57);
		
		// Bu nesnenin değerlerini yazdırma
		anasinif.ikinciSinifDegerYazdir(iks);
		
	
	}
}

