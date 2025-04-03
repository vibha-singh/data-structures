package main.t2025.DP;

import java.util.Arrays;

/**
 * The Coin Change problem is a classic dynamic programming problem. The problem is defined as follows:
 * You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
 * Return the minimum number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
 * You may assume that you have an infinite number of each kind of coin.
 */
public class E_CoinChange {
    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 11;
        System.out.println("Minimum number of coins: " + coinChange(coins, amount));
    }

    private static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount +1];
        Arrays.fill(dp, amount+1);
        // important provide base case
        dp[0] = 0;
        for(int i = 1; i <= amount; i++) {
            for(int coin: coins) {
                if(coin <= i) {
                    dp[i] = Math.min(dp[i], dp[i-coin]+1);
                }
            }
        }
        return dp[amount] > amount ? -1: dp[amount];
    }
}
