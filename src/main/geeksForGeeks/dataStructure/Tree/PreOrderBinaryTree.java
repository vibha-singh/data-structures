package main.geeksForGeeks.dataStructure.Tree;

import main.leetcode.java.java.util.TreeNode;

import java.util.Stack;

public class PreOrderBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(8);
        root.left.right = new TreeNode(9);
        root.left.right.left = new TreeNode(11);

        root.right = new TreeNode(7);
        root.right.right = new TreeNode(13);
        root.right.right.left = new TreeNode(10);
        //preOrderTraversalRecursive(root);
        iterativePreOrder(root);
    }

    static void preOrderTraversalRecursive (TreeNode root) {
        if(root == null) return;

        System.out.print(root.data+" ->");
        preOrderTraversalRecursive(root.left);
        preOrderTraversalRecursive(root.right);
    }

    static void iterativePreOrder(TreeNode root) {
        if(root == null) return;
        Stack<TreeNode> s = new Stack<>();
        s.add(root);

        while (!s.isEmpty()){
            TreeNode curr = s.pop();
            System.out.print(curr.data + "->");
            if(curr.right != null) s.push(curr.right);
            if(curr.left != null) s.push(curr.left);
        }
    }
}