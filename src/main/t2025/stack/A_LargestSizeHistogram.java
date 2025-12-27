package main.t2025.stack;

import java.util.Stack;

public class  A_LargestSizeHistogram {

    public static void main(String[] args) {
        int [] original = { 6, 2, 5, 4, 5, 1, 6 };
        int [] leftSmaller = { 6, 2, 5, 4, 5, 1, 6 };
        int n = original.length;

        int [] rightSmaller = { 6, 2, 5, 4, 5, 1, 6 };
        //1. right smaller element
        Stack<Integer> rightSmallerStack = new Stack<>();
        rightSmaller[n-1] = -1;
        for(int i = n-2; i>=0 ; i--) {
            int curr = rightSmaller[i];
            while (!rightSmallerStack.isEmpty() && rightSmallerStack.peek() >= curr) rightSmallerStack.pop();
            rightSmaller[i] = rightSmallerStack.isEmpty() ? n: rightSmallerStack.peek();
            rightSmallerStack.push(curr);
        }

        for(int i = 0; i<n; i++) {
            System.out.print( rightSmaller[i] +" ");
        }
        System.out.println();

        // left smaller element
        Stack<Integer> leftSmallerStack = new Stack<>();
        leftSmaller[0] = -1;
        for(int i = 1; i<n; i++) {
            int curr = leftSmaller[i];
            while (!leftSmallerStack.isEmpty() && leftSmallerStack.peek() >= curr) leftSmallerStack.pop();
            leftSmaller[i] = leftSmallerStack.isEmpty() ? -1 : leftSmallerStack.peek();
            leftSmallerStack.push(curr);
        }

        for(int i = 0; i<n; i++) {
            System.out.print( leftSmaller[i] +" ");
        }
        System.out.println();
        //largetstHistogram
        int max = Integer.MIN_VALUE;
        for(int i = 0;i<n; i++) {
            // max of (max, actual value * (right smaller - left smaller -1))
            max = Math.max(max, original[i] * (rightSmaller[i] - leftSmaller[i] -1));
        }

        System.out.println(max);
    }
}
