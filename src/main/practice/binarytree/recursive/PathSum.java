package main.practice.binarytree.recursive;

public class PathSum {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(15);
        root.right = new TreeNode(12);
        root.left.left = new TreeNode(16);
        root.left.right = new TreeNode(13);
        root.left.right.left = new TreeNode(4);

        root.right.right = new TreeNode(12);
        root.right.right.right = new TreeNode(19);
        int target = 52;
        System.out.println(isSumPath(root, target, 0));
    }

    private static boolean isSumPath(TreeNode root, int target, int currSum) {
        if(root == null) return false;
        if(root.left == null && root.right == null) {
            return currSum+ root.data == target;
        }

         return isSumPath(root.left, target,currSum+root.data) || isSumPath(root.right, target, currSum+ root.data);
    }
}
