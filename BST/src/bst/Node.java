package bst;

public class Node {
    int value;        // Düğümün değeri
    Node left, right; // Sol ve sağ çocuk düğümleri

    public Node(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}