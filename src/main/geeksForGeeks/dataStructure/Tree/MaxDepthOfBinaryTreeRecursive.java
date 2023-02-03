package main.geeksForGeeks.dataStructure.Tree;

public class MaxDepthOfBinaryTreeRecursive {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(20);
        root.left.left = new TreeNode(30);
        root.left.right = new TreeNode(40);
        root.left.right.left = new TreeNode(42);

        root.right = new TreeNode(25);
        root.right.left = new TreeNode(35);
        root.right.right = new TreeNode(33);
        root.right.right = new TreeNode(46);

        System.out.println(root.maxDepthOfBinaryTree(root));
    }
}

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    public TreeNode(int data) {
        this.data = data;
        left = null;
        right = null;
    }

    static int  maxDepthOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        int left = maxDepthOfBinaryTree(root.left);
        int right = maxDepthOfBinaryTree(root.right);

        return Math.max(left, right)+1;

    }



}
