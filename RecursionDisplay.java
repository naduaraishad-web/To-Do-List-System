import java.util.ArrayList;
public class RecursionDisplay {
 
    // ==============================================
    // Display task rekursif (0(n))
    // ==============================================
    public static void displayRekursif(ArrayList<Task> arr, int index) {
        if ( index == arr.size()) {
            return;
        }

        System.out.println(arr.get(index));
        displayRekursif(arr, index + 1); 

    }
    
}
