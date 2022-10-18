package leetcode.java;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. Generate Parentheses
 * Medium
 *
 * 13020
 *
 * 498
 *
 * Add to List
 *
 * Share
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 3
 * Output: ["((()))","(()())","(())()","()(())","()()()"]
 * Example 2:
 *
 * Input: n = 1
 * Output: ["()"]
 *
 *
 * Constraints:
 *
 * 1 <= n <= 8
 **/


class GenerateParenthesis {
    public List<String> generateParenthesis(int n) {

        List<String> outputArr = new ArrayList();
        backtrack(outputArr, "", 0, 0, n);
        return outputArr;

    }

    private void backtrack(List<String> outputArr, String str, int open, int close, int max){
        if(str.length() == max*2){
            outputArr.add(str);
            return;
        }

        if(open < max) backtrack(outputArr, str+"(" , open+1, close, max);
        if(close < open) backtrack(outputArr, str+")", open, close+1, max);

    }
}