package main.t2025.twoPointer;

public class A_MaximumSumNotExceedingThreshold {
    public static void main(String[] args) {
        // Test with mixed positive and negative numbers
        int[] nums1 = {-2, 5, -1, 7, -3, 2, -1};
        int threshold1 = 10;
        System.out.println("Maximum sum not exceeding " + threshold1 + ": " + maxSumNotExceedingThreshold(nums1, threshold1));

        // Test with all negative numbers
        int[] nums2 = {-3, -1, -5, -2};
        int threshold2 = 2;
        System.out.println("Maximum sum not exceeding " + threshold2 + ": " + maxSumNotExceedingThreshold(nums2, threshold2));

        // Test with a sequence where we need to skip some elements
        int[] nums3 = {3, 4, -7, 1, 5, 2, -3, 8};
        int threshold3 = 7;
        System.out.println("Maximum sum not exceeding " + threshold3 + ": " + maxSumNotExceedingThreshold(nums3, threshold3));

        // Edge case with one element exceeding threshold
        int[] nums4 = {12, 5, 3};
        int threshold4 = 10;
        System.out.println("Maximum sum not exceeding " + threshold4 + ": " + maxSumNotExceedingThreshold(nums4, threshold4));

        // All elements exceeding threshold
        int[] nums5 = {15, 20, 30};
        int threshold5 = 10;
        System.out.println("Maximum sum not exceeding " + threshold5 + ": " + maxSumNotExceedingThreshold(nums5, threshold5));

    }

    private static int maxSumNotExceedingThreshold(int[] arr, int threshold) {
        if(arr == null || arr.length == 0) return 0;
        int left = 0;
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;
        for(int right = 0; right< arr.length ; right++) {
            currSum += arr[right];
            while (currSum > threshold && left<= right) {
                currSum -= arr[left];
                left++;
            }
            maxSum = Math.max(currSum, maxSum);
            // for all -ve numbers
            if(currSum <0 ){
                currSum = 0;
                left = right+1;
            }
        }
        return maxSum == Integer.MIN_VALUE ? 0 : maxSum;
    }

}
