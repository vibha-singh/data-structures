package leetcode.java;

import java.util.HashSet;
import java.util.Set;

/**
 * 409. Longest Palindrome
 * Easy
 *
 * 2817
 *
 * 161
 *
 * Add to List
 *
 * Share
 * Given a string s which consists of lowercase or uppercase letters, return the length of the longest palindrome that can be built with those letters.
 *
 * Letters are case sensitive, for example, "Aa" is not considered a palindrome here.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abccccdd"
 * Output: 7
 * Explanation:
 * One longest palindrome that can be built is "dccaccd", whose length is 7.
 * Example 2:
 *
 * Input: s = "a"
 * Output: 1
 * Example 3:
 *
 * Input: s = "bb"
 * Output: 2
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 2000
 * s consists of lowercase and/or uppercase English letters only.
 * **/

class LongestPallindrome{
    public int longestPallindromeSize(String s ){
        int i = 0;
        int count = 0;
        Set<Character> set = new HashSet();
        while(i < s.length()){
            Character c = s.charAt(i);
            if(!set.contains(c)){
                set.add(c);
            } else{
                set.remove(c);
                count +=2;
            }
            i++;
        }
        return set.isEmpty() ? count : count +1;
    }
}