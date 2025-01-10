package heap;

public class MinHeap {
    private int[] heap; // Heap dizisi
    private int size; // Şu anki eleman sayısı
    private int capacity; // Toplam kapasite

    public MinHeap(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.heap = new int[capacity];
    }

    // Ebeveyn, sol çocuk ve sağ çocuk indekslerini hesaplama
    private int parent(int i) { return (i - 1) / 2; }
    private int leftChild(int i) { return 2 * i + 1; }
    private int rightChild(int i) { return 2 * i + 2; }

    // Anahtar ekleme
    public void insert(int value) {
        if (size == capacity) {
            System.out.println("Heap dolu!");
            return;
        }

        // Yeni anahtarı ekle
        size++;
        int i = size - 1;
        heap[i] = value;

        // Heap özelliğini korumak için yukarı hareket et
        while (i != 0 && heap[parent(i)] > heap[i]) {
            swap(i, parent(i));
            i = parent(i);
        }
    }

    // Min değeri (kök) çıkarma
    public int extractMin() {
        if (size <= 0) return Integer.MAX_VALUE;
        if (size == 1) {
            size--;
            return heap[0];
        }

        // Kökü al ve son elemanla değiştir
        int root = heap[0];
        heap[0] = heap[size - 1];
        size--;

        // Heapify işlemi
        heapify(0);
        return root;
    }

    // Heapify işlemi
    private void heapify(int i) {
        int smallest = i;
        int left = leftChild(i);
        int right = rightChild(i);

        if (left < size && heap[left] < heap[smallest]) {
            smallest = left;
        }
        if (right < size && heap[right] < heap[smallest]) {
            smallest = right;
        }
        if (smallest != i) {
            swap(i, smallest);
            heapify(smallest);
        }
    }

    // İki elemanı değiştirme
    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    // Heap'i yazdırma
    public void printHeap() {
        for (int i = 0; i < size; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }
}
