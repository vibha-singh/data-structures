package main.leetcode.java.java;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * You can return the answer in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 * Example 2:
 *
 * Input: nums = [3,2,4], target = 6
 * Output: [1,2]
 * Example 3:
 *
 * Input: nums = [3,3], target = 6
 * Output: [0,1]
 */

class Two_Sum_1 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap();
        int [] result = new int[2];

        for(int i = 0; i< nums.length; i++){
            map.put(nums[i], i);
        }
        for(int i = 0; i< nums.length; i++){

            int num = nums[i];
            int rem = target - num;


            if(map.containsKey(rem)){
                int index = map.get(rem);
                if(index == i)
                    continue;
                result[0] = index;
                result[1] = i;
                return result;
            }
        }
        return  result;
    }
}
