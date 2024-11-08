package KuyrukUygulaması;

public class BagliListeKuyruk {
	
	Eleman on;  //kuyruk yapısını oluşturmak için on ve arka referansların tutulmasını sağlayan değiişkenler oluşturuldu
	Eleman arka;
	int elemanSayisi;
	

	
	public BagliListeKuyruk (int size){ // BagliListeKuyruk türünden kuyruk yapısı oluşturulduğunda size değeri de tanımlanmış olur 
		this.on = null;
		this.arka = null;
		this.elemanSayisi = 0;		
	}
	
	boolean bosMu() { // kuyruk yapısı boş ise true döndürür
		
		return elemanSayisi == 0;
	}
	
	public void kuyrukEkle(Eleman yeni) { 
	
		if(bosMu()) { // kuyruk bos ise tek seferlik ön ve arka referans yeni yi gösterir !!!!!! yapılması çok önemli mi hocaya sor 
			on = yeni;
			arka = yeni;
		}
		arka.sonraki = yeni; // kuyruk yapısına eleman eklemesi yapmak için arka referans sonraki yeni elemana işaret eder
		arka = yeni;     // arka değer güncellenir
		elemanSayisi++;  // eleman sayisi arttırılır
	}
	
	public void kuyrukSil() {
		if(bosMu()) { // kuyruktan eleman silmeden önce doluluk kontrol edilir
			System.out.println("kuyruk bos"); // boş ise silme işlemi yapmadan işlem sonlanır
			return;
		}
		Eleman temp = on;  // Eleman türünden geçici referans tutucu bir değişken oluşturulur 
		on = on.sonraki; //on değeri sonraki düğümü işaret eder ve ilk düğümdeki işaretçi kaybolur ve düğüm silinir
		  System.out.println("****"+temp.isim + " " + temp.soyisim + " " + temp.telno + " " + temp.dt+"****"); // geçici olarak tutulan referans yazdırılır
		temp.sonraki = null; // temp sonraki işlemler için boşaltılır
		elemanSayisi--;  
		
	}
	
	public void kuyurkYazdir() {
		if(bosMu()) {
			System.out.println("kuyruk bos");
			return;
		}
		Eleman tmp;
		tmp = on;
		while(tmp != null) {
			  System.out.println(tmp.isim + " " + tmp.soyisim + " " + tmp.telno + " " + tmp.dt);
			  tmp = tmp.sonraki;
		}
		
	}
	
	public int elemanSayisi() {
		return elemanSayisi;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
