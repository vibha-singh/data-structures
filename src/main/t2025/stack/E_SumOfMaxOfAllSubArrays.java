package main.t2025.stack;

import java.util.Stack;

public class E_SumOfMaxOfAllSubArrays {
    public static void main(String[] args) {
        int[] arr = {3, 1, 2, 4};
        System.out.println("Sum of subarray maximum: " + sumOfMaxOfAllSubArrays(arr));
    }

    public static int sumOfMaxOfAllSubArrays(int [] arr) {
        Stack<int[]> stack = new Stack<>();
        int total = 0;
        int sum = 0;
        for(int i = 0; i<arr.length; i++) {
            int count = 1;
            int num = arr[i];
            while(!stack.isEmpty() && stack.peek()[0] <= num) {
                int[] top = stack.pop();
                count += top[1];
                total -= top[0] * count;
            }
            stack.push(new int[]{num, count});
            total += num * count;
            sum += total;
        }
        return sum;
    }
}
