package main.practice.binarytree.recursive;

public class MergeTwoBinaryTrees {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(4);
        root.right = new TreeNode(7);

        root.left.left = new TreeNode(8);
        root.left.right = new TreeNode(11);

        root.right.right = new TreeNode(13);
        root.right.right.left = new TreeNode(9);

        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(10);
        root1.right = new TreeNode(1);

        root1.left.left = new TreeNode(4);

        root1.right.left = new TreeNode(2);
        root1.right.right = new TreeNode(6);
        root1.right.right.right = new TreeNode(7);

        TreeNode mergedRoot = mergeTwoBinary(root, root1);
        preOrder(mergedRoot);

    }

    private static TreeNode mergeTwoBinary(TreeNode root, TreeNode root1) {
        if(root ==  null && root1 == null) return root;
        if(root == null) return root1;
        if(root1 == null ) return root;

        TreeNode newNode = new TreeNode(root.data + root1.data);
        newNode.left = mergeTwoBinary(root.left, root1.left);
        newNode.right = mergeTwoBinary(root.right, root1.right);

        return newNode;
    }

    private static void preOrder(TreeNode root) {
        if(root == null) return;
        System.out.print(root.data +" ");
        preOrder(root.left);
        preOrder(root.right);
    }
}
