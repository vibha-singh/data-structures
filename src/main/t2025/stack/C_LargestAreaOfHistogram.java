package main.t2025.stack;

import java.util.Stack;

public class C_LargestAreaOfHistogram {
    public static void main(String[] args) {
        int[] heights = {2, 1, 5, 6, 2, 3};
        System.out.println(maxArea(heights));
    }

    private static int maxArea(int[] heights) {
        int ans = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i<heights.length; i++) {
            int h = heights[i];
            while (!stack.isEmpty() && h <= heights[stack.peek()]) {
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() -1;
                ans = Math.max(ans, height*width);
            }
            stack.push(i);
        }
        return ans;
    }
}
