package main.t2025.graph.undirectedGraph.unionFind;

import java.util.Arrays;

/**
 * In this problem, a tree is an undirected graph that is connected and has no cycles.
 * You are given a graph that started as a tree with n nodes labeled from 1 to n, with one additional edge added. The added edge has two different vertices chosen from 1 to n, and was not an edge that already existed. The graph is represented as an array edges of length n where edges[i] = [ai, bi] indicates that there is an edge between nodes ai and bi in the graph.
 * Return an edge that can be removed so that the resulting graph is a tree of n nodes. If there are multiple answers, return the answer that occurs last in the input.
 *
 * Input: edges = [[1,2],[1,3],[2,3]]
 * Output: [2,3]
 *
 * Input: edges = [[1,2],[2,3],[3,4],[1,4],[1,5]]
 * Output: [1,4]
 */
public class B_RedundantConnection {
    static int[] parent;
    static int[] rank;
    public static void main(String[] args) {
        int[][] edges = {{1,2},{1,3},{2,3}};
        int n = 3;
        parent = new int[n+1];
        rank = new int[n+1];
        Arrays.fill(rank, 0);
        for(int i = 0; i<n; i++) {
            parent[i] = i;
        }

        for(int i = 0; i<n; i++) {
            int x = edges[i][0];
            int y = edges[i][1];
            if(!union(x,y)) {
                System.out.println(x+","+y);
                break;
            }
        }
    }

    private static int find(int x) {
        if(parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    private static boolean union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if(rootX == rootY) // Cycle detected
            return false;
        if(rank[rootX] < rank[rootY]) {
            parent[rootX] = rootY;
        } else if(rank[rootY] < rank[rootX]) {
            parent[rootY] = rootX;
        } else {
            parent[rootX] = rootY;
            rank[rootY]++;
        }
        return true;
    }

}
