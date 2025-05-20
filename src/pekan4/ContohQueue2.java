package pekan4;

import java.util.LinkedList;
import java.util.Queue;

public class ContohQueue2 {

	public static void main(String[] args) {
		Queue<Integer> q = new LinkedList<>();
		// tambah elemen {0, 1, 2, 3, 4, 5} ke antrian
		for (int i = 0; i < 6; i++) {
			q.add(i);
		}
			// menampilkan isi antrian
			System.out.println("Elemen Antrian " + q);
			// untuk menghapus kepala antrian.
			int hapus = q.remove();
			// untuk melihat antrian terdepan
			int depan = q.peek();
			System.out.println("Kepala Antrian = " + depan);
			
			int banyak = q.size();
			System.out.println("Size antrian = " + banyak);

	}

}
