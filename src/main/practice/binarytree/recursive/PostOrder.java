package main.practice.binarytree.recursive;

public class PostOrder {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(20);
        root.right = new TreeNode(25);

        root.left.left = new TreeNode(30);
        root.left.right = new TreeNode(40);
        root.left.right.left = new TreeNode(42);

        root.right.left = new TreeNode(35);
        root.right.right = new TreeNode(33);
        root.right.right.right = new TreeNode(46);
        postOrder(root);
    }

    private static void postOrder(TreeNode root) {
        if(root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data +" ");
    }
}
