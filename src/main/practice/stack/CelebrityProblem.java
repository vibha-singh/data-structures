package main.practice.stack;

import java.util.Stack;

/**
 * A celebrity is a person, who is known to everone and knows none.
 * Given a square matrix and if ith person knows jth then M[i][j] = 1 else 0
 */
public class CelebrityProblem {

    public static void main(String[] args) {
        int[][] M = {{0,1,0},{0,0,0},{0,1,0}};
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i<M.length; i++){
            stack.push(i);
        }

        while(stack.size() >1) {
            int A = stack.peek();
            stack.pop();
            int B = stack.peek();
            stack.pop();

            if(M[A][B] ==1) {
                stack.push(B);
            } else {
                stack.push(A);
            }
        }
        int celeb = stack.peek();
        int ans = 0;
        for(int i = 0; i<M.length; i++) {
            if(i != celeb && (M[i][celeb] == 0 || M[celeb][i] == 1)) ans = -1;
        }
        ans = celeb;
        System.out.println(ans);
    }
}
