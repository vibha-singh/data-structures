package main.practice.dp.knapsack;

import java.util.HashMap;
import java.util.Map;

/**
 * You are given weights and values of N items, put these items in a knapsack of capacity W to get the maximum total value in the knapsack. Note that we have only one quantity of each item.
 * In other words, given two integer arrays val[0..N-1] and wt[0..N-1] which represent values and weights associated with N items respectively. Also given an integer W which represents knapsack capacity, find out the maximum value subset of val[] such that sum of the weights of this subset is smaller than or equal to W. You cannot break an item, either pick the complete item or dont pick it (0-1 property).
 *
 * Example 1:
 *
 * Input:
 * N = 3
 * W = 4
 * values[] = {1,2,3}
 * weight[] = {4,5,1}
 * Output: 3
 */
public class ZeroToOneKnapsackProblem {
    public static void main(String[] args) {
        int[] wt = {10, 20, 30};
        int[] val = {60, 100, 120};
        int W = 50;
        System.out.println(knapSack(W, wt, val, val.length));

    }

    static int knapSack(int W, int wt[], int val[], int n)
    {
        int[] dp = new int[W + 1];
        for (int i = 0; i < n ; i++) {
            for (int w = W; w >= 0; w--) {
                if (wt[i] <= w)
                    dp[w] = Math.max(dp[w], dp[w - wt[i]] + val[i]);
            }
        }
        return dp[W];
    }
}
