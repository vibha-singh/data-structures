package main.t2025.slidingWindow;

public class A_MaxSumWithSizeK {
    public static void main(String[] args) {
        int[] arr = { 2, -1, 5, -3, 6, -2 }; // Example with mixed positive and negative numbers
        int k = 3;
        System.out.println("Maximum sum of a subarray of size " + k + " is: " + maxSumSizeK(arr, k));
    }

    public static int maxSumSizeK(int [] arr, int k) {
        if(arr == null || arr.length == 0) return 0;

        int windowSum = 0;
        int maxSum = 0;
        for(int i = 0; i<k ; i++) {
            windowSum += arr[i];
        }
        maxSum = windowSum;

        for (int i = k; i< arr.length ; i++) {
            windowSum = arr[i] + windowSum - arr[i-k];
            maxSum = Math.max(windowSum, maxSum);
        }

        return maxSum;
    }
}
