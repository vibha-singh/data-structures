package main.geeksForGeeks.dataStructure.recursion_and_backtracking;

import java.util.ArrayList;
import java.util.List;

public class NQueensProblem {
    static int N = 4;
    static int[][] board = {{0,0,0,0},
                            {0,0,0,0},
                            {0,0,0,0},
                            {0,0,0,0}};

    public static void main(String[] args) {
        System.out.println(solve());

        ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();
    }

    public static boolean solve(){
        if(!solveRec(0))
            return false;
        else {
            printMatrix(board);
            return true;
        }
    }

    private static boolean solveRec(int col) {
        if(col == N) return true;
        for(int i = 0; i<N ; i++){
            if(isSafe(i, col)) {
                board[i][col] = 1;

                if(solveRec(col + 1)) return true;

                board[i][col] = 0;
            }
        }
        return false;

    }

    private static boolean isSafe(int row, int col) {
        int i,j;
        //check for previously placed queen till current row
        for(i = 0 ; i<col; i++){
            if(board[row][i] == 1) return false;
        }
        //upper diagonal
        for(i = row, j = col ; i>=0 && j>=0 ; i--,j--){
            if(board[i][j] == 1) return false;
        }
        //lower diagonal
        for(i = row, j = col ; i<N && j>=0 ; i++,j--){
            if(board[i][j] == 1) return false;
        }

        return true;
    }

    private static void printMatrix(int[][] board) {
        int i, j;
        for(i = 0; i< N ; i++){
            System.out.println("");
            for(j = 0; i< N; j++){
                System.out.print(board[i][j]+" ");
            }
        }
    }
}
