package main.t2025.DP.string;

public class D_LongestPalindromeSubsequence {
    public static void main(String[] args) {

    }
}

/**
 * 4. Space-Optimized Dynamic Programming
 * This approach reduces the space complexity to O(n) by using a 1D array instead of a 2D array.
 * TC: 0(n^2) SC: 0(n)
 *
 * public class LPS {
 *     public static int longestPalindromicSubsequence(String s) {
 *         int n = s.length();
 *         int[] dp = new int[n];
 *         Arrays.fill(dp, 1);
 *
 *         for (int i = n - 1; i >= 0; i--) {
 *             int prev = 0;
 *             for (int j = i + 1; j < n; j++) {
 *                 int temp = dp[j];
 *                 if (s.charAt(i) == s.charAt(j)) {
 *                     dp[j] = 2 + prev;
 *                 } else {
 *                     dp[j] = Math.max(dp[j], dp[j - 1]);
 *                 }
 *                 prev = temp;
 *             }
 *         }
 *
 *         return dp[n - 1];
 *     }
 *
 *     public static void main(String[] args) {
 *         String s = "bbbab";
 *         System.out.println("Length of LPS: " + longestPalindromicSubsequence(s));
 *     }
 * }
 *
 *
 *
 * 5. Using Longest Common Subsequence (LCS)
 * The LPS of a string is the same as the LCS of the string and its reverse. Time complexity: O(n^2).
 *
 * TC: 0(n^2) SC: 0(n^2)
 * public class LPS {
 *     public static int longestCommonSubsequence(String s1, String s2) {
 *         int m = s1.length(), n = s2.length();
 *         int[][] dp = new int[m + 1][n + 1];
 *
 *         for (int i = 1; i <= m; i++) {
 *             for (int j = 1; j <= n; j++) {
 *                 if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
 *                     dp[i][j] = 1 + dp[i - 1][j - 1];
 *                 } else {
 *                     dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
 *                 }
 *             }
 *         }
 *
 *         return dp[m][n];
 *     }
 *
 *     public static int longestPalindromicSubsequence(String s) {
 *         String reversed = new StringBuilder(s).reverse().toString();
 *         return longestCommonSubsequence(s, reversed);
 *     }
 *
 *     public static void main(String[] args) {
 *         String s = "bbbab";
 *         System.out.println("Length of LPS: " + longestPalindromicSubsequence(s));
 *     }
 * }
 */
