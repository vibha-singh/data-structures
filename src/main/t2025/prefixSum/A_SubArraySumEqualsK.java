package main.t2025.prefixSum;

import java.util.HashMap;
import java.util.Map;

/**
 * 1. Subarray Sum Equals K
 *  Problem: Given an array of integers, find the total number of subarrays
 * with a sum equal to k.
 *  Example:
 * ▪ Input: nums = [1, 1, 1], k = 2
 * ▪ Output: 2 (subarrays [1, 1] and [1, 1])
 *
 * Initialization:
 * prefix_sum_map is initialized with {0: 1} because a prefix sum of 0 occurs once before the array starts.
 * current_sum keeps track of the cumulative sum up to the current index.
 * count keeps track of the number of subarrays with sum k.
 * Iterate Through the Array:
 * For each element in the array, update current_sum by adding the current element.
 * Check for Subarrays:
 * If (current_sum - k) exists in prefix_sum_map, it means there are subarrays ending at the current index with sum k.
 * Increment count by the frequency of (current_sum - k).
 * Update the Hash Map:
 * Update the frequency of the current prefix sum in prefix_sum_map.
 * Return the Result:
 * After processing all elements, return count.
 *
 */
public class A_SubArraySumEqualsK {

    public static void main(String[] args) {
        //Given an array of integers, find the total number of subarrays with a sum equal to k.
        int [] arr = {1, -1, 0, 1, -1, 0};
        int k = 0;
        System.out.println(subArraySumEqualsK(arr,k ));
    }

    public static int subArraySumEqualsK(int[] arr, int k) {
        if(arr == null || arr.length == 0) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,1);

        int countOfSubArrSize = 0;
        int currSum = 0;

        for(int i = 0; i < arr.length ; i++ ){
            currSum += arr[i];
            if(map.containsKey(currSum - k)){
                countOfSubArrSize += map.get(currSum - k);
            }
            map.put(currSum, map.getOrDefault(currSum, 0)+1);
        }
        return  countOfSubArrSize;
    }
}
