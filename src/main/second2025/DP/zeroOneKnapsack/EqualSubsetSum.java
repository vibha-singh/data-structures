package main.second2025.DP.zeroOneKnapsack;

public class EqualSubsetSum {
    boolean isEqualSubsetSum(int[] arr) {
        int totalSum = 0;
        int n = arr.length;
        for(int i = 0;i<n; i++) {
            totalSum += arr[i];
        }

        if(totalSum %2 != 0) return false;
        int sum = totalSum/2;
        boolean[][] dp = new boolean[n+1][sum+1];

        for(int i = 0; i<n+1; i++){
            dp[i][0] = true;
        }

        for(int i = 1; i<n+1; i++) {
            for(int j =1; j< sum+1; j++ ) {
                if(j <= arr[i-1]) {
                    dp[i][j] = dp[i-1][j-arr[i-1]] || dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][sum];
    }
}
