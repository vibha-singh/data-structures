package main.practice.stack;

import java.util.Stack;

/**
 * Given price quotes of stock for n days we need to find span of stock on any particular days.
 * Maximum number of consecutive days for which price <= curr day's price
 */
public class StockSpanProblem {

    public static void main(String[] args) {
        int arr[] = {100, 80, 60, 70,60, 75, 85};
        int span[] = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        span[0] = 1;
        for(int i = 1; i< arr.length; i++) {
            int curr = arr[i];

            while(!stack.isEmpty() && curr >= arr[stack.peek()]) stack.pop();

            if(stack.isEmpty()){
                span[i] = i+1;
            } else {
                span[i] = i- stack.peek();
            }
            stack.push(i);
        }
       for(int i = 0; i < span.length; i++) {
           System.out.print( span[i]+" ");
       }
    }
}
