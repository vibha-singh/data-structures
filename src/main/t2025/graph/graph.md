Graphs are a fundamental data structure in computer science, and there are many common problems related to graphs. Below is a list of common graph-related questions, along with their Java implementations, Time Complexity (TC), and Space Complexity (SC).

1. Graph Representation
   Adjacency Matrix

Adjacency List

java
Copy
// Adjacency List Representation
import java.util.*;

class Graph {
private int V;
private LinkedList<Integer> adj[];

    Graph(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList();
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
    }
}
TC: O(1) for adding an edge.

SC: O(V + E), where V is the number of vertices and E is the number of edges.

2. Breadth-First Search (BFS)
   Traverse a graph level by level.

java
Copy
void BFS(int start) {
boolean visited[] = new boolean[V];
Queue<Integer> queue = new LinkedList<>();
visited[start] = true;
queue.add(start);

    while (!queue.isEmpty()) {
        int node = queue.poll();
        System.out.print(node + " ");

        for (int neighbor : adj[node]) {
            if (!visited[neighbor]) {
                visited[neighbor] = true;
                queue.add(neighbor);
            }
        }
    }
}
TC: O(V + E)

SC: O(V)

3. Depth-First Search (DFS)
   Traverse a graph by exploring as far as possible along each branch.

java
Copy
void DFS(int v, boolean visited[]) {
visited[v] = true;
System.out.print(v + " ");

    for (int neighbor : adj[v]) {
        if (!visited[neighbor])
            DFS(neighbor, visited);
    }
}

void DFS(int start) {
boolean visited[] = new boolean[V];
DFS(start, visited);
}
TC: O(V + E)

SC: O(V)

4. Detect Cycle in a Directed Graph
   Check if a graph contains a cycle.

java
Copy
boolean isCyclicUtil(int v, boolean visited[], boolean recStack[]) {
if (recStack[v]) return true;
if (visited[v]) return false;

    visited[v] = true;
    recStack[v] = true;

    for (int neighbor : adj[v]) {
        if (isCyclicUtil(neighbor, visited, recStack))
            return true;
    }

    recStack[v] = false;
    return false;
}

boolean isCyclic() {
boolean visited[] = new boolean[V];
boolean recStack[] = new boolean[V];

    for (int i = 0; i < V; i++) {
        if (isCyclicUtil(i, visited, recStack))
            return true;
    }
    return false;
}
TC: O(V + E)

SC: O(V)

5. Detect Cycle in an Undirected Graph
   Check if an undirected graph contains a cycle.

java
Copy
boolean isCyclicUtil(int v, boolean visited[], int parent) {
visited[v] = true;

    for (int neighbor : adj[v]) {
        if (!visited[neighbor]) {
            if (isCyclicUtil(neighbor, visited, v))
                return true;
        } else if (neighbor != parent) {
            return true;
        }
    }
    return false;
}

boolean isCyclic() {
boolean visited[] = new boolean[V];

    for (int i = 0; i < V; i++) {
        if (!visited[i]) {
            if (isCyclicUtil(i, visited, -1))
                return true;
        }
    }
    return false;
}
TC: O(V + E)

SC: O(V)

6. Topological Sorting
   Linear ordering of vertices such that for every directed edge UV, vertex U comes before V.

java
Copy
void topologicalSortUtil(int v, boolean visited[], Stack<Integer> stack) {
visited[v] = true;

    for (int neighbor : adj[v]) {
        if (!visited[neighbor])
            topologicalSortUtil(neighbor, visited, stack);
    }

    stack.push(v);
}

void topologicalSort() {
Stack<Integer> stack = new Stack<>();
boolean visited[] = new boolean[V];

    for (int i = 0; i < V; i++) {
        if (!visited[i])
            topologicalSortUtil(i, visited, stack);
    }

    while (!stack.isEmpty()) {
        System.out.print(stack.pop() + " ");
    }
}
TC: O(V + E)

SC: O(V)

7. Shortest Path in Unweighted Graph (BFS)
   Find the shortest path from a source node to all other nodes.

java
Copy
void shortestPath(int start) {
int dist[] = new int[V];
Arrays.fill(dist, Integer.MAX_VALUE);
Queue<Integer> queue = new LinkedList<>();

    dist[start] = 0;
    queue.add(start);

    while (!queue.isEmpty()) {
        int node = queue.poll();

        for (int neighbor : adj[node]) {
            if (dist[neighbor] == Integer.MAX_VALUE) {
                dist[neighbor] = dist[node] + 1;
                queue.add(neighbor);
            }
        }
    }

    for (int i = 0; i < V; i++) {
        System.out.println("Distance from " + start + " to " + i + " is " + dist[i]);
    }
}
TC: O(V + E)

SC: O(V)

8. Dijkstra's Algorithm (Shortest Path in Weighted Graph)
   Find the shortest path from a source node to all other nodes in a weighted graph.

java
Copy
void dijkstra(int start) {
int dist[] = new int[V];
Arrays.fill(dist, Integer.MAX_VALUE);
dist[start] = 0;

    PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
    pq.add(new int[]{start, 0});

    while (!pq.isEmpty()) {
        int[] current = pq.poll();
        int node = current[0];
        int weight = current[1];

        for (int[] neighbor : adj[node]) {
            if (dist[neighbor[0]] > weight + neighbor[1]) {
                dist[neighbor[0]] = weight + neighbor[1];
                pq.add(new int[]{neighbor[0], dist[neighbor[0]]});
            }
        }
    }

    for (int i = 0; i < V; i++) {
        System.out.println("Distance from " + start + " to " + i + " is " + dist[i]);
    }
}
TC: O((V + E) log V)

SC: O(V)

9. Minimum Spanning Tree (Prim's Algorithm)
   Find the minimum spanning tree of a weighted undirected graph.

java
Copy
void primMST() {
int parent[] = new int[V];
int key[] = new int[V];
boolean mstSet[] = new boolean[V];

    Arrays.fill(key, Integer.MAX_VALUE);
    key[0] = 0;
    parent[0] = -1;

    PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
    pq.add(new int[]{0, key[0]});

    while (!pq.isEmpty()) {
        int[] current = pq.poll();
        int u = current[0];
        mstSet[u] = true;

        for (int[] neighbor : adj[u]) {
            int v = neighbor[0];
            int weight = neighbor[1];
            if (!mstSet[v] && weight < key[v]) {
                parent[v] = u;
                key[v] = weight;
                pq.add(new int[]{v, key[v]});
            }
        }
    }

    for (int i = 1; i < V; i++) {
        System.out.println(parent[i] + " - " + i);
    }
}
TC: O((V + E) log V)

SC: O(V)

10. Flood Fill Algorithm
    Fill a region in a 2D matrix.

java
Copy
void floodFill(int[][] image, int sr, int sc, int newColor) {
int oldColor = image[sr][sc];
if (oldColor == newColor) return;
dfs(image, sr, sc, oldColor, newColor);
}

void dfs(int[][] image, int r, int c, int oldColor, int newColor) {
if (r < 0 || r >= image.length || c < 0 || c >= image[0].length || image[r][c] != oldColor) {
return;
}
image[r][c] = newColor;
dfs(image, r + 1, c, oldColor, newColor);
dfs(image, r - 1, c, oldColor, newColor);
dfs(image, r, c + 1, oldColor, newColor);
dfs(image, r, c - 1, oldColor, newColor);
}
TC: O(N), where N is the number of pixels.

SC: O(N) (recursion stack).

This list covers the most common graph problems. Let me know if you need further clarification or additional problems!