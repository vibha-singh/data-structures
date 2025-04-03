package main.t2025.graph.directedGraph.dfs;

import java.util.*;
public class B_TopologicalSort {
    public static void main(String[] args) {
        int numNodes = 6;
        int[][] edges = {{5, 2}, {5, 0}, {4, 0}, {4, 1}, {2, 3}, {3, 1}};
        List<Integer> order = topologicalSortDFS(numNodes, edges);
        System.out.println("Topological Order (DFS): " + order);
    }

    private static List<Integer> topologicalSortDFS(int numNodes, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i<numNodes; i++) {
            adj.add(new ArrayList<>());
        }

        for(int [] edge: edges) {
            int from = edge[0];
            int to = edge[1];
            adj.get(from).add(to);
        }
        List<Integer> ans = new ArrayList<>();
        boolean[] visited = new boolean[numNodes];
        for (int i = 0; i< numNodes; i++) {
            if(!visited[i])
                 topologicalSort(i, adj, ans, visited);
        }
        Collections.reverse(ans);
        return ans;
    }

    private static void topologicalSort(int i, List<List<Integer>> adj, List<Integer> ans, boolean[] visited) {
        if(visited[i]) return;
        visited[i] = true;
        for(Integer node: adj.get(i)) {
            topologicalSort(node, adj, ans, visited);
        }
        ans.add(i);
    }
}
