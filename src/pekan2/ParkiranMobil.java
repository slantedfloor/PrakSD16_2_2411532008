package pekan2;

import java.util.ArrayList;
import java.util.Scanner;

class Mobil {
    String platNomor;

    public Mobil(String platNomor) {
        this.platNomor = platNomor;
    }

    public String getPlatNomor() {
        return platNomor;
    }
}

class Parkir {
    ArrayList<Mobil> daftarMobil = new ArrayList<>();

    public void tambahMobil(String platNomor) {
        daftarMobil.add(new Mobil(platNomor));
        System.out.println("Mobil dengan plat nomor " + platNomor + " telah memasuki tempat parkir.");
    }

    public void keluarkanMobil(String platNomor) {
        boolean found = false;
        for (int i = 0; i < daftarMobil.size(); i++) {
            if (daftarMobil.get(i).getPlatNomor().equalsIgnoreCase(platNomor)) {
            	daftarMobil.remove(i);
                System.out.println("Mobil dengan plat nomor " + platNomor + " telah keluar dari tempat parkir.");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Mobil dengan plat nomor " + platNomor + " tidak ditemukan.");
        }
    }

    public void tampilkanParkiran() {
        if (daftarMobil.isEmpty()) {
            System.out.println("The parking lot is empty.");
        } else {
            System.out.println("Cars currently in the parking lot:");
            for (Mobil mobil : daftarMobil) {
                System.out.println("- " + mobil.getPlatNomor());
            }
        }
    }

    public void cariMobil(String platNomor) {
        boolean found = false;
        for (Mobil mobil : daftarMobil) {
            if (mobil.getPlatNomor().equalsIgnoreCase(platNomor)) {
                System.out.println("Mobil dengan plat nomor " + platNomor + " ada di parkiran.");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Mobil dengan plat nomor " + platNomor + " tidak ada di parkiran.");
        }
    }
}

public class ParkiranMobil {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Parkir parkiran = new Parkir();


        String[] mobilAwal = {
            "BA1111AA", "BA2222BB", "BA3333CC", "BA4444DD",
            "BA5555EE", "BA6666FF", "BA7777GG"
        };
        for (String plat : mobilAwal) {
            parkiran.tambahMobil(plat);
        }

        int pilihan;
        do {
            System.out.println("\n === Menu Parkiran Mobil === ");
            System.out.println("1. Tambah mobil ke parkiran");
            System.out.println("2. Keluarkan mobil dari parkiran");
            System.out.println("3. Tampilkan isi parkiran");
            System.out.println("4. Cari mobil di parkiran");
            System.out.println("5. Keluar");
            System.out.print("Pilih opsi: ");
            pilihan = scanner.nextInt();
            scanner.nextLine(); 

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan nomor plat mobil untuk menambahkan: ");
                    String mobilBaru = scanner.nextLine();
                    parkiran.tambahMobil(mobilBaru);
                    break;
                case 2:
                    System.out.print("Masukkan nomor plat mobil untuk mengeluarkan: ");
                    String mobilKeluar = scanner.nextLine();
                    parkiran.keluarkanMobil(mobilKeluar);
                    break;
                case 3:
                    parkiran.tampilkanParkiran();
                    break;
                case 4:
                    System.out.print("Masukkan nomor plat mobil untuk mencari mobil: ");
                    String mobilDicari = scanner.nextLine();
                    parkiran.cariMobil(mobilDicari);
                    break;
                case 5:
                    System.out.println("Keluar dari progarm.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. ");
            }
        } while (pilihan != 5);

        scanner.close();
    }
}

