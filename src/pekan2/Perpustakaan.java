package pekan2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.Scanner;

class Buku {
	String judul, pengarang, isbn;
	Buku(String judul, String pengarang, String isbn) {
		this.judul = judul;
		this.pengarang = pengarang;
		this.isbn = isbn;
	}
}

class Perpustakaan {
	LinkedList<Buku> koleksiBuku = new LinkedList<>();
	Queue<Buku> Peminjaman = new LinkedList<>();
	Stack<Buku> Pengembalian = new Stack<>();
	
	void tambahBuku(String judul, String pengarang, String isbn) {
		koleksiBuku.add(new Buku(judul, pengarang, isbn));
	}
	
	void pinjamBuku(String judul) {
		for (Buku buku : koleksiBuku) {
			if (buku.judul.equals(judul)) {
				Peminjaman.add(buku);
				break;
			}
		}
	}
	
	void kembalikanBuku(String judul) {
		for (Buku buku : Peminjaman) {
			if (buku.judul.equals(judul)) {
				Pengembalian.push(buku);
				break;
			}
		}
	}
	public static void main (String[] args) {
		Perpustakaan perpustakaan = new Perpustakaan();
		Scanner scanner = new Scanner(System.in);
		while(true) {
			System.out.println("1. Tambah Buku\n2. Pinjam Buku\n3. Kembalikan Buku\n4. Keluar");
			System.out.print("Pilih opsi: ");
			int pilihan = scanner.nextInt();
			scanner.nextLine();
			if (pilihan == 1) {
				System.out.println("Masukkan Judul: ");
				String judul = scanner.nextLine();
				System.out.println("Masukkan Pengarang: ");
				String pengarang = scanner.nextLine();
				System.out.println("Masukkan ISBN: ");
				String isbn = scanner.nextLine();
				perpustakaan.tambahBuku(judul, pengarang, isbn);
			} else if (pilihan == 2) {
				System.out.println("Masukkan judl buku yang ingin dipinjam: ");
				String judul = scanner.nextLine();
				perpustakaan.pinjamBuku(judul);
			} else if (pilihan == 3) {
				System.out.println("Masukkan judl buku yang ingin dikembalikan: ");
				String judul = scanner.nextLine();
				perpustakaan.kembalikanBuku(judul);
			} else if (pilihan == 4) {
				break;
			}
			
		}
		scanner.close();
	}
}