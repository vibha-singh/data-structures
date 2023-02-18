package main.practice.dp;

public class LongestSequenceSuchThatDiffBWAdjIsOne {
    public static void main(String[] args) {
        int N = 7;
        int A[] = {10, 9, 4, 5, 4, 8, 6};
        System.out.println(longestSubsequence(N, A));
    }

    static int longestSubsequence(int n, int arr[]) {
        int dp[] = new int[n];
        for (int i = 0; i < n; i++) dp[i] = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (Math.abs(arr[i] - arr[j]) == 1) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int ma = 0;
        for (int i = 0; i < n; i++) {
            ma = Math.max(ma, dp[i]);
        }
        return ma;
    }
}
