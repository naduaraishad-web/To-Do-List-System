import java.util.ArrayList;
public class Searching {

    // ==============================================
    // linear search (0(n))
    // ==============================================
    public static Task searchDenganNama(ArrayList<Task> arr, String nama) {
        for(Task t : arr) {
            if (t.nama.equalsIgnoreCase(nama)) return t;
        }
        return null;
    }
}
