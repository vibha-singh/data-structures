package interview.A_2025.practice.google;

import java.util.*;

/**
 * Given an undirected acyclic connected graph where each node has
 * at most 3 edges, find a node which, when made the root, converts
 * the graph into a binary tree.
 *
 * Follow-up:
 * The nodes are colored Black or White, find a root such that:
 * • The graph becomes a binary tree.
 * • The tree alternates in color across layers (e.g., Depth 0: White,
 * Depth 1: Black, Depth 2: White, etc.).
 * Either White or Black can be the starting color.
 *
 * Follow-up:
 * The nodes are colored Red (R), Blue (B), or White (W), find a
 * root such that:
 * • The graph becomes a binary tree.
 * • The layers of the tree follow a fixed color sequence
 * e.g., RBWRBW… or BWRBWR… or WRBWRB).
 */
public class B_UndirectedAcyclicConnectedGraphToBinaryTree {
    private static boolean isValidBinaryTree(Node root, Set<Node> visited) {
        if (root == null || visited.contains(root)) return true;
        visited.add(root);

        // A node can have at most 2 children in a binary tree
        if (root.neighbors.size() > 3) return false; // 3 edges = 2 children + 1 parent

        int childCount = 0;
        for (Node neighbor : root.neighbors) {
            if (!visited.contains(neighbor)) {
                childCount++;
                if (!isValidBinaryTree(neighbor, visited)) return false;
            }
        }

        return childCount <= 2;
    }

    // Find a root that can form a binary tree
    public static Node findBinaryTreeRoot(Node[] nodes) {
        for (Node node : nodes) {
            Set<Node> visited = new HashSet<>();
            if (isValidBinaryTree(node, visited)) {
                return node;
            }
        }
        return null; // No valid root found
    }

    public static void main(String[] args) {
        // Example usage
        Node node1 = new Node(1, "White");
        Node node2 = new Node(2, "Black");
        Node node3 = new Node(3, "White");
        Node node4 = new Node(4, "Black");

        node1.neighbors.add(node2);
        node2.neighbors.add(node1);
        node2.neighbors.add(node3);
        node3.neighbors.add(node2);
        node3.neighbors.add(node4);
        node4.neighbors.add(node3);

        Node[] nodes = {node1, node2, node3, node4};
        Node root = findBinaryTreeRoot(nodes);
        System.out.println("Valid root: " + (root != null ? root.id : "None"));
    }

    /**
     * Step 2: Follow-Up with Color Alternation
     * For the follow-up problems, we need to ensure that the tree alternates in color across layers. For example:
     *
     * Two Colors (Black and White): Layers alternate between Black and White.
     *
     * Three Colors (Red, Blue, White): Layers follow a fixed sequence like RBWRBW… or BWRBWR… or WRBWRB.
     *
     * Approach:
     * Perform a BFS starting from each node as the root.
     *
     * During BFS, assign colors to layers based on the required sequence.
     *
     * If a node violates the color sequence, discard the current root and try the next one.
     */
    private static boolean isValidColoredBinaryTree(Node root, String startColor) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        Set<Node> visited = new HashSet<>();
        visited.add(root);
        String currentColor = startColor;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                Node node = queue.poll();
                // Check if the node's color matches the expected color for this level
                if (!node.color.equals(currentColor)) return false;

                // Add children to the queue
                for (Node neighbor : node.neighbors) {
                    if (!visited.contains(neighbor)) {
                        visited.add(neighbor);
                        queue.add(neighbor);
                    }
                }
            }
            // Alternate the color for the next level
            currentColor = currentColor.equals("White") ? "Black" : "White";
        }
        return true;
    }

    public static Node findColoredBinaryTreeRoot(Node[] nodes, String startColor) {
        for (Node node : nodes) {
            if (isValidBinaryTree(node, new HashSet<>()) && isValidColoredBinaryTree(node, startColor)) {
                return node;
            }
        }
        return null; // No valid root found
    }
}

class Node {
    int id;
    List<Node> neighbors;
    String color; // For follow-up problems

    Node(int id, String color) {
        this.id = id;
        this.color = color;
        this.neighbors = new ArrayList<>();
    }
}
