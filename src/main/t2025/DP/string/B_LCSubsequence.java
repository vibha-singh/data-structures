package main.t2025.DP.string;

public class B_LCSubsequence {
    public static void main(String[] args) {
        String text1 = "abcde";
        String text2 = "ace";

        int result = longestCommonSubsequence(text1, text2);
        System.out.println("Length of the longest common subsequence: " + result); // Output: 3
    }

    private static int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m+1][n+1];
        for(int i = 1; i<=m; i++) {
            for(int j = 1; j <= n; j++) {
                if(text1.charAt(i-1) == text2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] +1;

                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[m][n];
    }
}
