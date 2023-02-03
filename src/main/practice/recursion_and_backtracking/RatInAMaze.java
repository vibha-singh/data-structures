package main.practice.recursion_and_backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * BACKTRACKING recursive
 * TC: O(2^(n^2)), where n is the size of the maze. SC: O(n^2), as it needs to store the current path in memory.
 */
public class RatInAMaze {

    public static void main(String[] args) {
        int[][] maze = {{1,0,0,0},
                        {1,1,0,0},
                        {1,1,0,0},
                        {0,1,1,1}};
        ArrayList<String> result = new ArrayList<>();
        noOfWays(maze, result, 0,0,new String());
        System.out.println(result);
    }

    private static void noOfWays(int[][] maze, ArrayList<String> result, int i, int j, String s) {
        if(i<0 || j< 0 || i>= maze.length || j >= maze[0].length || maze[i][j] != 1) return;

        if(i == maze.length -1 && j == maze.length-1) {
            result.add(s);
            return;
        }

        maze[i][j] = 0;
        noOfWays(maze,result,i,j+1,s+"R");
        noOfWays(maze,result,i,j-1,s+"L");
        noOfWays(maze,result,i+1,j,s+"D");
        noOfWays(maze,result,i-1,j,s+"U");
        maze[i][j] = 1;
    }

}

/**
 * BFS
 * Time Complexity: O(N * M).
 * Auxiliary Space: O(N * M).
 */
class Node {
    int x;
    int y;
    Node(int x, int y){
        this.x = x;
        this.y = y;
    }
}

class RatInAMazeBFS {
    static int N = 4;

    // Function to find the possible rat path
    static boolean findPath(int[][] maze, int[][] sol) {
        Queue<Node> q = new LinkedList<>();
        Node start = new Node(0, 0);
        q.add(start);

        while (!q.isEmpty()) {
            Node curr = q.poll();

            // If the current cell is the destination cell
            if (curr.x == N - 1 && curr.y == N - 1) {
                sol[curr.x][curr.y] = 1;
                return true;
            }

            // Check right
            if (isValidMove(maze, sol, curr.x, curr.y + 1)) {
                sol[curr.x][curr.y + 1] = 1;
                q.add(new Node(curr.x, curr.y + 1));
            }

            // Check down
            if (isValidMove(maze, sol, curr.x + 1, curr.y)) {
                sol[curr.x + 1][curr.y] = 1;
                q.add(new Node(curr.x + 1, curr.y));
            }

            // Check left
            if (isValidMove(maze, sol, curr.x, curr.y - 1)) {
                sol[curr.x][curr.y - 1] = 1;
                q.add(new Node(curr.x, curr.y - 1));
            }

            // Check up
            if (isValidMove(maze, sol, curr.x - 1, curr.y)) {
                sol[curr.x - 1][curr.y] = 1;
                q.add(new Node(curr.x - 1, curr.y));
            }
        }

        return false;
    }

    // Helper function to check if a move is valid
    static boolean isValidMove(int[][] maze, int[][] sol, int x, int y) {
        if (x >= 0 && x < N && y >= 0 && y < N && maze[x][y] == 1 && sol[x][y] == 0) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] maze = {
                {1, 1, 0, 0},
                {1, 1, 0, 1},
                {0, 1, 0, 0},
                {1, 1, 1, 1}
        };

        int[][] sol = new int[N][N];

        if (findPath(maze, sol)) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    System.out.print(sol[i][j] + " ");
                }
                System.out.println();
            }
        } else {
            System.out.println("No Path found");
        }
    }
}