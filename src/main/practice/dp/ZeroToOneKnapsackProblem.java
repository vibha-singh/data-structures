package main.practice.dp;

import java.util.HashMap;
import java.util.Map;

/**
 * Given weights and values of N items, put these items in a knapsack of capacity W to get the maximum total value in the knapsack. In other words, given two integer arrays val[0..N-1] and wt[0..N-1] which represent values and weights associated with N items respectively. Also given an integer W which represents knapsack capacity, find out the maximum value subset of val[] such that the sum of the weights of this subset is smaller than or equal to W. You cannot break an item, either pick the complete item or don’t pick it (0-1 property)
 */
public class ZeroToOneKnapsackProblem {
    public static void main(String[] args) {
//        int val[] = { 60, 100, 120 };
//        int wt[] = { 10, 20, 30 };
//        int W = 50;
//        int n = val.length;
//        int res = knapSack(W, wt, val, n);
//        System.out.println(res);

        int[] wt = {10, 20, 30};
        int[] val = {60, 100, 120};
        int W = 50;
        System.out.println(knapsack(wt, val, W));
        System.out.println(knapSack(W, wt, val, val.length));

    }

    static int knapSack(int W, int wt[], int val[], int n)
    {
        // making and initializing dp array
        int[] dp = new int[W + 1];
        for (int i = 1; i < n + 1; i++) {
            for (int w = W; w >= 0; w--) {
                if (wt[i - 1] <= w)
                    // finding the maximum value
                    dp[w] = Math.max(dp[w], dp[w - wt[i - 1]] + val[i - 1]);
            }
        }
        return dp[W]; // returning the maximum value of
        // knapsack
    }

    static int knapsack(int[] wt, int[] val, int W) {
        int n = wt.length;
        int[][] dp = new int[n + 1][W + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= W; j++) {
                // previous weight is less than or equal to current value of weight capacity
                if (wt[i - 1] <= j) {
                    // set dp[i][j] = maximum of (previous weight value +
                    dp[i][j] = Math.max(val[i - 1] + dp[i - 1][j - wt[i - 1]], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][W];
    }
}
