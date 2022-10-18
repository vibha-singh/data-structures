package leetcode.java;

/**
 * 680. Valid Palindrome II
 * Easy
 *
 * 5776
 *
 * 310
 *
 * Add to List
 *
 * Share
 * Given a string s, return true if the s can be palindrome after deleting at most one character from it.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "aba"
 * Output: true
 * Example 2:
 *
 * Input: s = "abca"
 * Output: true
 * Explanation: You could delete the character 'c'.
 * Example 3:
 *
 * Input: s = "abc"
 * Output: false
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 105
 * s consists of lowercase English letters.
 * **/

class ValidPallindromeII{
    public boolean validPallindrome(String s){
        int start = 0;
        int end = s.length() -1;
        while(start<end){
            if(s.charAt(start) == s.charAt(end)){
                start++;
                end--;
            }else{
                return isPallindrome(s, start+1, end) || isPallindrome(s, start, end-1);
            }
        }
        return true;
    }

    public boolean isPallindrome(String s, int start, int end){
        while(start < end){
            if(s.charAt(start) == s.charAt(end)){
                start++;
                end--;
            } else{
                return false;
            }
        }
        return true;
    }
}