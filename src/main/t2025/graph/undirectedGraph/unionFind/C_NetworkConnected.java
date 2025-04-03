package main.t2025.graph.undirectedGraph.unionFind;

/**
 * There are n computers numbered from 0 to n - 1 connected by ethernet cables connections forming a network where connections[i] = [ai, bi] represents a connection between computers ai and bi. Any computer can reach any other computer directly or indirectly through the network.
 * You are given an initial computer network connections. You can extract certain cables between two directly connected computers, and place them between any pair of disconnected computers to make them directly connected.
 * Return the minimum number of times you need to do this in order to make all the computers connected. If it is not possible, return -1.
 */
public class C_NetworkConnected {
    static int[] parent;
    static int[] rank;
    public static void main(String[] args) {
       int n = 6;
       int[][]connections = {{0,1},{0,2},{0,3},{1,2},{1,3}};
       for(int i = 0; i<n; i++) {
           parent[i] = i;
       }
       int count = n;
       for(int[] connection: connections) {
           int x = connection[0];
           int y = connection[1];
           int parentX = find(x);
           int parentY = find(y);
           if(parentX != parentY) {
               union(x,y);
               count--;
           }
       }

        System.out.println(count-1);
    }

    private static int find(int x) {
        if(parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    private static void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if(rootX == rootY) return;
        if(rank[rootY] < rank[rootX]) {
            parent[rootY] = rootX;
        } else if (rank[rootX] < rank[rootY]) {
            parent[rootX] = rootY;
        } else {
            parent[rootX] = rootY;
            rank[rootY]++;
        }
    }
}
