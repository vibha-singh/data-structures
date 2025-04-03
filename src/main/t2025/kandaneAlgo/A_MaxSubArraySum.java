package main.t2025.kandaneAlgo;


/**
 * Problem: Given an array of integers, find the contiguous subarray with the maximum sum.
 * Example:
 * Input: [-2, 1, -3, 4, -1, 2, 1, -5, 4]
 * Output: 6 (from subarray [4, -1, 2, 1])
 * Solution: Use Kadane's algorithm.
 */
public class A_MaxSubArraySum {
    public static void main(String[] args) {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(kandane(arr));
    }

    public static int kandane(int[] arr) {
        if(arr == null || arr.length == 0) return 0;
        int currSum = arr[0];
        int maxSum = arr[0];

        for(int i = 1; i<arr.length; i++) {
            currSum = Math.max(arr[i], arr[i] + currSum);
            maxSum = Math.max(currSum, maxSum);
        }

        return maxSum;
    }
}
