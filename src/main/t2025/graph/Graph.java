package main.t2025.graph;

import java.util.*;

public class Graph<T> {

    private Map<T, List<T>> adj;

    public Graph(int V) {
      this.adj = new HashMap<>();
    }

    public void addEdge(T s, T d) {
        if(!adj.containsKey(s))
            adj.put(s, new ArrayList<>());
        if(!adj.containsKey(d))
            adj.put(d, new ArrayList<>());
        adj.get(s).add(d);
    }

    public void bfsIterative(T source, Set<T> visited) {
        Queue<T> queue = new LinkedList<>();
        visited.add(source);
        queue.add(source);

        while (!queue.isEmpty()) {
            T curr = queue.poll();
            System.out.print(curr +", ");
            for (T c: adj.get(curr)) {
                if(!visited.contains(c)) {
                    queue.add(c);
                    visited.add(c);
                }
            }
        }
    }

    /**
     * Handles connected as well as disconnected graph
     */
    public void bfsIterative () {
        Set<T> visited = new HashSet<>();
        System.out.println("Iterative BFS for connected and disconnected graph: ");
        for (T vertex: adj.keySet()) {
            if(!visited.contains(vertex)) {
                bfsIterative(vertex, visited);
            }
        }
        System.out.println();

    }

    /**
     * Disconnected as well as connected graph
     */
    public void bfsRecursive(){
        Queue<T> queue = new LinkedList<>();
        Set<T> visited = new HashSet<>();
        System.out.println();
        System.out.println("BFS Recursive for connected as well as disconnected graph");
        for (T neighbour: adj.keySet()) {
            if(!visited.contains(neighbour)) {
                visited.add(neighbour);
                queue.add(neighbour);
                bfsRecursiveUtil(visited, queue);
            }
        }
        System.out.println();
    }

    public void bfsRecursiveUtil(Set<T> visited, Queue<T> queue) {
        if(queue.isEmpty()) return;
        T curr = queue.poll();
        System.out.print(curr+", ");
        for (T neighbour: adj.get(curr)) {
            if(!visited.contains(neighbour)){
                visited.add(neighbour);
                queue.add(neighbour);
            }
        }
        bfsRecursiveUtil(visited,queue );
    }


    /**
     * DFS
     */

    public void dfsRecursive() {
        Set<T> visited = new HashSet<>();
        for(T neighbour: adj.keySet()) {
            if(!visited.contains(neighbour)) {
               dfsRecursiveUtil(visited, neighbour);
            }
        }
    }

    public void dfsRecursiveUtil( Set<T> visited, T start) {
        visited.add(start);
        System.out.print(start+", ");
        for(T neighbour: adj.keySet()) {
            if(!visited.contains(neighbour)){
                dfsRecursiveUtil(visited, neighbour);
            }
        }

    }

    public void dfsIterative() {
        System.out.println();
        System.out.println("DFS Iterative: ");
        Set<T> visited = new HashSet<>();

        // Perform DFS for every unvisited vertex
        for (T v : adj.keySet()) {
            if (!visited.contains(v)) {
                dfsIterativeUtil(visited, v);
            }
        }
    }

    public void dfsIterativeUtil(Set<T> visited, T start) {
        Stack<T> stack  = new Stack<>();
        stack.add(start);
        visited.add(start);
        while (!stack.isEmpty()) {
            T curr = stack.pop();
            System.out.print(curr+", ");
            for(T neighbour : adj.get(curr)) {
                if(!visited.contains(neighbour)){
                    stack.add(neighbour);
                    visited.add(neighbour);
                }
            }
        }
    }
}
