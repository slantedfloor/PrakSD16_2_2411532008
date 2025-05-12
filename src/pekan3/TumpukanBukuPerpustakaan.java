package pekan3;

import java.util.Scanner;
import java.util.Stack;

class Buku {
    String judul;

    Buku(String judul) {
        this.judul = judul;
    }

    public String toString() {
        return judul;
    }
}

class PerpustakaanMini {
    Stack<Buku> tumpukanBuku = new Stack<>();

    void tambahBuku(Buku buku) {
        tumpukanBuku.push(buku);
        System.out.println("Buku yang ditambahkan: " + buku.judul);
    }

    void ambilBuku() {
        if (!tumpukanBuku.isEmpty()) {
            Buku buku = tumpukanBuku.pop();
            System.out.println("Buku yang diambil: " + buku.judul);
        } else {
            System.out.println("Tidak ada buku yang diambil.");
        }
    }

    void lihatTumpukan() {
        if (tumpukanBuku.isEmpty()) {
            System.out.println("Tumpukan buku kosong");
        } else {
            System.out.println("Tumpukan buku saat ini:");
            for (int i = tumpukanBuku.size() - 1; i >= 0; i--) {
                System.out.println(tumpukanBuku.get(i).judul);
            }
        }
    }

public class TumpukanBukuPerpustakaan {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PerpustakaanMini perpus = new PerpustakaanMini();

        String[] bukuAwal = {
            "Algoritma Dasar", "Struktur Data", "Basis Data",
            "Pemrograman Java", "Jaringan Komputer",
            "Sistem Operasi", "Kecerdasan Buatan"
        };

        for (String judul : bukuAwal) {
            perpus.tambahBuku(new Buku(judul));
        }

        int pilihan;
        do {
            System.out.println("\n === MENU PERPUSTAKAAN MINI ===");
            System.out.println("1. Tambah Buku ke Tumpukan");
            System.out.println("2. Ambil Buku Teratas");
            System.out.println("3. Lihat Tumpukan Buku");
            System.out.println("4. Keluar");
            System.out.print("Pilih: ");
            pilihan = scanner.nextInt();
            scanner.nextLine(); 

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan judul buku yang ingin ditambahkan: ");
                    String judulBaru = scanner.nextLine();
                    perpus.tambahBuku(new Buku(judulBaru));
                    break;
                case 2:
                    perpus.ambilBuku();
                    break;
                case 3:
                    perpus.lihatTumpukan();
                    break;
                case 4:
                    System.out.println("Keluar dari program.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (pilihan != 4);
    }
}
