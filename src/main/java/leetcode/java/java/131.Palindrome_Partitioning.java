package leetcode.java;

import java.util.ArrayList;
import java.util.List;

/**
 * 131. Palindrome Partitioning
 * Medium
 *
 * 7036
 *
 * 223
 *
 * Add to List
 *
 * Share
 * Given a string s, partition s such that every substring of the partition is a palindrome. Return all possible palindrome partitioning of s.
 *
 * A palindrome string is a string that reads the same backward as forward.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "aab"
 * Output: [["a","a","b"],["aa","b"]]
 * Example 2:
 *
 * Input: s = "a"
 * Output: [["a"]]
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 16
 * s contains only lowercase English letters.
 * **/

class PalindromePartitioning{
    List<List<Integer>> result = new ArrayList();
    public List<List<Integer>> PalindromePartitioning(String s){
        dfs(s,0,new ArrayList());
        return result;
    }

    void dfs(String s, int start, List<String> list){
        if(s.length() == start) {
            result.add(new ArrayList(list));
            return;
        }

        for(int i = start; i< s.length() ; i++) {
            if(isPalindrome(s,start,i)){
                list.add(s.substring(start,i+1));
                dfs(s, i+1,list);
                list.remove(list.size()-1);
            }
        }
    }

    boolean isPalindrome(String s, int start, int end){
        while(start < end){
            if(s.charAt(start) != s.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }
}