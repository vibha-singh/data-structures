package main.leetcode.java.java.BST;

class SearchBST {
    public TreeNode searchBST(TreeNode root, int val) {
        if( root == null) return null;

        while(root != null){
            if(root.val == val) return root;
            else if(val < root.val) root = root.left;
            else root = root.right;
        }
        return  null;
    }
}
