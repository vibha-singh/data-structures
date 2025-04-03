package main.t2025.DP.string;

public class C_LongestPalindromeSubstring {
    public static void main(String[] args) {
        String s = "babad";
        String result = longestPalindrome(s);
        System.out.println("Longest palindromic substring: " + result); // Output: "bab" or "aba"
    }

    private static String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int maxLength = Integer.MIN_VALUE;
        int start = 0;
        // one char string will always be palindrome
        for(int i = 0; i<n; i++) {
            dp[i][i] = true;
        }

        // handle for 2 character palindrome
        for(int i = 0; i<n-1; i++) {
            if(s.charAt(i) == s.charAt(i+1)) {
                dp[i][i+1] = true;
                start = i;
                maxLength = 2;
            }
        }

        // handle substring length more than equals to 3
        for(int len = 3; len <= n ; len++){
            for(int i = 0; i <= n-len; i++) {
                int j = i+ len-1;
                if(s.charAt(i) == s.charAt(j) && dp[i+1][j-1]) { // checking palindrome string in inner substring
                    dp[i][j] = true;
                    if(len > maxLength){
                        start = i;
                        maxLength = len;
                    }
                }
            }
        }
        return s.substring(start, start+maxLength);
    }
}
