package leetcode.java.BST;

class InsertNodeBST {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode temp = new TreeNode(val);
        TreeNode curr = root;
        TreeNode parent = null;
        if(root == null) return temp;
        while(curr != null){
            parent = curr;
            if(val < curr.val){
                curr = curr.left;
            } else if(val > curr.val){
                curr = curr.right;
            } else{
                return root;
            }
        }

        if( parent == null){
            return temp;
        } else if(val > parent.val){
            parent.right = temp;
        } else {
            parent.left = temp;
        }

        return root;

    }
}
