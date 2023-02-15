package main.practice.binarytree.binarysearchtree;

public class SearchInBST {
    public static void main(String[] args) {
        TreeNode node  = new TreeNode(4);
        node.left = new TreeNode(2);
        node.right = new TreeNode(7);
        node.left.right = new TreeNode(3);
        node.left.left = new TreeNode(1);
        System.out.println(search(node, 2
        ));
    }
    public static TreeNode search(TreeNode root, int val) {
        if(root == null) return null;
        if(root.data == val) return root;
        return root.data <val ? search(root.right,val) : search(root.left, val);
    }
}


