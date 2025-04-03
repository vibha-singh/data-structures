package main.t2025.graph.undirectedGraph.unionFind;

import java.util.Arrays;

/**
 * There are n cities. Some of them are connected, while some are not. If city a is connected directly with city b, and city b is connected directly with city c, then city a is connected indirectly with city c.
 * A province is a group of directly or indirectly connected cities and no other cities outside of the group.
 * You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and the jth city are directly connected, and isConnected[i][j] = 0 otherwise.
 * Return the total number of provinces.
 *
 * Input: isConnected = [[1,1,0],[1,1,0],[0,0,1]]
 * Output: 2
 */
public class A_NumberOfProvinces {
    static int[] parent;
    static int[] rank;
    public static void main(String[] args) {
        int[][] cities = {{1,1,0},{1,1,0},{0,0,1}};
        int n = 3;
        parent = new int[n];
        rank = new int[n];
        Arrays.fill(rank, 0);
        for(int i = 0; i<n; i++) {
            parent[i] = i;
        }
        for(int i = 0; i<n;i++) {
            for(int j = 0; j<n; j++) {
                if(cities[i][j] == 1)
                    union(i,j);
            }
        }

        int province = 0;
        for(int i = 0; i<n; i++) {
            if(find(i) == i) province++;
        }
        System.out.println(province);
    }

    /**
     * Traverses up the tree to find the root of the subset.
     * @param x
     * @return
     */
    private static int find(int x) {
        if(parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    /**
     * Merges two trees by attaching the root of one tree to the root of the other.
     * @param x
     * @param y
     */
    private static void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if(rank[rootX] < rank[rootY]){
            parent[rootX] = rootY;
        } else if (rank[rootY] < rank[rootX]) {
            parent[rootY] = rootX;
        } else {
            parent[rootY] = rootX;
            rank[rootX]++;
        }
    }

}
