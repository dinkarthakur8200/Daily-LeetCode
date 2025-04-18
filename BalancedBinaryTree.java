package BalancedBinaryTree;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class BalancedBinaryTree {

    public boolean isBalanced(TreeNode root) {
        return checkHeight(root) != -1;
    }

    private int checkHeight(TreeNode node) {
        if (node == null)
            return 0;

        int leftHeight = checkHeight(node.left);
        if (leftHeight == -1)
            return -1;

        int rightHeight = checkHeight(node.right);
        if (rightHeight == -1)
            return -1;

        if (Math.abs(leftHeight - rightHeight) > 1)
            return -1;

        return Math.max(leftHeight, rightHeight) + 1;
    }

    // 🔸 For testing purposes
    public static void main(String[] args) {
        // Example 1: Balanced tree
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(9);
        root1.right = new TreeNode(20);
        root1.right.left = new TreeNode(15);
        root1.right.right = new TreeNode(7);

        // Example 2: Unbalanced tree
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(2);
        root2.left.left = new TreeNode(3);
        root2.left.right = new TreeNode(3);
        root2.left.left.left = new TreeNode(4);
        root2.left.left.right = new TreeNode(4);

        // Example 3: Empty tree
        TreeNode root3 = null;

        BalancedBinaryTree tree = new BalancedBinaryTree();

        System.out.println("Tree 1 is balanced: " + tree.isBalanced(root1)); // true
        System.out.println("Tree 2 is balanced: " + tree.isBalanced(root2)); // false
        System.out.println("Tree 3 is balanced: " + tree.isBalanced(root3)); // true
    }
}
