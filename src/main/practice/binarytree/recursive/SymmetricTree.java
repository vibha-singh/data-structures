package main.practice.binarytree.recursive;

public class SymmetricTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(1);

        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(5);

        root.left.right = new TreeNode(4);

        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);
        root.right.right.right = new TreeNode(5);

        System.out.println(isSymmetricTree (root.left, root.right));
    }

    private static boolean isSymmetricTree (TreeNode left,TreeNode right) {
        if( (left == null && right == null)) return true;
        if(left == null || right == null || left.data != right.data) return false;
        return isSymmetricTree (left.left, right.right) && isSymmetricTree (left.right, right.left);
    }
}
