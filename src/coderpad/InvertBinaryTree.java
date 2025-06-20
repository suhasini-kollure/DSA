package coderpad;

/*To invert a binary tree, we swap the left and right subtrees of every node in the tree.
This is also known as mirroring the binary tree.
Before Invert:
            4
          /   \
         2     7
        / \   / \
       1   3 6   9
After Invert:
          4
        /   \
       7     2
      / \   / \
     9   6 3   1
*/
class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class InvertBinaryTree {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;

        // Swap the left and right child
        TreeNode temp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(temp);

        return root;
    }

    // Helper: In-order traversal to print the tree
    public void printInOrder(TreeNode root) {
        if (root != null) {
            printInOrder(root.left);
            System.out.print(root.val + " ");
            printInOrder(root.right);
        }
    }

    public static void main(String[] args) {
        InvertBinaryTree tree = new InvertBinaryTree();

        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

        System.out.print("Original Tree (In-order): ");
        tree.printInOrder(root);

        tree.invertTree(root);

        System.out.print("\nInverted Tree (In-order): ");
        tree.printInOrder(root);
    }
}

