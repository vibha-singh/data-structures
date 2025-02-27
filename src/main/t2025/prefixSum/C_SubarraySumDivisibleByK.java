package main.t2025.prefixSum;

import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public class C_SubarraySumDivisibleByK {
    public static void main(String[] args) {
          //: Given an array of integers, find the total number of subarrays
        //with a sum divisible by k.

        int[] nums = {4, 5, 0, -2, -3, 1};
        int k = 5;
        System.out.println(subarraySumDivisibleByK(nums, k));

    }

    public static int subarraySumDivisibleByK(int[] arr , int k) {
        //handle for arr null or empty
        if(arr == null || arr.length == 0) return 0;
        int ans = 0;
        //handle scenario for k=0
        if(k == 0) {
            for(Integer num : arr) {
                if(num == 0) {
                    ans += 1;
                }
            }
            return ans;
        }

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        int prefixSum = 0;
        for(int i = 0 ; i < arr.length ; i++) {
            prefixSum += arr[i];
            int remainder = prefixSum % k;
            // handle negative remainder case
            if(remainder < 0) {
                remainder += k;
            }

            if(map.containsKey(remainder)) {
                ans += map.get(remainder);
            }

            map.put(remainder, map.getOrDefault(remainder, 0) +1);
        }
        return ans;

    }
}
