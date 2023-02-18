package main.practice.dp;

/**
 * Given a positive array, find the number of subsequences having product smaller than or equal to K.
 * Examples:
 *
 * Input : [1, 2, 3, 4]
 *         k = 10
 * Output :11
 * Explanation: The subsequences are {1}, {2}, {3}, {4}, {1, 2}, {1, 3}, {1, 4}, {2, 3}, {2, 4}, {1, 2, 3}, {1, 2, 4}
 *
 * Input  : [4, 8, 7, 2]
 *          k = 50
 * Output : 9
 */
public class CountAllSubsequenceHavingProductLessThanK {
    public static void main(String args[]) {
        int [] arr = {1,2,3,4};
        int k = 10;
        System.out.println(productSubSeqCount(arr, k));
    }

    public static int productSubSeqCount(int[] arr, int k) {
        int n = arr.length;
        int dp[][] = new int[k + 1][n + 1];

        for (int i = 1; i <= k; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i][j - 1];

                if (arr[j - 1] > 0 && arr[j - 1] <= i )
                    dp[i][j] += dp[i / arr[j - 1]][j - 1] + 1;
            }
        }
        return dp[k][n];
    }

}
