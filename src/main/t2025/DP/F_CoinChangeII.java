package main.t2025.DP;

/**
 * The Coin Change 2 problem is a variation of the classic Coin Change problem. The problem is defined as follows:
 * You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
 * Return the number of combinations that make up that amount. If that amount of money cannot be made up by any combination of the coins, return 0.
 * You may assume that you have an infinite number of each kind of coin.
 * The order of coins does not matter (i.e., 1 + 2 is the same as 2 + 1).
 */
public class F_CoinChangeII {
    public static int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1]; // dp[i] = number of combinations to make amount i
        dp[0] = 1; // Base case: 1 way to make amount 0 (using no coins)

        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin]; // Recurrence relation
            }
        }

        return dp[amount];
    }

    public static void main(String[] args) {
        int amount = 5;
        int[] coins = {1, 2, 5};
        System.out.println("Number of combinations: " + change(amount, coins));
    }
}
