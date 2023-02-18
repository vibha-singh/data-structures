package main.practice.dp;

/**
 * Given a 2D matrix M of dimensions RxC. Find the maximum sum submatrix in it.
 * Input:
 * R=4
 * C=5
 * M=[[1,2,-1,-4,-20],
 * [-8,-3,4,2,1],
 * [3,8,10,1,3],
 * [-4,-1,1,7,-6]]
 * Output:
 * 29
 */
public class MaximumSumRectangleIN2DMatrix {
    public static void main(String [] args) {
        int[][] M = {{1,2,-1,-4,-20},
                    {-8,-3,4,2,1},
                    {3,8,10,1,3},
                    {-4,-1,1,7,-6}};
        int rLen = M.length, cLen = M[0].length;
        int [][] dp = new int[rLen][cLen];

        for(int i = 0; i < rLen; i++) {
            for(int j = 0; j < cLen ; j++ ) {
                if(i == 0)
                    dp[i][j] = M[i][j];
                else
                    dp[i][j] = M[i][j] + dp[i-1][j];
            }
        }
        int max = Integer.MIN_VALUE;
        for(int k = 0; k < rLen; k++){
            for(int i = k; i < rLen; i++) {
                int sum = 0;
                for(int j = 0; j<cLen; j++) {
                    int currSum = dp[i][j];
                    if(k > 0)
                        currSum -= dp[k-1][j];
                    sum += currSum;
                    //handling negative values
                    if(sum < currSum)
                        sum = currSum;
                    max = Math.max(max, sum);
                }
            }
        }
        System.out.println(max);
    }
}
