package trees.AVL;

public class AVLNode {
    int height;
    int data;
    AVLNode left;
    AVLNode right;

    public AVLNode(int data, AVLNode left, AVLNode right) {
        this.height = 1;
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public AVLNode(int data) {
        this.height = 1;
        this.data = data;
    }

    public AVLNode() {
    }
}
