package main.practice.stack;

import java.util.Stack;

public class ConvertToValidParenthesis {

    public static void main(String[] args) {
        String str = "{[][]}(";
        System.out.println(convertToValidParenthesis(str));


    }

    private static String convertToValidParenthesis(String str) {
        Stack<Character> stack = new Stack<>();
        int i = 0;
        int n = str.length();
        StringBuilder sb = new StringBuilder();
        // "{[][]}("
        while(i<n) {
            char curr = str.charAt(i++);

            if( curr == '{' || curr == '[' || curr == '(') {
                stack.push(curr);
            } else {
                if ((curr == '}' && stack.peek() == '{') || (curr == ']' && stack.peek() == '[') || (curr == ')' && stack.peek() == '(')) {
                    sb.append('{');
                    sb.append('}');
                } else {
                    if(stack.peek() == '{') {
                        sb.append('{');
                        sb.append('}');
                    } else if (  stack.peek() == '[') {
                        sb.append('[');
                        sb.append(']');
                    }else if ( stack.peek() == '(') {
                        sb.append('(');
                        sb.append(')');
                    }
                    sb.append(curr);
                    if ( curr == '}' && !isValidParenthesis(sb.toString())) {
                        sb.deleteCharAt(sb.length()-1);
                        sb.append('{');
                        sb.append('}');
                    }  else if ( curr == ']' && !isValidParenthesis(sb.toString())) {
                        sb.deleteCharAt(sb.length()-1);
                        sb.append('[');
                        sb.append(']');
                    }else if ( curr == ')' && !isValidParenthesis(sb.toString())) {
                        sb.deleteCharAt(sb.length()-1);
                        sb.append('(');
                        sb.append(')');
                    }

                }
                stack.pop();
            }
        }
        while(!stack.isEmpty()) {
            if ( stack.peek() == '{' ||stack.peek() == '}' ) {
                sb.append('{');
                sb.append('}');
            } else if ( stack.peek() == '[' || stack.peek() == ']') {
                sb.append('[');
                sb.append(']');
            } else if ( stack.peek() == '(' || stack.peek() == ')') {
                sb.append('(');
                sb.append(')');
            }
            stack.pop();
        }

        return sb.toString();
    }

    private static boolean isValidParenthesis(String brackets) {
        Stack<Character> currStack = new Stack<>();
        int n = brackets.length();
        int i = 0;
        while(i < n ) {
            char curr = brackets.charAt(i++);
            if( curr == '{' || curr == '[' || curr == '(') {
                currStack.push(curr);
            } else {
                if(curr == '}' && currStack.peek() != '{' ||
                        curr == ']' && currStack.peek() != '[' ||
                        curr == ')' && currStack.peek() != '(')
                    return false;
                currStack.pop();
            }
        }
        return currStack.isEmpty();
    }
}
