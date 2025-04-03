package main.t2025.recursionAndBacktracking;

import java.util.ArrayList;
import java.util.List;

public class A_RatInAMaze {
    public static void main(String[] args) {
        int[][] maze = {{1,0,0},{1,1,0},{1,1,1}};
        List<String> ans = new ArrayList<>();
        solveRatInAMaze(maze, ans, 0, 0, "");
        System.out.println(ans);
    }

    private static void solveRatInAMaze(int[][] maze, List<String> ans, int cr, int cc, String s) {
        if(cr >= maze.length || cc >= maze[0].length || cr < 0 || cc < 0 || maze[cr][cc] != 1) return;
        if(cc == maze[0].length-1 && cr == maze.length-1) {
            ans.add(s);
            return;
        }
        maze[cr][cc] = 0;
        solveRatInAMaze(maze, ans, cr+1, cc, s+"D");
        solveRatInAMaze(maze,ans, cr-1, cc, s+"U");
        solveRatInAMaze(maze,ans, cr, cc+1, s+"R");
        solveRatInAMaze(maze,ans, cr, cc-1, s+"L");
        maze[cr][cc] = 1;

    }
}
