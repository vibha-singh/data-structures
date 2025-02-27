package main.practice2024.recursionAndBacktracking;

import java.util.ArrayList;

public class RanInAMaze {
    public static void main(String[] args) {
        int[][] maze = {{1,0,0},{1,1,0},{1,1,1}};
        ArrayList<String> result = new ArrayList<>();
        ratInAMaze(maze, 0, 0, result, "");
        System.out.println(result);
    }

    private static void ratInAMaze(int[][] maze, int cr, int cc, ArrayList<String> noOfWays, String currWay) {
        if (cr < 0 || cc < 0 || cr >= maze.length || cc >= maze[0].length || maze[cr][cc] != 1) return;

        if(cr == maze.length-1 && cc == maze[0].length -1) {
            noOfWays.add(currWay);
            return;
        }
        maze[cr][cc] = 0;
        ratInAMaze(maze, cr, cc+1, noOfWays, currWay+"R");
        ratInAMaze(maze, cr, cc-1, noOfWays, currWay+"L");
        ratInAMaze(maze, cr+1, cc, noOfWays, currWay+"D");
        ratInAMaze(maze, cr-1, cc, noOfWays, currWay+"U");
        maze[cr][cc] = 1;


    }
}
