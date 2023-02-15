package main.practice.binarytree.recursive;

public class InvertBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(4);
        root.right = new TreeNode(5);

        root.left.left = new TreeNode(7);
        root.left.right = new TreeNode(8);

        root.right.right = new TreeNode(9);
        root.right.right.left = new TreeNode(11);
        inOrder(root);

        TreeNode invertedTreeRoot = invertBinaryTree(root);
        System.out.println();
        inOrder(invertedTreeRoot);

    }

    private static TreeNode invertBinaryTree(TreeNode root) {
        if(root == null) return root;
        TreeNode left = invertBinaryTree(root.right);
        TreeNode right = invertBinaryTree(root.left);

        root.left = left;
        root.right = right;
        return root;
    }

    public static void inOrder(TreeNode root) {
        if(root == null) return;
        inOrder(root.left);
        System.out.print(root.data +" ");
        inOrder(root.right);
    }
}
