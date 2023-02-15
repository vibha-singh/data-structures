package main.practice.stack;

import java.util.Stack;

public class ValidParenthesis {
    public static void main(String[] args) {
        String brackets = "{[][]}()";
        System.out.println(isValidParenthesis(brackets));
        System.out.println(isValidParenthesis("{[][]}("));
    }

    private static boolean isValidParenthesis(String brackets) {
        Stack<Character> stack = new Stack<>();
        int n = brackets.length();
        int i = 0;
        while(i < n ) {
            char curr = brackets.charAt(i++);
            if( curr == '{' || curr == '[' || curr == '(') {
                stack.push(curr);
            } else {
                if(curr == '}' && stack.peek() != '{' ||
                        curr == ']' && stack.peek() != '[' ||
                        curr == ')' && stack.peek() != '(')
                    return false;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
