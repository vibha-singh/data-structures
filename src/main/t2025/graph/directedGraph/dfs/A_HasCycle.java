package main.t2025.graph.directedGraph.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * DFS Cycle Detection:
 * A visited array tracks all visited nodes.
 * A recStack array tracks nodes in the current recursion stack.
 * If a node is encountered that is already in the recursion stack, a cycle is detected.
 */
public class A_HasCycle {
    public static void main(String[] args) {

        int[][] prerequisites = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
       // int[][] prerequisites = {{0, 1}, {1, 2}, {2, 3}, {3, 1}};
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i<prerequisites.length ; i++) {
            adj.add(new ArrayList<>());
        }

        for(int[] pre: prerequisites ) {
            int from = pre[0];
            int to = pre[1];
            adj.get(from).add(to);
        }
        System.out.println(hasCycle(adj));

    }
    private static boolean hasCycle(List<List<Integer>> adj) {
        boolean[] visited = new boolean[adj.size()];
        boolean[] recStack = new boolean[adj.size()];
        for(int i = 0; i < adj.size(); i++) {
            if(!visited[i] && hasCycle(adj, i, recStack, visited))
                return true;
        }
        return false;
    }

    private static boolean hasCycle(List<List<Integer>> adj, int ci, boolean[] recStack, boolean[] visited) {
        if(recStack[ci]) return true; // cycle detected
        if(visited[ci]) return false;

        visited[ci] = true;
        recStack[ci] = true;
        for(Integer neighbour: adj.get(ci)) {
            if(hasCycle(adj, neighbour, recStack, visited)) return true;
        }

        recStack[ci] = false; //backtrack
        return false;
    }
}
