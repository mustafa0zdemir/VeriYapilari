package YıgınUygulaması;

public class BagliListeYigin {

    Eleman top;
    int elemanSayisi;

    BagliListeYigin() { // BagliListeYigin'den bir yığın listesi oluşturulduğunda yapıcı metot çalışır
        this.top = null;
        this.elemanSayisi = 0;
    }

    public void yiginaEkleme(Eleman yeni) { // Yığına eleman eklemeden önce dolu olup olmadığını kontrol eder
        if (top == null) {
            top = yeni;
        } else { // boş değilse
            yeni.sonraki = top; // Yeni elemanın "sonraki" referansını mevcut "top" elemanına bağlar
            top = yeni; // "top" elemanını "yeni" olarak günceller
        }
        elemanSayisi++; // Eleman sayısını artırır
    }

    public void yıgındanCekme() { // Yığından eleman çekmeden önce boş olup olmadığını kontrol eder
        if (bosMu()) {
            System.out.println("YIĞIN BOŞ"); // Yığın boşsa kullanıcıya mesaj verilir
            return;
        }
        Eleman tmp2 = top; // Eğer dolu ise Eleman türünden bir temp referansı oluşturulur ve bu referans top değişkenini işaret eder
        top = top.sonraki; // top değeri bir sonraki elemana kaydırılır
        System.out.println("**** " + tmp2.isim + " " + tmp2.soyisim + " " + tmp2.telno + " " + tmp2.dt + " ****"); // Çıkarılan elemanlar gösterilir
        tmp2.sonraki = null; // Kullanıcıya yazdırıldıktan sonra tmp referansı null olarak ayarlanır
        elemanSayisi--; // Eleman sayısı azaltılır
    }

    boolean bosMu() { // Yığının boş olup olmadığını kontrol eder
        return elemanSayisi == 0; // Eleman sayısı 0 ise true döndürür
    }

    public void yazdirYigin() { // Yığındaki elemanları yazdırır
        Eleman tmp = top; // Eleman türünden bir temp referansı oluşturur ve top değeri bu referansa atanır
        while (tmp != null) { // temp referansı null olana kadar döngü devam eder
            System.out.println(tmp.isim + " " + tmp.soyisim + " " + tmp.telno + " " + tmp.dt);
            tmp = tmp.sonraki; // Her döngüde temp referansı bir sonraki elemana kaydırılır
        }
    }

    public int yiginElemanSayisi() {  
        System.out.println(elemanSayisi);
        return elemanSayisi;
    }

    public void topGoster() { // Yığının en üstündeki elemanı gösterir
        if (bosMu()) {
            System.out.println("YİĞİN BOŞ");
            return;
        }
        System.out.println("Top'taki eleman: " + top.isim + " " + top.soyisim + " " + top.telno + " " + top.dt);
    }
}
