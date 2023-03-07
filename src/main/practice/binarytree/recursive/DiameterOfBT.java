package main.practice.binarytree.recursive;

public class DiameterOfBT {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(4);
        root.right = new TreeNode(5);

        root.left.left = new TreeNode(7);
        root.left.right = new TreeNode(8);

        root.right.right = new TreeNode(9);
        root.right.right.left = new TreeNode(11);

        System.out.println(diameterOfTree(root));
    }

    private static int diameterOfTree(TreeNode root) {
        if(root == null) return 0;
        int ld = diameterOfTree(root.left);
        int rd = diameterOfTree(root.right);
        int h = heightOfTree(root.left) +heightOfTree(root.right) +1;
        return Math.max(h, Math.max(ld,rd));
    }


    private static int heightOfTree(TreeNode root) {
        if(root == null) return 0;
        return Math.max(heightOfTree(root.left), heightOfTree(root.right)) +1;
    }
}
