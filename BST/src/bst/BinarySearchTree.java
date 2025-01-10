package bst;

public class BinarySearchTree {
    Node root;

    public BinarySearchTree() {
        root = null; // Ağacın başlangıçta boş olduğunu belirtiyoruz
    }

    // Düğüm ekleme
    void insert(int value) {
        root = insertRec(root, value);
    }

    // Düğüm ekleme için yardımcı metot (recursive)
    private Node insertRec(Node root, int value) {
        if (root == null) {
            root = new Node(value); // Yeni düğüm oluştur
            return root;
        }

        if (value < root.value) {
            root.left = insertRec(root.left, value); // Sol alt ağaçta devam et
        } else if (value > root.value) {
            root.right = insertRec(root.right, value); // Sağ alt ağaçta devam et
        }

        return root;
    }

 // Düğüm arama
    Node search(int value) {
        return searchRec(root, value);
    }

    // Düğüm arama için yardımcı metot (recursive)
    private Node searchRec(Node root, int value) {
        if (root == null || root.value == value) {
            return root; // Düğüm bulunamazsa null döner, bulunursa düğümün kendisini döner
        }

        if (value < root.value) {
            return searchRec(root.left, value); // Sol alt ağaçta arama
        } else {
            return searchRec(root.right, value); // Sağ alt ağaçta arama
        }
    }

    // Düğüm silme
    void delete(int value) {
        root = deleteRec(root, value);
    }

    // Düğüm silme için yardımcı metot (recursive)
    private Node deleteRec(Node root, int value) {
        if (root == null) {
            return root;
        }

        if (value < root.value) {
            root.left = deleteRec(root.left, value);
        } else if (value > root.value) {
            root.right = deleteRec(root.right, value);
        } else {
            // Düğüm bulundu, silme işlemi
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            // İki çocuk düğüm varsa
            root.value = findMinValue(root.right); // Sağ alt ağaçtaki en küçük değeri al
            root.right = deleteRec(root.right, root.value); // Sağ alt ağaçtan bu düğümü sil
        }

        return root;
    }

    // Sağ alt ağaçtaki en küçük değeri bul
    private int findMinValue(Node root) {
        int minValue = root.value;
        while (root.left != null) {
            minValue = root.left.value;
            root = root.left;
        }
        return minValue;
    }

    // Ağacı sıralı şekilde dolaşma (in-order traversal)
    void inOrder() {
        inOrderRec(root);
        System.out.println();
    }

    private void inOrderRec(Node root) {
        if (root != null) {
            inOrderRec(root.left);
            System.out.print(root.value + " ");
            inOrderRec(root.right);
        }
    }

    // Post-order Traversal
    void postOrder() {
        postOrderRec(root);
        System.out.println();
    }

    private void postOrderRec(Node root) {
        if (root != null) {
            postOrderRec(root.left);
            postOrderRec(root.right);
            System.out.print(root.value + " ");
        }
    }

    // Pre-order Traversal
    void preOrder() {
        preOrderRec(root);
        System.out.println();
    }

    private void preOrderRec(Node root) {
        if (root != null) {
            System.out.print(root.value + " ");
            preOrderRec(root.left);
            preOrderRec(root.right);
        }
    }
}