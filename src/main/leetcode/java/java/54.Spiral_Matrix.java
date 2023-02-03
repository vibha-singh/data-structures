package main.leetcode.java.java;

import java.util.ArrayList;
import java.util.List;

/**
 * 54. Spiral Matrix
 * Medium
 *
 * 7482
 *
 * 844
 *
 * Add to List
 *
 * Share
 * Given an m x n matrix, return all elements of the matrix in spiral order.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [1,2,3,6,9,8,7,4,5]
 * Example 2:
 *
 *
 * Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 *
 *
 * Constraints:
 *
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 10
 * -100 <= matrix[i][j] <= 100
 * **/

class Spriral_Matrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList();
        if(matrix == null || matrix.length == 0 )   return res;
        int startRow = 0;
        int startCol = 0;
        int endRow = matrix.length-1;
        int endCol = matrix[0].length-1;
        while(endRow >= startRow && endCol >=startCol){
            for(int i = startCol; i<= endCol ; i++){
                res.add(matrix[startRow][i]);
            }

            startRow++;
            for(int i = startRow; i<= endRow; i++){
                res.add(matrix[i][endCol]);
            }

            endCol--;
            if(endRow >= startRow){
                for(int i = endCol; i>=startCol; i--){
                    res.add(matrix[endRow][i]);
                }
                endRow--;
            }

            if(endCol >= startCol){
                for(int i = endRow; i >= startRow; i--){
                    res.add(matrix[i][startCol]);
                }
                startCol++;
            }
        }
        return res;
    }
}