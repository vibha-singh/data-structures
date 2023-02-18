package main.practice.dp;

import java.util.Arrays;

public class MaximumLengthOfPairChain {
    public static void main(String[] args) {
        int[][] arr = {{1,2},{2,3},{3,4}};

        Arrays.sort(arr, (a,b) -> a[0] - b[0]);
        int dp [] = new int[arr.length];
        Arrays.fill(dp, 1);

        for (int i = 0; i< arr.length ; i++) {
            for(int j = 0; j < i; j++ ) {
                dp[i] = Math.max(dp[i], arr[i][0] > arr[j][1] ? dp[j] +1: dp[j]);
            }
        }

        System.out.println(dp[arr.length -1]);

    }
}
