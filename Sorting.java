import java.util.ArrayList;



public class Sorting {

    // ==============================================
    // Merge sort by deadline (0(n log n))
    // ==============================================
    public static void mergeSort(ArrayList<Task> arr, int kiri, int kanan) {
        if (kiri < kanan) {
            int tengah = (kiri + kanan) / 2;
            
            // Rekursi
            mergeSort(arr, kiri, tengah);
            mergeSort(arr, tengah + 1, kanan);

            merge(arr, kiri, tengah, kanan);
        }
    }

    private static void merge(ArrayList<Task> arr, int kiri, int tengah, int kanan) {
        ArrayList<Task> temp = new ArrayList<>();
        
        int i = kiri, j = tengah + 1;

        while (i <= tengah && j <= kanan) {
            if (arr.get(i).deadline.compareTo(arr.get(j).deadline) <= 0) {
                temp.add(arr.get(i++));

            } else {
                temp.add(arr.get(j++));
            }
        }

        while (i <= tengah) temp.add(arr.get(i++));
        while (j <= kanan) temp.add(arr.get(j++));

        for (int k = 0; k < temp.size(); k++) {
            arr.set(kiri + k, temp.get(k));

        }
    }
    
}
