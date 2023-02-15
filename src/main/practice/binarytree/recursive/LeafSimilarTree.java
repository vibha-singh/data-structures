package main.practice.binarytree.recursive;

import java.util.ArrayList;

public class LeafSimilarTree {
    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(5);
        root1.left.left = new TreeNode(6);
        root1.left.right = new TreeNode(2);
        root1.left.right.left = new TreeNode(7);
        root1.left.right.right = new TreeNode(4);
        root1.right = new TreeNode(1);
        root1.right.left = new TreeNode(9);
        root1.right.right = new TreeNode(8);

        TreeNode root2 = new TreeNode(3);
        root2.left = new TreeNode(5);
        root2.right = new TreeNode(1);
        root2.left.left = new TreeNode(6);
        root2.left.right = new TreeNode(7);
        root2.right.left = new TreeNode(4);
        root2.right.right = new TreeNode(2);
        root2.right.right.left = new TreeNode(9);
        root2.right.right.right = new TreeNode(8);

        ArrayList<Integer> leaf1 = new ArrayList<>();
        ArrayList<Integer> leaf2 = new ArrayList<>();
        leafNodes(root1, leaf1);
        leafNodes(root2, leaf2);
        boolean isLeafSame = false;
        if(leaf1.size() == leaf2.size()){
            int i;
            for( i = 0; i<leaf1.size(); i++) {
                if(!leaf1.get(i).equals(leaf2.get(i))){
                    break;
                }
            }
            isLeafSame = i == leaf1.size();
        }
        System.out.println(isLeafSame);


    }

    private static void leafNodes(TreeNode root, ArrayList<Integer> arrayList) {
        if(root == null) return;
        if(root.left == null && root.right == null) arrayList.add(root.data);
        if(root.left != null)
            leafNodes(root.left, arrayList);
        if(root.right != null)
            leafNodes(root.right, arrayList );

    }
}
