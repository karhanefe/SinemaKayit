import java.util.Scanner;

public class SinemaSistemi {
    static String[] filmAdlari = new String[10];
    static int[] filmSureleri = new int[10];
    static String[] filmTurleri = new String[10];
    static int filmSayisi = 0;

    static String[] musteriAdlari = new String[20];
    static String[] musteriEmailleri = new String[20];
    static int musteriSayisi = 0;

    static int[][] biletler = new int[20][10]; // müşteri-filmler eşleşmesi (1 = satın aldı)

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int secim;
        do {
            System.out.println("\n--- Sinema Sistemi Menüsü ---");
            System.out.println("1. Film Ekle");
            System.out.println("2. Müşteri Ekle");
            System.out.println("3. Bilet Sat");
            System.out.println("4. Filmleri Listele");
            System.out.println("5. Müşterileri Listele");
            System.out.println("6. Biletleri Listele");
            System.out.println("0. Çıkış");
            System.out.print("Seçiminiz: ");
            secim = input.nextInt();
            input.nextLine(); // dummy enter

            switch (secim) {
                case 1: filmEkle(); break;
                case 2: musteriEkle(); break;
                case 3: biletSat(); break;
                case 4: filmleriListele(); break;
                case 5: musterileriListele(); break;
                case 6: biletleriListele(); break;
                case 0: System.out.println("Çıkılıyor..."); break;
                default: System.out.println("Geçersiz seçim.");
            }

        } while (secim != 0);
    }

    public static void filmEkle() {
        if (filmSayisi >= 10) {
            System.out.println("Maksimum film sayısına ulaşıldı.");
            return;
        }
        System.out.print("Film adı: ");
        filmAdlari[filmSayisi] = input.nextLine();
        System.out.print("Film süresi (dakika): ");
        filmSureleri[filmSayisi] = input.nextInt();
        input.nextLine();
        System.out.print("Film türü: ");
        filmTurleri[filmSayisi] = input.nextLine();
        filmSayisi++;
        System.out.println("Film eklendi.");
    }

    public static void musteriEkle() {
        if (musteriSayisi >= 20) {
            System.out.println("Maksimum müşteri sayısına ulaşıldı.");
            return;
        }
        System.out.print("Müşteri adı: ");
        musteriAdlari[musteriSayisi] = input.nextLine();
        System.out.print("Müşteri email: ");
        musteriEmailleri[musteriSayisi] = input.nextLine();
        musteriSayisi++;
        System.out.println("Müşteri eklendi.");
    }

    public static void biletSat() {
        if (musteriSayisi == 0 || filmSayisi == 0) {
            System.out.println("Lütfen önce müşteri ve film ekleyin.");
            return;
        }

        System.out.println("Müşteriler:");
        for (int i = 0; i < musteriSayisi; i++) {
            System.out.println(i + " - " + musteriAdlari[i]);
        }

        System.out.print("Müşteri numarası: ");
        int musteriNo = input.nextInt();
        input.nextLine();

        if (musteriNo < 0 || musteriNo >= musteriSayisi) {
            System.out.println("Geçersiz müşteri numarası.");
            return;
        }

        System.out.println("Filmler:");
        for (int i = 0; i < filmSayisi; i++) {
            System.out.println(i + " - " + filmAdlari[i]);
        }

        System.out.print("Film numarası: ");
        int filmNo = input.nextInt();
        input.nextLine();

        if (filmNo < 0 || filmNo >= filmSayisi) {
            System.out.println("Geçersiz film numarası.");
            return;
        }

        biletler[musteriNo][filmNo] = 1;
        System.out.println("Bilet başarıyla satıldı.");
    }

    public static void filmleriListele() {
        System.out.println("--- Filmler ---");
        for (int i = 0; i < filmSayisi; i++) {
            System.out.println(i + ": " + filmAdlari[i] + " | " + filmSureleri[i] + " dk | " + filmTurleri[i]);
        }
    }

    public static void musterileriListele() {
        System.out.println("--- Müşteriler ---");
        for (int i = 0; i < musteriSayisi; i++) {
            System.out.println(i + ": " + musteriAdlari[i] + " | " + musteriEmailleri[i]);
        }
    }

    public static void biletleriListele() {
        System.out.println("--- Satılan Biletler ---");
        for (int i = 0; i < musteriSayisi; i++) {
            System.out.print(musteriAdlari[i] + " -> ");
            boolean biletVar = false;
            for (int j = 0; j < filmSayisi; j++) {
                if (biletler[i][j] == 1) {
                    System.out.print(filmAdlari[j] + ", ");
                    biletVar = true;
                }
            }
            if (!biletVar) {
                System.out.print("Bilet yok.");
            }
            System.out.println();
        }
    }
}
