package main.practice.binarytree.recursive;

public class MaxDepthOfBinaryTree {

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
        System.out.println(maxDepthOfBST(root));

    }

    /**
     * Recursive
     * @param root
     * @return
     */
    private static int maxDepthOfBST(TreeNode root) {
        if(root == null) return 0;

        int leftDepth  = 1+ maxDepthOfBST(root.left) ;
        int rightDepth = 1+ maxDepthOfBST(root.right);
        return Math.max(leftDepth, rightDepth);
    }

    private static int maxDepthOfBST(TreeNode root, int depth) {
        if(root == null) return 0;

        int leftDepth  = 1+ maxDepthOfBST(root.left) ;
        int rightDepth = 1+ maxDepthOfBST(root.right);
        return Math.max(leftDepth, rightDepth);
    }

}

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    public TreeNode(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "data=" + data +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
