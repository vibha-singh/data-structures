package main.practice.binarytree.recursive;

public class CousinsOfBT {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(4);
        root.right = new TreeNode(5);

        root.right.right = new TreeNode(8);
        root.left.left = new TreeNode(7);
        root.left.right = new TreeNode(9);
        root.left.right.left = new TreeNode(11);
        System.out.println(cousinsOfABinaryTree(root, root.left.right,root.right.right));
    }

    /**
     * 1) Two nodes should be on the same level
     * 2) Two Nodes should not be siblings that they should not have same parent
     * @param root
     */
    private static boolean cousinsOfABinaryTree(TreeNode root, TreeNode a, TreeNode b) {
        return (level(root, a,1) == level(root,b,1) && !(isSibling(root, a, b) ));
    }

    static boolean isSibling(TreeNode root, TreeNode a, TreeNode b) {
        if(root == null) return false;
        return ((root.left == a && root.right == b)
        || (root.left == b && root.right == a)
        || isSibling(root.left, a, b)
        || isSibling(root.right, a, b));
    }

    static int level(TreeNode root, TreeNode ptr, int level) {
        if(root == null)
            return 0;
        if(root == ptr)
            return level;
        int l = level(root.left, ptr, level+1);
        if(l != 0)
            return l;
        return level(root.right, ptr, level+1);
    }


}
