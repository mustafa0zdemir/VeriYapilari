package YıgınUygulaması;

public class BagliListeYiginUygulama {

	public static void main(String[] args) {

		BagliListeYigin liste = new BagliListeYigin();
		Eleman kisi1 = new Eleman("Mustafa","Özdemir",543614,2005); // eleman türünden nesneler oluşturulur
		Eleman kisi2 = new Eleman("Mustafa","Demir",543122,2004);
		Eleman kisi3 = new Eleman("Efekan","Adalı",553553,2005); 
		Eleman kisi4 = new Eleman("a","b",33,1);
		
		
		liste.yiginaEkleme(kisi1);
		liste.yiginaEkleme(kisi2);
		liste.yiginaEkleme(kisi3);
		liste.yiginaEkleme(kisi4);
		
		liste.yiginElemanSayisi();
		System.out.println("-----------------------------");
		liste.yazdirYigin();
		
		System.out.println("-----------------------------");
		liste.yıgındanCekme();
		System.out.println("-----------------------------");
		liste.yazdirYigin();
		
		System.out.println("-----------------------------");
		liste.yıgındanCekme();
		System.out.println("-----------------------------");
		liste.yazdirYigin();
		
		System.out.println("-----------------------------");
		liste.yıgındanCekme();
		System.out.println("-----------------------------");
		liste.yazdirYigin();
		
		System.out.println("-----------------------------");
		liste.yıgındanCekme();
		System.out.println("-----------------------------");
		liste.yazdirYigin();
		
	
	}
	
}
