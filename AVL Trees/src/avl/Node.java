package avl;

public class Node {
    int value;
    Node left, right;
    int height;

    public Node(int value) {
        this.value = value;
        left = right = null;
        height = 1; // Yeni bir düğümün başlangıç yüksekliği 1'dir
    }
}