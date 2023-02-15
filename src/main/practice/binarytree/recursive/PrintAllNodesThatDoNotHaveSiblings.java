package main.practice.binarytree.recursive;

public class PrintAllNodesThatDoNotHaveSiblings {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(4);
        root.right = new TreeNode(9);
        root.left.left = new TreeNode(8);

        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(11);

        printAllNodesThatDoNotHaveSiblings(root);
    }

    private static void printAllNodesThatDoNotHaveSiblings(TreeNode root) {
        if(root == null) return;

        if(root.left != null && root.right != null) {
            printAllNodesThatDoNotHaveSiblings(root.left);
            printAllNodesThatDoNotHaveSiblings(root.right);
        } else if(root.right != null) {
            System.out.print(root.right.data+" ");
            printAllNodesThatDoNotHaveSiblings(root.right);
        } else if (root.left != null) {
            System.out.print(root.left.data+" ");
            printAllNodesThatDoNotHaveSiblings(root.left);
        }

    }
}
