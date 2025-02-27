package main.practice2024.StackAndQueue;

import java.util.Stack;

public class NextSmallerElement {
    public static void main(String[] args) {
        int [] original = { 6, 2, 5, 4, 5, 1, 6 };
        int [] arr = { 6, 2, 5, 4, 5, 1, 6 };
        int n = arr.length;

        int [] arr2 = { 6, 2, 5, 4, 5, 1, 6 };

        //right smaller
        Stack<Integer> stack = new Stack<>();
        stack.push(arr[n-1]);
        arr[n-1] = -1;
        for(int i = n-2 ; i >=0; i--) {
            int curr = arr[i];
            while(!stack.isEmpty() && stack.peek() >= curr) stack.pop();
            arr[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(curr);
        }

        for(int i = 0; i<n; i++) {
            System.out.print( arr[i] +" ");
        }

        // left smaller
        Stack<Integer> stack2 = new Stack<>();
        stack2.push(arr2[0]);
        arr2[0] = -1;
        for(int i = 1 ; i < n; i++) {
            int curr = arr2[i];
            while(!stack2.isEmpty() && stack2.peek() >= curr) stack2.pop();
            arr2[i] = stack2.isEmpty() ? -1 : stack2.peek();
            stack2.push(curr);
        }
        System.out.println();
        for(int i = 0; i<n; i++) {
            System.out.print( arr2[i] +" ");
        }

        System.out.println();
        // largest rectangle histogram
        int max = Integer.MIN_VALUE;
        for(int i = 0; i< n ; i++) {
                max = Math.max(max, original[i]*(arr[i] - arr2[i] -1) );
        }

        System.out.println(max);
    }
}
