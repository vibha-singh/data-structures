package main.practice.binarytree.recursive;

import java.util.ArrayList;

import static main.practice.binarytree.recursive.InvertBinaryTree.inOrder;

public class SortedArrayToBST {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(-10);
        arr.add(-3);
        arr.add(0);
        arr.add(5);
        arr.add(9);

        TreeNode node = toBST(arr, 0, arr.size()-1);
        inOrder(node);
    }

    private static TreeNode toBST(ArrayList<Integer> arr, int start, int end) {
        if(start > end) return null;
        int mid = (start+end) /2;
        TreeNode newNode = new TreeNode(arr.get(mid));
        newNode.left =  toBST(arr, start, mid-1);
        newNode.right = toBST(arr, mid+1, end);
        return newNode;
    }

}
