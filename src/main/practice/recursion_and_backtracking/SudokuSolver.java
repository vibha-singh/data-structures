package main.practice.recursion_and_backtracking;

public class SudokuSolver {
    public static void main(String[] args) {
        int[][] matrix = {{5,3,0,0,7,0,0,0,0},
                {6,0,0,1,9,5,0,0,0},
                {0,9,8,0,0,0,0,6,0},
                {8,0,0,0,6,0,0,0,3},
                {4,0,0,8,0,3,0,0,1},
                {7,0,0,0,2,0,0,0,6},
                {0,6,0,0,0,0,2,8,0},
                {0,0,0,4,1,9,0,0,5},
                {0,0,0,0,8,0,0,7,9}};
        if(solveSudoku(matrix, 0,0)){
            for(int i = 0; i<matrix.length; i++) {
                for(int j = 0; j<matrix.length; j++) {
                    System.out.print(matrix[i][j] +" ");
                }
                System.out.println();
            }
        } else {
            System.out.println("Invalid sudoku");
        }

    }

    private static boolean solveSudoku(int[][] matrix, int currRow, int currCol) {
        //if we have reached 8th row and 9th col then we are returning true to avoid further backtracking
        if(currRow == 8 && currCol == 9) {
            return true;
        }

        // if in current row we have reached the last col then we will move to next row and 0th col
        if(currCol == 9){
            currCol= 0;
            currRow++;
        }

        // if filled then call the method by increasing the col
        if(matrix[currRow][currCol] != 0) {
            return solveSudoku(matrix,currRow,currCol+1);
        }
        for(int currVal = 1; currVal<10; currVal++) {

            if(isValidCell(matrix, currRow, currCol, currVal)){
                matrix[currRow][currCol] = currVal;
                if(solveSudoku(matrix, currRow, currCol+1))
                    return true;
            }
            //backtracking
            matrix[currRow][currCol] = 0;
        }

        return false;
    }

    static boolean isValidCell(int[][] matrix, int currRow, int currCol, int currVal) {
        return validRow(matrix, currRow, currVal) && validCol(matrix, currCol, currVal) && validGrid(matrix, currRow, currCol, currVal);
    }

    private static boolean validGrid(int[][] matrix, int currRow, int currCol, int currVal) {
        int x = 3*(currRow/3);
        int y = 3*(currCol/3);

        for(int i = 0; i<3; i++) {
            for(int j= 0; j<3; j++) {
                if(matrix[x+i][y+j] == currVal) return false;
            }
        }
        return true;
    }

    private static boolean validCol(int[][] matrix, int currCol, int currVal) {
        for(int i= 0; i<9; i++) {
            if(matrix[i][currCol] == currVal) return false;
        }
        return true;
    }

    private static boolean validRow(int[][] matrix, int currRow, int currVal) {
        for(int i = 0; i<9; i++){
            if(matrix[currRow][i] == currVal) return false;
        }
        return true;
    }

}
