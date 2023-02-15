package main.practice.stack;

import java.util.ArrayList;
import java.util.Stack;

/**
 * +ve sign = right direction
 * -ve sign = left direction
 * [10,6,-8,-8,8,9] - 10 and 6 will not collide, 6 and -8 will collide and 6 is removed, 10 and -8 will collide and -8 is removed,
 * again 10 and -8 will collide and -8 will be removed , 8 and 9 is positive so ans is [10,8,9]
 */
public class AsteroidCollistion {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        int [] arr = {10,6,-8,-8,8,9};
       for(int i = 0; i<arr.length ; i++){
           int a = arr[i];
           if(stack.isEmpty() || a>0) stack.push(a);
           else {
               while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() <= Math.abs(a)) {
                   stack.pop();
               }

               if(!stack.isEmpty() && stack.peek() + a == 0) stack.pop();
               // [-2,-1,1,2] ans should be [-2,-1,1,2] for this check we have added below statement
               else if(stack.isEmpty() || stack.peek()<0) stack.push(a);
           }
       }
       int [] ans = new int[stack.size()];
       int i = stack.size()-1;
       while(!stack.isEmpty()) {
           ans[i] = stack.peek();
           stack.pop();
           i--;
       }

        for(int j = 0; j<ans.length; j++) {
            System.out.print(ans[j] + " ");
        }

    }
}
