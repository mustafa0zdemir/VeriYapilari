package LifeGame;

public class LifeGame {
	final int habitatSatir = 19;
	final int habitatSutun = 19;
	int hucreHabitat[][];
	int hucreHabitatTmp[][];
	int[] pulsarSatir;
	int[] pSatir;
	int pulsarSutun[];

	public LifeGame() {
// pulsar desni oluşması için gerekli ön tanımlamalar
		pSatir = new int[] { 3, 8, 10, 15 };
		pulsarSatir = new int[] { 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0 };
		pulsarSutun = new int[] { 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0 };
// gerçek yaşam alanı ve değişikliklerin yapılacağı yedek yaşam alanı tanımı
		hucreHabitat = new int[habitatSatir][habitatSutun];
		hucreHabitatTmp = new int[habitatSatir][habitatSutun];
// tüm yedek ve gerçek yaşam alanı sıfırlanıyor
		int c = 0;
		for (int i = 0; i < habitatSatir; i++) {
			for (int y = 0; y < habitatSutun; y++) {
				hucreHabitatTmp[i][y] = c;
				hucreHabitat[i][y] = c;
			}
		}
// pulsar deseni gerçek yaşam alanına atanıyor
		for (int satir = 0; satir < pSatir.length; satir++) {
			for (int sutun = 0; sutun < habitatSutun; sutun++) {
				hucreHabitat[pSatir[satir]][sutun] = pulsarSatir[sutun];
			}
		}
		for (int sutun = 0; sutun < pSatir.length; sutun++) {
			for (int satir = 0; satir < habitatSutun; satir++) {
				hucreHabitat[satir][pSatir[sutun]] = pulsarSatir[satir];
			}
		}
	}

	public void drawHabitat() {
// gerçek yaşam alanı (hucreHabitat) ekrana çizdiriliyor
		for (int i = 1; i <= 17; i++) {
			for (int j = 1; j <= 17; j++) {
				if (hucreHabitat[i][j] == 1) {
					System.out.print("#");
				} else {
					System.out.print("-");
				}
			}
			System.out.println();
		}
	}

	public int komsuCanliSayisi(int satir, int sutun) {
		int canliKomsuSayisi = 0;
// koordinatları girilen hücre merkezde olmak üzere 3x3 lük alanda
// canlı komşu sayısı tespiti yapılıyor. Eğer kendiside canlı ise
// canlı komşuya eklenmemelidir.
		for (int i = -1; i <= 1; i++) {
			for (int j = -1; j <= 1; j++) {
			
				if (i == 0 && j == 0) { // kendisini de komşu saymaması için şart koşuldu 
				}

				// Sınır kontrolü
				int yeniSatir = satir + i;
				int yeniSutun = sutun + j;
				if (yeniSatir >= 1 && yeniSatir <= 17 && yeniSutun >= 1 && yeniSutun <= 17) {
					if (hucreHabitat[yeniSatir][yeniSutun] == 1) {
						canliKomsuSayisi++;
					}
				}
			}
		}
		return canliKomsuSayisi;
	}

	public void newHabitatRule() {
// Life Game'in 4 kuralına göre gerçek habitata bakılarak
// bir sonraki iterasyon için geçici habitat (hucreHabitatTmp)
// güncelleniyor
		// İç çerçevedeki tüm hücreleri dolaş
		for (int satir = 1; satir <= 17; satir++) {
			for (int sutun = 1; sutun <= 17; sutun++) {
				// Komşu canlı sayısını hesapla
				int canliKomsuSayisi = komsuCanliSayisi(satir, sutun);

				// Hücre şu anda canlı mı? (1 ise canlı, 0 ise ölü)
				if (hucreHabitat[satir][sutun] == 1) {
					// Canlı hücre kurallarını uygula
					if (canliKomsuSayisi < 2 || canliKomsuSayisi > 3) {
						hucreHabitatTmp[satir][sutun] = 0; // Hücre ölür
					} else {
						hucreHabitatTmp[satir][sutun] = 1; // Hücre hayatta kalır
					}
				} else {
					// Ölü hücre kurallarını uygula
					if (canliKomsuSayisi == 3) {
						hucreHabitatTmp[satir][sutun] = 1; // Hücre yeniden canlanır
					} else {
						hucreHabitatTmp[satir][sutun] = 0; // Hücre ölü kalır
					}
				}
			}
		}
	}

	public void copyHabitat() {
		// yedek hücreden tekrar orjinaline yükleme yap
		for (int i = 0; i < habitatSatir; i++) {
			for (int j = 0; j < habitatSutun; j++) {
				hucreHabitat[i][j] = hucreHabitatTmp[i][j];
			}
		}
	}

	public static void main(String[] args) throws Exception {
		LifeGame lg = new LifeGame();
		for (int i = 0; i < 20; i++) {
		    lg.drawHabitat();
		    lg.newHabitatRule();
		    lg.copyHabitat();  
		    System.out.println();
		    Thread.sleep(1500);
		}

	}
}