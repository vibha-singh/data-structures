package main.practice.binarytree.recursive;

public class UnivaluedBT {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(1);
        root.right = new TreeNode(1);;
        root.left.right = new TreeNode(1);;
        root.left.left = new TreeNode(1);

        root.right.right = new TreeNode(1);;
        System.out.println(isUnivaluedTree(root, root.data));

        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(1);
        root1.right = new TreeNode(1);;
        root1.left.right = new TreeNode(4);;
        root1.left.left = new TreeNode(1);

        root1.right.right = new TreeNode(1);;
        System.out.println(isUnivaluedTree(root1, root1.data));
    }

    private static boolean isUnivaluedTree(TreeNode root, int data) {
        if(root == null) return true;
        if(root.data != data) return false;
        return isUnivaluedTree(root.left, data) && isUnivaluedTree(root.right, data);
    }
}
