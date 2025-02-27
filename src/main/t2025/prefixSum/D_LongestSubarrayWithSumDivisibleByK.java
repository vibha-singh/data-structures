package main.t2025.prefixSum;

import java.util.HashMap;
import java.util.Map;

public class D_LongestSubarrayWithSumDivisibleByK {
    public static void main(String[] args) {
        int[] nums = {2, 7, 6, 1, 4, 5};
        int k = 3;
        System.out.println(longestSubarrayWithSumDivisibleByK(nums, k));
    }

    public static int longestSubarrayWithSumDivisibleByK(int[] arr, int k) {
        int maxLength = 0;
        if(k == 0) {
            int currLength = 0;
            for(Integer num : arr) {
                if(num == 0){
                    currLength++;
                    maxLength = Math.max(currLength, maxLength);
                } else {
                    currLength = 0;
                }
            }
            return maxLength;
        }

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int prefixSum = 0;

        for(int i = 0; i< arr.length; i++) {
            prefixSum += arr[i];
            int remainder = prefixSum % k;

            if(remainder < 0) {
                remainder += k;
            }

            if(map.containsKey(remainder)) {
                int currLength = i - map.get(remainder);
                maxLength = Math.max(currLength, maxLength);
            } else {
                map.put(remainder, i);
            }
        }
        return maxLength;
    }
}
