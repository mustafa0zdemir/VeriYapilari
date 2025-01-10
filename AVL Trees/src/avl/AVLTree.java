package avl;


public class AVLTree {
    Node root;

    public AVLTree() {
        root = null;
    }

    // Düğüm ekleme
    void insert(int value) {
        root = insertRec(root, value);
    }

    private Node insertRec(Node node, int value) {
        if (node == null) {
            return new Node(value);
        }

        if (value < node.value) {
            node.left = insertRec(node.left, value);
        } else if (value > node.value) {
            node.right = insertRec(node.right, value);
        } else {
            return node; // Aynı değer eklenmez
        }

        // Yüksekliği güncelle
        node.height = 1 + Math.max(height(node.left), height(node.right));

        // Dengelenme faktörünü hesapla
        int balance = getBalance(node);

        // Dört durum için rotasyon işlemleri
        // Sol-Sol durumu
        if (balance > 1 && value < node.left.value) {
            return rotateRight(node);
        }

        // Sağ-Sağ durumu
        if (balance < -1 && value > node.right.value) {
            return rotateLeft(node);
        }

        // Sol-Sağ durumu
        if (balance > 1 && value > node.left.value) {
            node.left = rotateLeft(node.left);
            return rotateRight(node);
        }

        // Sağ-Sol durumu
        if (balance < -1 && value < node.right.value) {
            node.right = rotateRight(node.right);
            return rotateLeft(node);
        }

        return node; // Dengeli ise düğümü döndür
    }

    // Düğüm silme
    void delete(int value) {
        root = deleteRec(root, value);
    }

    private Node deleteRec(Node node, int value) {
        if (node == null) {
            return node;
        }

        if (value < node.value) {
            node.left = deleteRec(node.left, value);
        } else if (value > node.value) {
            node.right = deleteRec(node.right, value);
        } else {
            // Düğüm bulundu
            if (node.left == null || node.right == null) {
                Node temp = (node.left != null) ? node.left : node.right;
                if (temp == null) {
                    node = null; // Yaprak düğüm
                } else {
                    node = temp; // Tek çocuk
                }
            } else {
                // İki çocuk
                Node temp = findMin(node.right);
                node.value = temp.value;
                node.right = deleteRec(node.right, temp.value);
            }
        }

        if (node == null) {
            return node;
        }

        // Yüksekliği güncelle
        node.height = 1 + Math.max(height(node.left), height(node.right));

        // Dengelenme faktörünü hesapla
        int balance = getBalance(node);

        // Rotasyon durumları
        // Sol-Sol durumu
        if (balance > 1 && getBalance(node.left) >= 0) {
            return rotateRight(node);
        }

        // Sol-Sağ durumu
        if (balance > 1 && getBalance(node.left) < 0) {
            node.left = rotateLeft(node.left);
            return rotateRight(node);
        }

        // Sağ-Sağ durumu
        if (balance < -1 && getBalance(node.right) <= 0) {
            return rotateLeft(node);
        }

        // Sağ-Sol durumu
        if (balance < -1 && getBalance(node.right) > 0) {
            node.right = rotateRight(node.right);
            return rotateLeft(node);
        }

        return node;
    }

    // Rotasyon işlemleri
    private Node rotateRight(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        x.right = y;
        y.left = T2;

        y.height = 1 + Math.max(height(y.left), height(y.right));
        x.height = 1 + Math.max(height(x.left), height(x.right));

        return x;
    }

    private Node rotateLeft(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        y.left = x;
        x.right = T2;

        x.height = 1 + Math.max(height(x.left), height(x.right));
        y.height = 1 + Math.max(height(y.left), height(y.right));

        return y;
    }

    // Yardımcı metotlar
    private int height(Node node) {
        return node == null ? 0 : node.height;
    }

    private int getBalance(Node node) {
        return node == null ? 0 : height(node.left) - height(node.right);
    }

    private Node findMin(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    // İn-order dolaşma
    void inOrder() {
        inOrderRec(root);
        System.out.println();
    }

    private void inOrderRec(Node node) {
        if (node != null) {
            inOrderRec(node.left);
            System.out.print(node.value + " ");
            inOrderRec(node.right);
        }
    }
}
