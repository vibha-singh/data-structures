package main.practice.dp;

/**
 * Given two sequences, find the length of longest subsequence present in both of them. Both the strings are of uppercase.
 * Input:
 * A = 6, B = 6
 * str1 = ABCDGH
 * str2 = AEDFHR
 * Output: 3
 * Explanation: LCS for input Sequences
 * “ABCDGH” and “AEDFHR” is “ADH” of
 * length 3.
 */
public class LongestCommonSubsequence {
    public static void main(String[] args) {
        String s1 = "ABCDGH";
        String s2 = "AEDFHR";

        int l1 = s1.length();
        int l2 = s2.length();
        int[][] dp = new int[l1+1][l2+1];
        for(int i = 1; i<=l1;i++) {
           for(int j = 1; j<=l2; j++) {
               if(s1.charAt(i-1) == s2.charAt(j-1)) {
                   dp[i][j] = 1+dp[i-1][j-1];
               } else {
                   dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
               }
           }
        }

        System.out.println(dp[l1][l2]);
        System.out.println(lcs(s1,s2));
    }

    public static int lcs (String s1, String s2) {
        int[] dp = new int [s1.length() +1] ;
        int prev;
        for(int i = 0; i< s1.length(); i++) {
            prev = dp[0];
            for(int j = 1; j < dp.length; j++) {
                int temp = dp[j-1];
                if(s1.charAt(i) != s2.charAt(j-1)) {
                    dp[j]= Math.max(dp[j], dp[j-1]);
                } else {
                    dp[j] = prev +1;
                }
                prev = temp;
            }
        }
        return dp[s1.length()];
    }
}
