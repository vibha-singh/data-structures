package main.practice.dp;

public class MaximizeThecutSegments {

    public static void main(String[] args) {
        int x = 5, y = 3, z = 2;
        int n = 5;
        System.out.println(maximizeTheCuts(n, x, y, z));
    }

    static int maximizeTheCuts(int n, int x, int y, int z) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            if (i == x || i == y || i == z) dp[i] = 1;
            if (i >= x && dp[i - x] != 0) dp[i] = Math.max(dp[i], dp[i - x] + 1);
            if (i >= y && dp[i - y] != 0) dp[i] = Math.max(dp[i], dp[i - y] + 1);
            if (i >= z && dp[i - z] != 0) dp[i] = Math.max(dp[i], dp[i - z] + 1);
        }
        return dp[n];
    }
}
