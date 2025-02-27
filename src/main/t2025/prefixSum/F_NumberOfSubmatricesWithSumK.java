package main.t2025.prefixSum;

import java.util.HashMap;
import java.util.Map;

public class F_NumberOfSubmatricesWithSumK {
    public static void main(String[] args) {
        int[][] matrix = {
                {0, 1, 0},
                {1, 1, 1},
                {0, 1, 0}
        };
        int k = 0;
        int[][] prefixSum = prefixSum(matrix);
        System.out.println("Number of submatrices with sum " + k + ": " + numberOfSubmatricesWithSumK(prefixSum, k));
    }

    private static int[][] prefixSum(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] prefix = new int[row+1][col+1];

        for(int i = 1; i <= row; i++) {
            for(int j = 1; j <= col ; j++) {
                prefix[i][j] = matrix[i - 1][j - 1] + prefix[i - 1][j] + prefix[i][j - 1] - prefix[i - 1][j - 1];
            }
        }

        return prefix;
    }

    private static int numberOfSubmatricesWithSumK(int[][] prefixSum, int k){
        int row = prefixSum.length;
        int col = prefixSum[0].length;
        int count = 0;
        for(int row1 = 1; row1 < row ; row1++) {
            for(int row2 = row1 ; row2 < row ; row2++){
                Map<Integer, Integer> map = new HashMap<>();
                map.put(0,1);
                for(int i = 1; i<col ; i++) {
                    int currSum = prefixSum[row2][i] - prefixSum[row1-1][i];
                    if(map.containsKey(currSum - k)) {
                        count += map.get(currSum - k);
                    }
                    map.put(currSum, map.getOrDefault(currSum,0)+1);
                }
            }
        }
        return count;
    }
}
