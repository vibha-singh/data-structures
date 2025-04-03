package main.t2025.stack;

import java.util.Stack;

/**
 * Input: A = [3, 1, 2, 4]
 * Output: 17
 * Explanation: Subarrays are [3], [1], [2], [4], [3, 1], [1, 2], [2, 4], [3, 1, 2], [1, 2, 4], [3, 1, 2, 4].
 * Minimums are 3, 1, 2, 4, 1, 1, 2, 1, 1, 1. Sum is 17.
 *
 *
 * Input : A = [1, 2, 3, 4]
 * Output: 20
 */
public class D_SumOfMinOfAllSubArrays {
    public static void main(String[] args) {
        int[] arr = {3, 1, 2, 4};
        System.out.println("Sum of subarray minimums: " + sumSubarrayMins(arr)); // Output: 17
    }
    public static int sumSubarrayMins(int[] arr) {
        int MOD = (int) 1e9 + 7; // Modulo to handle large numbers
        Stack<int[]> stack = new Stack<>(); // Stack to store pairs (value, count)
        int sum = 0;
        int total = 0; // Running total of subarray minimums

        for (int num : arr) {
            int count = 1; // Initialize count for the current element
            // Pop elements from the stack that are greater than or equal to the current element
            while (!stack.isEmpty() && stack.peek()[0] >= num) {
                int[] top = stack.pop();
                count += top[1]; // Add the count of the popped element
                total -= top[0] * top[1]; // Remove the contribution of the popped element
            }
            stack.push(new int[]{num, count}); // Push the current element and its count
            total += num * count; // Add the contribution of the current element
            sum = (sum + total) % MOD; // Update the sum
        }

        return sum;
    }

}
