package main.t2025.graph.directedGraph.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * Why Union-Find Fails:
 * Union-Find works for undirected graphs, but the course schedule problem involves a directed graph. In a directed graph, Union-Find cannot distinguish between different directions of edges, leading to incorrect cycle detection.
 */
public class C_CourseSchedule {

    public static void main(String[] args) {
        int numCourses = 4;

        int[][] prerequisites = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        System.out.println(canFinish(numCourses, prerequisites)); // Output: true
    }

    private static boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i =0;i<numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for(int[] edge: prerequisites) {
            int course = edge[0];
            int prerequisite = edge[1];
            graph.get(prerequisite).add(course);
        }

        int[] visited = new int[numCourses];
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i<numCourses; i++) {
            if(visited[i] == 0 && hasCycle(ans, graph, visited, i)){
                System.out.println(ans);
                return false;
            }
        }
        System.out.println(ans);
        return true;
    }

    private static boolean hasCycle(List<Integer> ans, List<List<Integer>> graph, int[] visited, int i) {
        if(visited[i] == 1) return true; // Cycle detected (node is currently being visited)
        if(visited[i] == 2) return false; // node is fully visited

        visited[i] = 1;
        for(Integer neighbour: graph.get(i)) {
                if(hasCycle(ans, graph, visited, neighbour)){
                return true;
            }
        }
        visited[i] = 2;
        ans.add(i);
        return false;
    }


}
