package main.t2025.prefixSum;

import java.util.HashMap;
import java.util.Map;

/**
 * Continuous Subarray Sum
 * o Problem: Given an array of integers, check if there is a subarray of size at
 * least 2 with a sum that is a multiple of k.
 * o Example:
 * ▪ Input: nums = [23, 2, 4, 6, 7], k = 6
 * ▪ Output: True (subarray [2, 4] sums to 6)
 */
public class B_Continuous_Subarray_Sum {
    public static void main(String[] args) {
        int [] arr = {23, 2, 4, 6, 7} ;
        int atLeastSizeOfSubArray = 2;
        int k = 6;

        System.out.println(continuousSubarraySum (arr,k, atLeastSizeOfSubArray));
    }

    private static boolean continuousSubarraySum(int[] arr, int k, int l) {
        //handle if k = 0;
        if(k ==0) {
            for (int i = 0; i < arr.length - 1; i++) {
                //this handle is only for l == 2
                if (arr[i] == 0 && arr[i + 1] == 0) return true;
            }
        }

        //remainder prefixMap;
        Map<Integer, Integer> prefixMap = new HashMap<>();
        int prefixSum = 0;
        prefixMap.put(0,-1);

        for(int i = 0; i < arr.length ; i++) {
            prefixSum += arr[i];
            int remainder = prefixSum % k;
            // handle -ve remainder scenario
            if(remainder < 0) {
                remainder += k;
            }

            if(prefixMap.containsKey(remainder) && (i - prefixMap.get(remainder)) > l-1) {
                return true;
            } else {
                prefixMap.put(remainder, i);
            }
         }

        return false;
    }
}
