import java.util.ArrayList;
public class PrioritasQueueTask {
    private ArrayList<Task> heap;

    public PrioritasQueueTask() {
        heap = new ArrayList<>();
    }

    // ==============================================
    // insert Task ke dalam heap (0(log n))
    // ==============================================
    public void insert (Task t) {
        heap.add(t);
        heapifyUp(heap.size() - 1);

    }

    private void heapifyUp(int index) {
        // 0(log n)
        while (index > 0) {
            int parent = (index - 1) / 2;

            // prioritas kecil = paling penting
            if(heap.get(index).prioritas < heap.get(parent).prioritas) {
                swap(index, parent);
                index = parent;
            } else {
                return;
            }
        }
    }

    // ==============================================
    // Remove task prioritas tertinggi (0(log n))
    // ==============================================
    public Task remove() {
        if (heap.isEmpty())  return null;

        Task root = heap.get(0);
        Task last = heap.remove(heap.size() - 1);

        if (!heap.isEmpty()) {
            heap.set(0, last);
            heapifyDown(0);

        }

        return root;

    }

    private void heapifyDown( int index) {
        // 0(log n)
        int smallest = index;
        int left = index * 2 + 1;
        int right = index * 2 + 2;

        if (left < heap.size() &&
            heap.get(left).prioritas < heap.get(smallest).prioritas) {
            smallest = left;

    }

       if (right < heap.size() &&
           heap.get(right).prioritas < heap.get(smallest).prioritas) {
           smallest = right;
    }

       if (smallest != index) {
        swap(index, smallest);
        heapifyDown(smallest);
       }

}
      private void swap(int a, int b) {
        Task temp = heap.get(a);
        heap.set(a, heap.get(b));
        heap.set(b, temp);
      }

      public ArrayList<Task> getAll() {
        return heap;
      }

}

    

