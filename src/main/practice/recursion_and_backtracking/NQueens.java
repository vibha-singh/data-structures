package main.practice.recursion_and_backtracking;

/**
 * If given n, then we should place(return all configurations) n-queen in N*N matrix such hat no 2 queens share same row, col, diagonal
 */
public class NQueens {

    public static void main(String[] args) {
        int[][] matrix = {{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}};
        solveNQueens(matrix,0);

    }

    private static void solveNQueens(int[][] matrix, int currRow) {
        if(currRow == matrix.length){
            for(int i = 0 ; i < matrix.length; i++) {
                for(int j = 0 ; j < matrix[0].length; j++) {
                    System.out.print(matrix[i][j]+" ");
                }
                System.out.println();
            }
            System.out.println();
            return;
        }
        for(int j = 0; j< matrix[0].length ; j++) {
            if(isValid(matrix, currRow, j)){
                matrix[currRow][j] = 1;
                solveNQueens(matrix,currRow+1);
                matrix[currRow][j] = 0; //backtrack
            }
        }
    }

    static boolean isValid(int[][] matrix, int currRow, int currCol) {
        return validRow(currRow,matrix) && validCol(currCol, matrix) && validDiagonal(currCol, currRow, matrix);
    }

    static boolean validRow(int currRow, int[][] matrix) {
       for(int i = 0; i < matrix.length; i++){
           if(matrix[currRow][i] == 1) return false;
       }
       return true;
    }

     static boolean validCol(int currCol, int[][] matrix) {
        for(int i = 0; i < matrix[0].length; i++){
            if(matrix[i][currCol] == 1) return false;
        }
        return true;
    }

     static boolean validDiagonal(int currCol, int currRow, int[][] matrix) {
        int r = currRow; //left up
        int c = currCol;
        while(r >= 0 && c >= 0) {
            if(matrix[r][c] == 1) return false;
            r--;
            c--;
        }
         r = currRow;  //right up
         c = currCol;
        while(r >= 0 && c < matrix[0].length) {
            if(matrix[r][c] == 1) return false;
            r--;
            c++;
        }
        r = currRow; //left down
        c = currCol;
        while(c >= 0 && r < matrix.length) {
            if(matrix[r][c] == 1) return false;
            r++;
            c--;
        }
        r = currRow; //right down
        c = currCol;
        while(c < matrix[0].length && r < matrix.length) {
            if(matrix[r][c] == 1) return false;
            r++;
            c++;
        }
        return true;
    }
}
