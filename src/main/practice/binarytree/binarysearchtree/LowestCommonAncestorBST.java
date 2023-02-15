package main.practice.binarytree.binarysearchtree;



public class LowestCommonAncestorBST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.left.right = new TreeNode(0);
        root.left.left = new TreeNode(4);
        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(5);

        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);

        System.out.println(lcaBST(root, 2,8).data);
    }

    /**
     * TC: O(n)
     * @param root
     * @param p
     * @param q
     * @return
     */
//    private static TreeNode lcaBST(TreeNode root, int p, int q) {
//        if(root == null) return null;
//        if(root.data == p || root.data == q) return root;
//        TreeNode leftSubTree = lcaBST(root.left, p, q);
//        TreeNode rightSubTree = lcaBST(root.right, p, q);
//        if (leftSubTree != null && rightSubTree != null) return root;
//        return leftSubTree!= null ? leftSubTree : rightSubTree;
//    }

    /**
     * TC: logn
     * @param root
     * @param p
     * @param q
     * @return
     */
    private static TreeNode lcaBST(TreeNode root, int p, int q) {
        if(root == null) return null;
        if(root.data > p && root.data > q)
            return lcaBST(root.right, p, q);
        else if(root.data < p && root.data < q)
            return lcaBST(root.left, p, q);
        else return root;
    }
}

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    public TreeNode(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "data=" + data +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
