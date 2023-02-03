package main.leetcode.java.java;

/**
 * 498. Diagonal Traverse
 * Medium
 *
 * 2269
 *
 * 542
 *
 * Add to List
 *
 * Share
 * Given an m x n matrix mat, return an array of all the elements of the array in a diagonal order.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: mat = [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [1,2,4,7,5,3,6,8,9]
 * Example 2:
 *
 * Input: mat = [[1,2],[3,4]]
 * Output: [1,2,3,4]
 *
 *
 * Constraints:
 *
 * m == mat.length
 * n == mat[i].length
 * 1 <= m, n <= 104
 * 1 <= m * n <= 104
 * -105 <= mat[i][j] <= 105
 * **/

class DiagonalTraverse {
    public int[] findDiagonalOrder(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)   return new int[]{};

        boolean up = true;
        int currentRow = 0, currentCol = 0, noOfRows = matrix.length, noOfCols = matrix[0].length, count = 0;
        int[] res = new int[noOfRows * noOfCols];

        while(currentRow <= noOfRows - 1 && currentCol <= noOfCols - 1){
            if(up){
                while(currentRow > 0 && currentCol < noOfCols - 1){
                    res[count++] = matrix[currentRow][currentCol];
                    currentRow--;
                    currentCol++;
                }
                res[count++] = matrix[currentRow][currentCol];
                if(currentCol != noOfCols - 1)  currentCol++;
                else            currentRow++;
            }else{
                while(currentRow < noOfRows - 1 && currentCol > 0){
                    res[count++] = matrix[currentRow][currentCol];
                    currentRow++;
                    currentCol--;
                }
                res[count++] = matrix[currentRow][currentCol];
                if(currentRow != noOfRows - 1)  currentRow++;
                else            currentCol++;
            }
            up = !up;
        }

        return res;
    }
}