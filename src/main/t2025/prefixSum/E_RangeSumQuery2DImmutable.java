package main.t2025.prefixSum;

public class E_RangeSumQuery2DImmutable {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int[][] queries = {
                {0, 0, 1, 1}, // Sum of [[1, 2], [4, 5]]
                {1, 1, 2, 2}  // Sum of [[5, 6], [8, 9]]
        };

        int[][] prefixSum = getPefixSum (matrix);

        for (int[] query : queries) {
            int row1 = query[0];
            int col1 = query[1];
            int row2 = query[2];
            int col2 = query[3];
            int sum = sumRegion(prefixSum, row1, col1, row2, col2);
            System.out.println("Sum of rectangle from (" + row1 + ", " + col1 + ") to (" + row2 + ", " + col2 + "): " + sum);
        }
    }

    private static int[][] getPefixSum(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] prefixSum = new int[row+1][col+1];
        for(int i = 1; i<=row; i++){
            for(int j = 1; j<=col; j++) {
                prefixSum[i][j] = matrix[i-1][j-1] + prefixSum[i-1][j] + prefixSum[i][j-1] - prefixSum[i-1][j-1];
            }
        }
        return prefixSum;
    }

    private static int sumRegion(int[][] prefixSum, int row1, int col1, int row2, int col2) {
        return prefixSum[row1][col1]+ prefixSum[row2+1][col2+1] - prefixSum[row1][col2+1] - prefixSum[row2+1][col1];
    }
}
