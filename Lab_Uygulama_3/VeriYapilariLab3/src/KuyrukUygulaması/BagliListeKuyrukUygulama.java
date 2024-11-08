package KuyrukUygulaması;



public class BagliListeKuyrukUygulama {

	public static void main(String[] args) {
	 BagliListeKuyruk q = new BagliListeKuyruk(3);
		Eleman kisi1 = new Eleman("Mustafa","Özdemir",543614,2005);
		Eleman kisi2 = new Eleman("Mustafa","Demir",543122,2004);
		Eleman kisi3 = new Eleman("Efekan","Adalı",553553,2005); 
		Eleman kisi4 = new Eleman("alaaddin","46",1213,1989);
	
		
		
		q.kuyrukEkle(kisi1);
		q.kuyrukEkle(kisi2);
		q.kuyrukEkle(kisi3);
		q.kuyrukEkle(kisi4);
		System.out.println(q.elemanSayisi());
		q.kuyurkYazdir();
		System.out.println("----------------------------");
	
		q.kuyrukSil();
		q.kuyurkYazdir();
		System.out.println("----------------------------");

		q.kuyrukSil();
		q.kuyurkYazdir();
		System.out.println("----------------------------");
		
		q.kuyrukSil();
		q.kuyurkYazdir();
		System.out.println("----------------------------");
		q.kuyrukSil();
		System.out.println("----------------------------");
	}

}
