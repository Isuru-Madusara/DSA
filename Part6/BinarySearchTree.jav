class BSTNode {
    int data;
    BSTNode left, right;

    BSTNode(int value) {
        data = value;
        left = right = null;
    }
}

public class BinarySearchTree {
    BSTNode root;

    void insert(int value) {
        root = insertRec(root, value);
    }

    BSTNode insertRec(BSTNode root, int value) {
        if (root == null) {
            root = new BSTNode(value);
            return root;
        }

        if (value < root.data)
            root.left = insertRec(root.left, value);
        else if (value > root.data)
            root.right = insertRec(root.right, value);

        return root;
    }

    void inorder() {
        inorderRec(root);
    }

    void inorderRec(BSTNode root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.data + " ");
            inorderRec(root.right);
        }
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        bst.insert(50);
        bst.insert(30);
        bst.insert(20);
        bst.insert(40);
        bst.insert(70);
        bst.insert(60);
        bst.insert(80);

        System.out.println("Inorder traversal:");
        bst.inorder();
    }
}
