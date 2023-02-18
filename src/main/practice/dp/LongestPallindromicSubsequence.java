package main.practice.dp;

public class LongestPallindromicSubsequence {
    public static void main(String[] args) {
        String s1 = "GEEKSFORGEEKS";
        String s2 = reverseString(s1);
        System.out.println(LCS(s1, s2));
    }

    static int LCS(String s1, String s2) {
        int[] dp = new int[s1.length()+1];
        for(int i = 0; i<s1.length(); i++) {
            int prev = dp[0];
            for(int  j = 1; j< dp.length; j++) {
                int temp = dp[j];
                if(s1.charAt(i) != s2.charAt(j-1)) {
                    dp[j] = Math.max(dp[j-1], dp[j]);
                } else {
                    dp[j] = prev +1;
                }
                prev = temp;
            }
        }
        return dp[dp.length -1];
    }

    static String reverseString(String s){
        int start = 0;
        int end = s.length()-1;
        char[] chars = s.toCharArray();
        while(start < end) {
            char c = s.charAt(start);
            chars[start] = chars[end];
            chars[end] = c;
            start++;
            end--;
        }
        return String.valueOf(chars);
    }
}
