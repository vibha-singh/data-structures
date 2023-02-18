package main.practice;

public class MaxSubseqSumNo3AreConsecutive {
    public static void main(String[] args) {
        int[] arr = {3000, 2000, 1000, 3, 10};
        int[] dp = new int[arr.length];
        int n = arr.length;
        /**
         * We have three cases
         * 1) Exclude arr[i],  i.e.,  dp[i] = dp[i-1]
         * 2) Exclude arr[i-1], i.e., dp[i] = dp[i-2] + arr[i]
         * 3) Exclude arr[i-2], i.e., dp[i-3] + arr[i] + arr[i-1]
         * sum[i] = max(dp[i-1], dp[i-2] + arr[i],
         *              dp[i-3] + arr[i] + arr[i-1])
         */

        if (n >= 1) dp[0] = arr[0];
        if (n >= 2) dp[1] = arr[0] + arr[1];

        if (n > 2) dp[2] = Math.max(Math.max(arr[0] + arr[2], arr[1] + arr[2]), dp[1]);
        for (int i = 3; i < arr.length; i++) {
            dp[i] = Math.max(Math.max(dp[i - 1], dp[i - 2] + arr[i]),
                    arr[i] + arr[i - 1] + dp[i - 3]);
        }

        System.out.println(dp[n-1]);
    }
}
