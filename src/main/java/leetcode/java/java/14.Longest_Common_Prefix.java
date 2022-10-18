package leetcode.java;

import java.util.Arrays;

/**
 * 14. Longest Common Prefix
 * Easy
 *
 * 8515
 *
 * 3107
 *
 * Add to List
 *
 * Share
 * Write a function to find the longest common prefix string amongst an array of strings.
 *
 * If there is no common prefix, return an empty string "".
 *
 *
 *
 * Example 1:
 *
 * Input: strs = ["flower","flow","flight"]
 * Output: "fl"
 * Example 2:
 *
 * Input: strs = ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 *
 *
 * Constraints:
 *
 * 1 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] consists of only lowercase English letters.
 * **/

class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) return "";

        Arrays.sort(strs);
        StringBuilder res = new StringBuilder();
        char[] first = strs[0].toCharArray();
        char[] last = strs[strs.length -1].toCharArray();

        for(int i =0; i<first.length && i < last.length ; i++){
            if(first[i] == last[i]){
                res.append(first[i]);
            }else{
                return res.toString();
            }
        }
        return res.toString();
    }
}