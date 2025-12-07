import java.util.*;

public class Main {
    static PrioritasQueueTask pq = new PrioritasQueueTask();
    static int counterID = 1;
    

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== TO DO LIST PRIORITAS SISTEM ===== ");
            System.out.println("1. Tambah Tugas");
            System.out.println("2. Ambil Tugas Prioritas Tertinggi");
            System.out.println("3. Tampilkan semua (Rekursif)");
            System.out.println("4. Sorting by Deadline ( Merge Sort)");
            System.out.println("5. Cari Task / tugas (Searching)");
            System.out.println("6. Keluar");
            System.out.println("Pilihan (1 - 6): ");

            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    tambahTugas(sc);
                    break;
                case 2:
                    hapusTugas();
                    break;
                case 3:
                    displayTugasRekursif();
                    break;
                case 4:
                    sortDeadline();
                    break;
                case 5:
                    searchTugas(sc);
                    break;
                case 6:
                    return;
                    
            }
            
        }
    }

    // tambah data
    public static void tambahTugas(Scanner sc) {
        System.out.println("Nama tugas: ");
        String nama = sc.nextLine();

        System.out.println("Prioritas ( 1 = tinggi, 3 = rendah): ");
        int prioritas = sc.nextInt();
        sc.nextLine();

        System.out.println("Deadline (YYYY-MM-DD): ");
        String deadline = sc.nextLine();
        

        Task t = new Task(counterID++, nama, prioritas, deadline);
        pq.insert(t);

        System.out.println("Tugas berhasil ditambahkan!");
    }

    // Ambil tugas yang paling prioritas
    public static void hapusTugas() {
        Task t = pq.remove();
        if (t == null) {
            System.out.println("Tidak ada tugas :).");
        } else {
            System.out.println("Tugas diambil : " + t);
        }
    }

    // Tampilkan rekursif
    public static void displayTugasRekursif() {
        RecursionDisplay.displayRekursif(pq.getAll(), 0);
    }

    // Sorting Deadline
    public static void sortDeadline() {
        ArrayList<Task> arr = pq.getAll();
        Sorting.mergeSort(arr, 0, arr.size() -1);
        System.out.println("Sorting berdasarkan deadline Tugas.");
    }

    // Searching 
    public static void searchTugas(Scanner sc) {
        System.out.println("Cari nama tugas: ");
        String nama = sc.nextLine();

        Task result = Searching.searchDenganNama(pq.getAll(), nama);

        if (result == null)
            System.out.println("Tugas tidak ditemukan / tidak ada.");
        else
            System.out.println("Tugas Ditemukan: " + result);
    }
    
}
