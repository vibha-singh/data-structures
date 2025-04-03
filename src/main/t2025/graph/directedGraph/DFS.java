package main.t2025.graph.directedGraph;

import main.t2025.graph.Graph;

import java.util.*;



public class DFS {
    public static void main(String[] args) {
        Graph<Integer> g = new Graph<Integer>(7);
        // First component
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
//
        // Second component
        g.addEdge(4, 5);
        g.addEdge(5, 6);
        g.addEdge(6, 4);


        Set<Integer> visited = new HashSet<>();
        //disconnected as well as connected
//        g.dfsRecursiveUtil(visited, 2);
        g.dfsIterative();
        System.out.println();
        g.dfsIterativeUtil( visited, 2);


    }
}
