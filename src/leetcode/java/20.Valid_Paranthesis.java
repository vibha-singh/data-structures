package leetcode.java;

import java.util.HashMap;
import java.util.Stack;

/**
 * 20. Valid Parentheses
 * Easy
 *
 * 13224
 *
 * 589
 *
 * Add to List
 *
 * Share
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 *
 *
 * Example 1:
 *
 * Input: s = "()"
 * Output: true
 * Example 2:
 *
 * Input: s = "()[]{}"
 * Output: true
 * Example 3:
 *
 * Input: s = "(]"
 * Output: false
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 104
 * s consists of parentheses only '()[]{}'.
 * **/

class Valid_Paranthesis {
    public boolean isValid(String s) {
        Stack<Character> seen = new Stack();

        HashMap<Character,Character> opposites = new HashMap();
        opposites.put('(',')');
        opposites.put('[',']');
        opposites.put('{','}');

        for(int i = 0; i< s.length(); i++){
            char curr = s.charAt(i);

            if(opposites.containsKey(curr)){
                seen.push(opposites.get(curr));
            }else{
                if(seen.isEmpty() || seen.pop() != curr)
                    return false;
            }
        }

        return seen.isEmpty();

    }
}