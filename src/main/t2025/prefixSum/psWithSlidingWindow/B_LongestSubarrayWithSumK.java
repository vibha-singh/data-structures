package main.t2025.prefixSum.psWithSlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class B_LongestSubarrayWithSumK {
    public static void main(String[] args) {
        int[] arr = {10, 2, -2, -20, 10}; // Example with negative numbers
        int K = -10;
        System.out.println("Length of the longest subarray with sum " + K + ": " + longestSubarrayWithSumK( K, arr));
    }

    /**
     * Below solution will be efficient for all -ve and +ve use cases i.e by using HashMap
     * @param k
     * @param arr
     * @return
     */
    public static int longestSubarrayWithSumK(int k, int[] arr ) {
        Map<Integer, Integer> sumMap = new HashMap<>();
        sumMap.put(0,-1);
        int currSum = 0;
        int maxLength = Integer.MIN_VALUE;

        for(int i = 0; i<arr.length; i++) {
            currSum += arr[i];
            if(currSum == k)
                maxLength = i+1;

            if(sumMap.containsKey(currSum - k )) {
                maxLength = Math.max(maxLength, i - sumMap.get(currSum - k));
            } else {
                sumMap.put(currSum,i);
            }
        }
        return maxLength;
    }


    /**
     * Below solution is not efficient for positive as well as -ve numbs. For min size of array it will work but for max this approach will fail
     * @param arr
     * @param k
     * @return
     */
    public static int longestSubarrayWithSumK(int[] arr, int k) {
        int countMax = Integer.MIN_VALUE;
        int left = 0;
        int currSum = 0;
        for(int right = 0; right < arr.length ; right++){
            currSum += arr[right];
            while (currSum > k && left <= right){
                currSum -= arr[left];
                left++;
            }
            if(currSum == k)
                countMax = Math.max(countMax, right-left+1);
        }

        return countMax;
    }
}
