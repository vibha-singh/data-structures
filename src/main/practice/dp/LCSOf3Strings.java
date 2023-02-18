package main.practice.dp;

/**
 *Given 3 strings A, B and C, the task is to find the longest common sub-sequence in all three given sequences.
 *
 * Input:
 * A = "geeks", B = "geeksfor",
 * C = "geeksforgeeks"
 * Output: 5
 * Explanation: "geeks"is the longest common
 * subsequence with length 5.
 */
public class LCSOf3Strings {
    public static void main(String[] args) {
        String s1 = "geeks";
        String s2 = "geeksfor";
        String s3 = "geeksforgeeks";
        System.out.println(LCSof3(s1, s2, s3, s1.length(), s2.length(), s3.length()));

    }

    static int LCSof3(String A, String B, String C, int n1, int n2, int n3) {
        int[][][] dp = new int[n1 + 1][n2 + 1][n3 + 1];
        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                for (int k = 1; k <= n3; k++) {
                    if (A.charAt(i - 1) == B.charAt(j - 1) && B.charAt(j - 1) == C.charAt(k - 1))
                        dp[i][j][k] = 1 + dp[i - 1][j - 1][k - 1];
                    else
                        dp[i][j][k] = Math.max(dp[i - 1][j][k], Math.max(dp[i][j - 1][k], dp[i][j][k - 1]));
                }
            }
        }
        return dp[n1][n2][n3];
    }
}
