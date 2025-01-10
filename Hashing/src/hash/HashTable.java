package hash;

public class HashTable {

    private Node[] array;

    public HashTable(int length) {
        array = new Node[length];
    }

    public void add(int value) {
        int index = value % array.length;

        if (array[index] == null) {
            array[index] = new Node(value);
        } else {
            Node temp = array[index];
            while (temp.next != null) {
                if (temp.value == value) {
                    return; // Aynı değer zaten varsa ekleme
                }
                temp = temp.next;
            }
            if (temp.value != value) {
                temp.next = new Node(value);
            }
        }
    }

    public boolean delete(int value) {
        int index = value % array.length;

        if (array[index] == null) {
            return false;
        }

        // İlk düğüm kontrolü
        if (array[index].value == value) {
            array[index] = array[index].next;
            return true;
        }

        // Diğer düğümler
        Node temp = array[index];
        while (temp.next != null) {
            if (temp.next.value == value) {
                temp.next = temp.next.next;
                return true;
            }
            temp = temp.next;
        }

        return false; // Değer bulunamadı
    }

    public void showHashTable() {
        if (isNull()) {
            System.out.println("Your hash table is empty.");
            return;
        }

        for (int i = 0; i < array.length; i++) {
            System.out.print(i + ": ");
            Node temp = array[i];
            if (temp != null) {
                while (temp != null) {
                    System.out.print(temp.value);
                    if (temp.next != null) {
                        System.out.print(" -> ");
                    }
                    temp = temp.next;
                }
            }
            System.out.println();
        }
    }

    public boolean isNull() {
        for (Node node : array) {
            if (node != null) {
                return false;
            }
        }
        return true;
    }
}
