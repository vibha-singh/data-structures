package main.leetcode.java.java.BST;

class ValidBST {

    boolean isValidBST(TreeNode root){
       return isBST(root, null, null);
    }

    boolean isBST(TreeNode root, TreeNode left, TreeNode right){
        if(root == null) return  true;
        if(left != null && root.val <= left.val) return false;
        if(right != null && root.val >= right.val) return false;

        return isBST(root.left, left, root) && isBST(root.right, root, right);
    }


}

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
