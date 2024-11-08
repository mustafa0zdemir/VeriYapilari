package YıgınUygulaması;

public class Eleman {
	String isim;
	String soyisim;
	int telno;
	int dt;
	Eleman sonraki;

	
	public Eleman(String isim, String soyisim, int telno, int dt ) {
		this.isim = isim;
		this.soyisim = soyisim;
		this.telno = telno;
		this.dt = dt;
		this.sonraki = null;
	}	 
}
