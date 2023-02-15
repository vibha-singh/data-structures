package main.practice.stack;

import java.util.Stack;

/**
 * [2,4,1,3,1,6] ans : [4,6,3,6,6,-1]
 *
 * 1) Iterate from last amd compare its value with top of stack
 * 2) If stack is greater then its the next greater element
 * 3)  else keep popping till the next greater element is found
 */
public class NextGreaterElement {
    public static void main(String[] args) {
        int[] arr = {2,4,1,3,1,6};

        Stack<Integer> stack = new Stack<>();
        int n = arr.length-1;
        stack.add(arr[n]);
        arr[n] = -1;
        for(int i = n-1; i>=0; i--) {
            int currVal = arr[i];
            while(!stack.isEmpty() && stack.peek() <= currVal) stack.pop();
            arr[i] = stack.isEmpty() ? -1: stack.peek();
            stack.push(currVal);
        }

        for(int i = 0; i<= n; i++) {
            System.out.print(arr[i] +" ");
        }
    }
}
