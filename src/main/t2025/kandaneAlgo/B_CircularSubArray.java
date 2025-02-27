package main.t2025.kandaneAlgo;

/**
 * To find the maximum circular subarray sum, we need to consider two scenarios:
 * The maximum sum subarray is non-circular (i.e., it lies within the array without wrapping around).
 * The maximum sum subarray is circular (i.e., it wraps around the array).
 * The overall maximum sum will be the maximum of these two cases.
 * Steps:
     * Use Kadane's algorithm to find the maximum non-circular subarray sum.
     * Calculate the total sum of the array.
     * Use Kadane's algorithm to find the minimum subarray sum.
     * The maximum circular sum will be the total sum minus the minimum subarray sum.
     * Handle the edge case where all elements are negative (in this case, the maximum sum is the maximum element in the array).
 */
public class B_CircularSubArray {
    public static void main(String[] args) {
        int[] arr = { 8, -1, 3, 4};
        System.out.println(maxSumCircularArray(arr));
    }

    public static int maxSumCircularArray(int[] arr) {
        int maxSum = A_MaxSubArraySum.kandane(arr);
        if(maxSum == 0) return 0;

        int currMinSum = arr[0];
        int minSum = arr[0];
        int totalSum = arr[0];

        for(int i = 1; i<arr.length; i++) {
            totalSum += arr[i];

            currMinSum = Math.min(arr[i] , currMinSum + arr[i]);
            minSum = Math.min(currMinSum, minSum);
        }
        // Edge case: If all elements are negative, return the maximum sum
        // Maximum circular sum is the maximum of:
            // 1. Maximum non-circular sum
            // 2. Total sum minus minimum subarray sum
        return totalSum == minSum ? maxSum : Math.max(maxSum, totalSum - minSum);
    }
}
