package main.t2025.graph.directedGraph.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class A_HasCycleKahnsAlgo {
    public static void main(String[] args) {
        int[][] prerequisites = {{0, 1}, {1, 2}, {2, 3}, {3, 1}};
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i<prerequisites.length ; i++) {
            adj.add(new ArrayList<>());
        }

        int[] indegree = new int[prerequisites.length];
        for(int[] pre: prerequisites ) {
            int from = pre[0];
            int to = pre[1];
            adj.get(from).add(to);
            indegree[to]++;
        }
        // Step 2: Initialize the queue with nodes having in-degree 0
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < adj.size(); i++) {
            if (indegree[i] == 0) queue.offer(i);
        }

        // Step 3: Perform BFS (Kahn's Algorithm)
        int count = 0; // Count of nodes processed
        while (!queue.isEmpty()) {
            int node = queue.poll();
            count++;
            for (int neighbor : adj.get(node)) {
                if (--indegree[neighbor] == 0) queue.offer(neighbor);
            }
        }

        // Step 4: If count != numNodes, a cycle exists
        System.out.println(count != prerequisites.length);
    }
}
