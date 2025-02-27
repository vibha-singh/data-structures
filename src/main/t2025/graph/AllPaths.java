package main.t2025.graph;

import java.util.*;

public class AllPaths {


    static NonGenericGraph graph = new NonGenericGraph(6);

    public static void main(String[] args) {
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);

        System.out.println(graph.getAllPaths(0));

        System.out.println("Different approach");
        System.out.println(graph.allPathsSourceTarget(graph.adj));
    }
}
class NonGenericGraph {
    int V;
    Map<Integer, List<Integer>> adj;

    public NonGenericGraph(int V) {
        this.V = V;
        adj = new HashMap<>();
    }

    public void addEdge(int source, int destination) {
        adj.computeIfAbsent(source, v -> new ArrayList<>()).add(destination);
        adj.computeIfAbsent(destination, v -> new ArrayList<>());
    }

    /***
     * =============================================== One solution ============================================================
     * @param start
     * @return
     */
    public List<List<Integer>> getAllPaths(int start) {
        if (!adj.containsKey(start)) {
            System.out.println(" No path exists!!!");
            return Collections.emptyList();
        }

        List<List<Integer>> paths = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        List<Integer> currPath = new ArrayList<>();
        dfsFindPaths(start, paths, visited, currPath);
        return paths;
    }

    private void dfsFindPaths(int start, List<List<Integer>> paths, Set<Integer> visited, List<Integer> currPath) {
        visited.add(start);
        currPath.add(start);
        if (adj.get(start).isEmpty()) {
            paths.add(new ArrayList<>(currPath));
        } else {
            for (Integer curr : adj.get(start)) {
                if (!visited.contains(curr))
                    dfsFindPaths(curr, paths, visited, currPath);
            }
        }

        // IMPORTANT to clear currPath so that we can start saving next path as well as reset visited.
        currPath.remove(currPath.size() - 1);
        visited.remove(start);
    }

    /***
     * ====================================== second solution ================================================
     * @param graph
     * @return
     */
    public List<List<Integer>> allPathsSourceTarget(Map<Integer, List<Integer>> graph) {
        List<List<Integer>> allPaths = new ArrayList<>();
        List<Integer> currPath = new ArrayList<>();
        currPath.add(0);
        getAllPaths(0, graph.size() - 1, graph, allPaths, currPath);
        return allPaths;
    }

    public void getAllPaths(int source, int destination, Map<Integer, List<Integer>> graph, List<List<Integer>> allPaths, List<Integer> currPath) {
        if (source == destination) {
            allPaths.add(new ArrayList<>(currPath));
            return;
        }

        for (Integer neighbour : graph.get(source)) {
            currPath.add(neighbour);
            getAllPaths(neighbour, destination, graph, allPaths, currPath);
            currPath.remove(currPath.size() - 1);
        }

    }
}

