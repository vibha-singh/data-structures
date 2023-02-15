package main.practice.binarytree.recursive;

public class LowestCommonAncestorBT {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(4);
        root.right = new TreeNode(7);

        root.left.left = new TreeNode(8);
        root.left.right = new TreeNode(9);
        root.left.right.left = new TreeNode(13);

        root.right.right = new TreeNode(15);
        root.right.right.left = new TreeNode(16);

        System.out.println(lowestCommonAncestor(root, 8, 9).data);
    }

    /**
     * for every node check if it matches n1 or n2. if found return node else
     *   call recursively in both branches. If both return non null value then root is LCA else non null node is LCA
     * @param root
     * @param p
     * @param q
     * @return
     */
    private static TreeNode lowestCommonAncestor(TreeNode root, int p, int q) {
        if(root == null) return null;
        if(root.data == p || root.data == q) return root;
        TreeNode leftSubTree = lowestCommonAncestor(root.left, p, q);
        TreeNode rightSubTree = lowestCommonAncestor(root.right, p, q);
        if (leftSubTree != null && rightSubTree != null) return root;
        return leftSubTree!= null ? leftSubTree : rightSubTree;

    }
}
