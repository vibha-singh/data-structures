package main.leetcode.java.java;

import java.util.ArrayList;
import java.util.List;

/**
 *Given the root of a binary tree, return the inorder traversal of its nodes' values.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [1,null,2,3]
 * Output: [1,3,2]
 * Example 2:
 *
 * Input: root = []
 * Output: []
 * Example 3:
 *
 * Input: root = [1]
 * Output: [1]
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [0, 100].
 * -100 <= Node.val <= 100
 *
 * **/

class BinaryTreeInorderTraversal{
    List<Integer> lists = new ArrayList();
    List<Integer> inorderTraversal(TreeNode root){
        if(root == null) return new ArrayList();
        inorderTraversal(root.left);
        lists.add(root.val);
        inorderTraversal(root.right);
        return lists;
    }
}


 //Definition for a binary tree node.
// class TreeNode {
//     int val;
//      TreeNode left;
//      TreeNode right;
//      TreeNode() {}
//      TreeNode(int val) { this.val = val; }
//      TreeNode(int val, TreeNode left, TreeNode right) {
//          this.val = val;
//          this.left = left;
//          this.right = right;
//      }
// }
