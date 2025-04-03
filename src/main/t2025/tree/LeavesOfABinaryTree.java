package main.t2025.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class LeavesOfABinaryTree {
    public static void main(String[] args) {

        Node tree = new Node(1);
        tree.left = new Node(2);
        tree.right = new Node(3);
        tree.left.left = new Node(4);

        tree.right.left = new Node(5);
        tree.right.right = new Node(8);
        tree.right.left.left = new Node(6);
        tree.right.left.right = new Node(7);

        tree.right.right.left = new Node(9);
        tree.right.right.right = new Node(10);

        List<Integer> leafNodes = new ArrayList<>();

        getAllLeafNodes(tree, leafNodes);
        System.out.println(leafNodes);

    }

    private static void getAllLeafNodes(Node tree, List<Integer> leafNodes) {
        if(tree == null) return;
        if(tree.left == null && tree.right == null) {
            leafNodes.add(tree.val);
        }
        if(tree.left != null)  getAllLeafNodes(tree.left, leafNodes);
        if(tree.right != null)  getAllLeafNodes(tree.right, leafNodes);
    }
}

class Node {
    Node left;
    Node right;
    int val ;
    public Node(int val) {
        this.val = val;
    }
}
