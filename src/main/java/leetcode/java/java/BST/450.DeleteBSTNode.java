package leetcode.java.BST;

import leetcode.java.BST.TreeNode;

class DeleteBSTNode {
    TreeNode deleteNode(TreeNode root, int val){
        if(root == null) return  null;
        if(val  > root.val){
            root.right = deleteNode(root.right, val);
        } else if(val < root.val){
            root.left = deleteNode(root.left, val);
        } else {
            if(root.left == null && root.right == null) return null;
            if(root.left == null) return root.right;
            if(root.right == null) return root.left;
            int value = inOrder(root.right);
            root.val = value;
            root.right = deleteNode( root.right,value);
        }
        return root;

    }
    int inOrder(TreeNode root){
        while(root != null && root.left != null){
            root = root.left;
        }
        return root.val;
    }
}
