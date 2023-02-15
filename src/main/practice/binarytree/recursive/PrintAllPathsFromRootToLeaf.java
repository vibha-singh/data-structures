package main.practice.binarytree.recursive;

import java.util.ArrayList;

public class PrintAllPathsFromRootToLeaf {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(13);
        root.left = new TreeNode(15);
        root.right = new TreeNode(17);

        root.left.left = new TreeNode(19);
        root.left.right = new TreeNode(20);
        root.left.right.right = new TreeNode(25);

        root.right = new TreeNode(17);

        ArrayList<String> pathToLeafNodes = new ArrayList<>();
        findPathToLeafNodes(root, pathToLeafNodes,"");
        System.out.println(pathToLeafNodes);
    }

    private static void findPathToLeafNodes(TreeNode root, ArrayList<String> pathToLeafNodes, String currPath) {
        if(root == null) return;

        if(root.left == null && root.right == null) {
            currPath += root.data;
            pathToLeafNodes.add(currPath);
            return;
        }

        currPath += root.data +"->";
        if(root.left != null) findPathToLeafNodes(root.left, pathToLeafNodes, currPath);
        if(root.right != null) findPathToLeafNodes(root.right, pathToLeafNodes, currPath);
    }
}
