package main.practice.recursion_and_backtracking;

public class KnightToursProblem {
    public static void main(String[] args) {
        int[][] matrix = {{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0}};
        int n = 8;
//        solveKnightToursProblem(matrix, 0,0,1, n);
//        for(int i = 0 ;i< matrix.length;i++){
//            for (int j = 0; j<matrix.length; j++) {
//                System.out.print(matrix[i][j]+" ");
//            }
//            System.out.println();
//        }
        findKnightTourSol(matrix, n);
    }

    //check why this went inside infinite loop
    private static void solveKnightToursProblem(int[][] matrix, int currRow, int currCol, int currVal, int n) {
        if(currVal == n*n){
            for(int i = 0 ;i< matrix.length;i++){
                for (int j = 0; j<matrix.length; j++) {
                    System.out.print(matrix[i][j]+" ");
                }
                System.out.println();
            }
            System.out.println();
            return;
        }

        if(currRow<0 || currCol <0 || currRow >= n || currCol >= n || matrix[currRow][currCol] !=0)
            return;

        matrix[currRow][currCol] = currVal;
        solveKnightToursProblem(matrix, currRow-2, currCol-1, currVal+1, n);
        solveKnightToursProblem(matrix, currRow-2, currCol+1, currVal+1, n);
        solveKnightToursProblem(matrix, currRow+2, currCol-1, currVal+1, n);
        solveKnightToursProblem(matrix, currRow+2, currCol+1, currVal+1, n);
        solveKnightToursProblem(matrix, currRow-1, currCol-2, currVal+1, n);
        solveKnightToursProblem(matrix, currRow-1, currCol+2, currVal+1, n);
        solveKnightToursProblem(matrix, currRow+1, currCol-2, currVal+1, n);
        solveKnightToursProblem(matrix, currRow+1, currCol+2, currVal+1, n);
        matrix[currRow][currCol] = 0;
    }



    static boolean isValid(int x, int y, int[][] sol, int N) {     //check place is in range and not assigned yet
        return ( x >= 0 && x < N && y >= 0 && y < N && sol[x][y] == -1);
    }

    static void displaySolution(int[][] sol, int N) {
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++)
                System.out.print(sol[x][y]+" ");
            System.out.println();
        }
    }

    static boolean knightTour(int x, int y, int move, int[][] sol, int[] xMove, int[] yMove, int N) {
        int xNext, yNext;
        if (move == N*N)     //when the total board is covered
            return true;

        for (int k = 0; k < N; k++) {
            xNext = x + xMove[k];
            yNext = y + yMove[k];
            if (isValid(xNext, yNext, sol, N)) {     //check room is preoccupied or not
                sol[xNext][yNext] = move;
                if (knightTour(xNext, yNext, move+1, sol, xMove, yMove, N))
                    return true;
                else
                    sol[xNext][yNext] = -1;// backtracking
            }
        }
        return false;
    }

    static void findKnightTourSol(int[][] sol, int N) {
        for (int x = 0; x < N; x++)     //initially set all values to -1 of solution matrix
            for (int y = 0; y < N; y++)
                sol[x][y] = -1;
        //all possible moves for knight
        int[] xMove = {  2, 1, -1, -2, -2, -1,  1,  2 };
        int[] yMove = {  1, 2,  2,  1, -1, -2, -2, -1 };
        sol[0][0]  = 0;     //starting from room (0, 0)

        if (!knightTour(0, 0, 1, sol, xMove, yMove, N)) {
            System.out.println( "Solution does not exist");
        } else
            displaySolution(sol, N);
    }
}
