package hash;

public class HashMain {
    public static void main(String[] args) {
        HashTable hashTable = new HashTable(5);

        // Değerler ekle
        hashTable.add(10);
        hashTable.add(15);
        hashTable.add(20);
        hashTable.add(25);
        hashTable.add(42);
        hashTable.add(49);
        hashTable.add(9);
        hashTable.showHashTable();
        System.out.println();

        hashTable.delete(15);
        System.out.println();
        hashTable.showHashTable();

        // Boş tablo kontrolü
        System.out.println("\nIs hash table empty? " + hashTable.isNull());

        // Aynı değeri tekrar eklemeyi deneyin
        System.out.println("\nAdding duplicate value 20:");
        hashTable.add(20);
        hashTable.showHashTable();
    }
}
