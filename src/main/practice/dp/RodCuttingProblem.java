package main.practice.dp;

public class RodCuttingProblem {
    public static void main(String[] args) {
        int price[] = { 1, 5, 8, 9, 10, 17, 17, 20 };
        int sizeOfRod = price.length;
        System.out.println(unboundedKnapsack(sizeOfRod, price));
    }

    private static int unboundedKnapsack( int n, int[] price) {
        int dp[] = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j < n; j++) {
                if (j <= i) {
                    dp[i] = Math.max(dp[i], dp[i - j] + price[j]);
                }
            }
        }
        return dp[n];
    }
}
