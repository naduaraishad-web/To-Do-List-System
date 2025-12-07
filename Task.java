public class Task {
    int id;
    String nama;
    int prioritas; // 1 = tinggi, 3 = rendah
    String deadline;

    public Task(int id, String nama, int prioritas, String deadline) {
        this.id = id;
        this.nama = nama;
        this.prioritas = prioritas;
        this.deadline = deadline;

    }

    @Override
    public String toString() {
        return "[ID:" + id + " | " + nama + " | prioritas: " + prioritas + " | Deadline: " + deadline + "]";
    }
}