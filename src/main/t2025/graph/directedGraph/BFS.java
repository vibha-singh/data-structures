package main.t2025.graph.directedGraph;

import main.t2025.graph.Graph;

import java.util.*;

/**
 * Steps:
 * 1) select node
 * 2) visit in unvisited neighbour nodes
 * 3) mark it as visited and push into result
 * 4) push it into queue
 * 5) if no neighbour then pop
 * 6) repeat till queue is empty
 *
 * TC: O(V+E)
 * SC: O(V)
 */
public class BFS {
    public static void main(String[] args) {
        Graph<Integer> g = new Graph<Integer>(7);
        // First component
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        // Second component
        g.addEdge(4, 5);
        g.addEdge(5, 6);
        g.addEdge(6, 4);


        Set<Integer> visited = new HashSet<>();
        //disconnected as well as connected
        g.bfsIterative( );
        // only connected graph
        g.bfsIterative( 0, visited);

        g.bfsRecursive();

    }



}
