package bst;

public class Main {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        // Düğüm ekleme
        bst.insert(50);
        bst.insert(30);
        bst.insert(20);
        bst.insert(40);
        bst.insert(70);
        bst.insert(60);
        bst.insert(80);

        // Ağacı sıralı şekilde yazdır
        System.out.println("In-order traversal of the BST:");
        bst.inOrder();

        // Düğüm arama
        System.out.println("Is 40 in the BST? " + bst.search(40));
        System.out.println("Is 100 in the BST? " + bst.search(100));

        // Düğüm silme
        System.out.println("Deleting 20...");
        bst.delete(20);
        System.out.println("In-order traversal after deleting 20:");
        bst.inOrder();

        System.out.println("Deleting 30...");
        bst.delete(30);
        System.out.println("In-order traversal after deleting 30:");
        bst.inOrder();

        System.out.println("Deleting 50...");
        bst.delete(50);
        System.out.println("In-order traversal after deleting 50:");
        bst.inOrder();
    }
}