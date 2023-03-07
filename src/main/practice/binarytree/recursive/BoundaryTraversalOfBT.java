package main.practice.binarytree.recursive;

import java.util.ArrayList;

/**
 * 1) if root not null add root data in array
 * 2) traverse left of root left
 * 3) traverse leaf of root left
 * 4) traverse leaf og root right
 * 5) traverse right of root right;
 */
public class BoundaryTraversalOfBT {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(20);
        root.right = new TreeNode(25);
        root.left.left = new TreeNode(30);
        root.left.right = new TreeNode(40);
        root.left.right.left = new TreeNode(42);

        root.right.left = new TreeNode(35);
        root.right.right = new TreeNode(33);
        root.right.right.right = new TreeNode(46);

        System.out.println(boundary(root));
    }

    static ArrayList <Integer> boundary(TreeNode node)
    {
        ArrayList<Integer> res = new ArrayList<>();
        if(node == null) return res;
        //1) if root not null add root data in array
        res.add(node.data);
        //2) traverse left of root left
        traverseLeft(node.left, res);
        //3) traverse leaf of root left
        traverseLeaf(node.left, res);
        //4) traverse leaf og root right
        traverseLeaf(node.right, res);

        //5) traverse right of root right;
        traverseRight(node.right, res);

        return res;
    }

    static void traverseLeft(TreeNode root, ArrayList<Integer> res) {
        if((root == null) ||( root.left == null && root.right == null)) return;
        res.add(root.data);
        if(root.left != null ) traverseLeft(root.left, res);
        else traverseLeft(root.right, res);
    }

    static void traverseRight(TreeNode root, ArrayList<Integer> res) {
        if((root == null) || (root.left == null && root.right == null)) return;

        if(root.right != null) traverseRight(root.right, res);
        else traverseRight(root.left, res);
        res.add(root.data);
    }

    static void traverseLeaf(TreeNode root, ArrayList<Integer> res) {
        if(root == null) return;

        if(root.left == null && root.right == null) {
            res.add(root.data);
            return;
        }

        traverseLeaf(root.left, res);
        traverseLeaf(root.right, res);
    }
}
