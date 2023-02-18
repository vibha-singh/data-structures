package main.practice.dp.CoinChange;

/**
 * Given an integer array coins[ ] of size N representing different denominations of currency and an integer sum, find the number of ways you can make sum by using different combinations from coins[ ].
 * Note: Assume that you have an infinite supply of each type of coin.
 *
 * Example 1:
 *
 * Input:
 * sum = 4 ,
 * N = 3
 * coins[] = {1,2,3}
 * Output: 4
 * Explanation: Four Possible ways are:
 * {1,1,1,1},{1,1,2},{2,2},{1,3}.
 */
public class CoinChangeI {
    public static void main(String[] args) {
        int[] coins = {2, 5, 3, 6};
        int n = coins.length;
        int sum = 10;
        int[] dp = new int[sum+1];
        dp[0] = 1;
        for (int i = 0; i < n; i++)
            for (int j = coins[i]; j <= sum; j++)
                dp[j] += dp[j - coins[i]];
        System.out.println(dp[sum]);
    }
}
