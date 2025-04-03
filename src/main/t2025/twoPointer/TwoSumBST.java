package main.t2025.twoPointer;

import java.util.HashSet;
import java.util.Set;

/**
 * Given the root of a binary search tree and an integer k, return true if there exist two elements in the BST such that their sum is equal to k, or false otherwise.
 * Example 1:
 * Input: root = [5,3,6,2,4,null,7], k = 9
 * Output: true
 */
public class TwoSumBST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);

        root.right.right= new TreeNode(7);

        int k = 9;
        System.out.println(findTarget(root, k));

    }

    private static Set<Integer> res = new HashSet<>();
    public static boolean findTarget(TreeNode root, int k) {
        if(root == null || (root.left == null && root.right == null)) return false;
        if( res.contains(k - root.val)) return true;

        res.add(root.val);
        return findTarget(root.left, k) || findTarget(root.right, k);



    }
}
class TreeNode {
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
