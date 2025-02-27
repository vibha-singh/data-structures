package main.practice2024.btree;

import java.util.ArrayList;
import java.util.List;

public class BST {
    public static void main(String[] args) {
        TreeNode tree = new TreeNode(10);
        tree.left = new TreeNode(20);
        tree.right = new TreeNode(25);
        tree.left.left = new TreeNode(30);
        tree.left.right = new TreeNode(40);
        tree.left.right.left = new TreeNode(42);

        tree.right.left = new TreeNode(35);
        tree.right.right = new TreeNode(33);
        tree.right.right.right = new TreeNode(46);

        System.out.println(maxDepth(tree));
        ArrayList<Integer> res = new ArrayList<>();
        preOrder(tree, res);
        System.out.println(res);

        ArrayList<Integer> res1 = new ArrayList<>();
        inOrder(tree, res1);
        System.out.println(res1);

        ArrayList<Integer> res2 = new ArrayList<>();
        postOrder(tree, res2);
        System.out.println(res2);

    }

    public static int maxDepth (TreeNode root) {
        if(root == null) return 0;
        int left =  maxDepth(root.left);
        int right = maxDepth(root.right);
        return  Math.max(left,right)+1;
    }

    public static void  preOrder(TreeNode root, List<Integer> ans) {
        if (root == null) return ;
        ans.add(root.data);
        preOrder(root.left, ans);
        preOrder(root.right, ans);
    }

    public static void  inOrder(TreeNode root, List<Integer> ans) {
        if (root == null) return ;
        inOrder(root.left, ans);
        ans.add(root.data);
        inOrder(root.right, ans);
    }

    public static void  postOrder(TreeNode root, List<Integer> ans) {
        if (root == null) return ;

        postOrder(root.left, ans);
        postOrder(root.right, ans);
        ans.add(root.data);
    }
}

class TreeNode {
    TreeNode left;
    TreeNode right;
    int data;

    public TreeNode(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Node{" +
                "left=" + left +
                ", right=" + right +
                ", data=" + data +
                '}';
    }
}
