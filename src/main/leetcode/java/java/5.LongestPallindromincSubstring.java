package main.leetcode.java.java;

/**
 * 5. Longest Palindromic Substring
 * Medium
 *
 * 17846
 *
 * 1062
 *
 * Add to List
 *
 * Share
 * Given a string s, return the longest palindromic substring in s.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "babad"
 * Output: "bab"
 * Explanation: "aba" is also a valid answer.
 * Example 2:
 *
 * Input: s = "cbbd"
 * Output: "bb"
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 1000
 * s consist of only digits and English letters.
 *
 * **/
class LongestPallindromeSubstring {
    public String longestPalindrome(String s) {

        int start = 0 , end =0;
        for(int i = 0; i< s.length(); i++){
            int odd = expand(s,i,i);
            int even = expand(s, i, i+1);

            int len = Math.max(odd,even);
            if(len > end - start){
                start = i - (len-1)/2;
                end = i+ len/2;
            }
        }
        return s.substring(start,end+1);
    }

    int expand(String s, int left, int right){
        while(left >=0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        return right - left - 1;
    }
}