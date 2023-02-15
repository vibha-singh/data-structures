package main.practice.binarytree.recursive;

public class SumOfLeftNodes {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(8);
        root.left.right.right.right = new TreeNode(9);

        root.right.left = new TreeNode(11);

        System.out.println(sumOfLeftLeaves(root, false));
    }

    private static int sumOfLeftLeaves(TreeNode root, boolean isLeaf) {
        if(root ==  null) return 0;
        if(root.left == null && root.right == null && isLeaf) {
            return root.data;
        }
        int ls = sumOfLeftLeaves(root.left, true);
        int rs = sumOfLeftLeaves(root.right, false);
        return ls+rs;
    }
}
