package main.practice.binarytree.recursive;

public class RightViewOfABinaryTree {
    static int maxLevel = 0;
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(9);
        root.right = new TreeNode(10);

        root.left.right = new TreeNode(12);

        root.right.left = new TreeNode(11);
        root.right.left.left = new TreeNode(13);
        leftView(root, 1);
    }

    private static void leftView(TreeNode root, int currLevel) {
        if(root == null) return;
        if(maxLevel < currLevel) {
            System.out.print(root.data+" ");
            maxLevel = currLevel;
        }
        leftView(root.right, currLevel+1);
        leftView(root.left, currLevel+1);

    }
}
