package main.t2025.slidingWindow;

public class A_MinimumSizeSubarraySum {
    public static void main(String[] args) {
        //Given an array of positive integers nums and a target sum k, find the length of the smallest subarray (contiguous elements) whose sum is greater than or equal to k. If no such subarray exists, return 0.
        int[] nums1 = {2, 3, 1, 2, 4, 3};
        int k1 = 7;
        System.out.println(minimumSizeSubarraySum( nums1, k1));  // Output: 2 (subarray [4, 3])

        // Example 2: With Negative Numbers
        int[] nums2 = {2, -1, 3, 1, 2, 4, -3};
        int k2 = 7;
        System.out.println(minimumSizeSubarraySum( nums2, k2));  // Output: 3 (subarray [3, 1, 2])

        // Example 3: No valid subarray
        int[] nums3 = {1, 1, 1, 1};
        int k3 = 5;
        System.out.println(minimumSizeSubarraySum( nums3, k3));  // Output: 0 (no subarray with sum ≥ 5)
    }

    private static int minimumSizeSubarraySum(int[] arr, int k) {
        int currSum = 0;
        int minCount = Integer.MAX_VALUE;
        int left = 0;
        for(int right = 0; right < arr.length ; right++) {
            currSum += arr[right];

            while(currSum >= k && left <= right) {
                currSum -= arr[left];
                minCount = Math.min(minCount, right-left+1);
                left++;
            }
        }


        return minCount == Integer.MAX_VALUE ? 0: minCount;

    }
}
