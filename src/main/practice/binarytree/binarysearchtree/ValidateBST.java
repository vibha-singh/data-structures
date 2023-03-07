package main.practice.binarytree.binarysearchtree;

public class ValidateBST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(6);
        System.out.println(isValidBST(root, Integer.MIN_VALUE));
    }

    /**
     * Every value should be less than previous in inOrder traversal
     * @param root
     * @param prev
     * @return
     */
    private static boolean isValidBST(TreeNode root, int prev) {
        if(root == null) return true;
        boolean isleftBalanced  = isValidBST(root.left, prev);
        if(root.data <= prev) return false;
        prev = root.data;
        boolean isRightBalanced = isValidBST(root.right, prev);
        return isleftBalanced && isRightBalanced;
    }
}
