package main.t2025.twoPointer.sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 *
 * Notice that the solution set must not contain duplicate triplets.
 * Example 1:
 *
 * Input: nums = [-1,0,1,2,-1,-4]
 * Output: [[-1,-1,2],[-1,0,1]]
 * Explanation:
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
 * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
 * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
 * The distinct triplets are [-1,0,1] and [-1,-1,2].
 * Notice that the order of the output and the order of the triplets does not matter.
 */
public class B_3Sum {
    public static void main(String[] args) {
        int [] nums = {-1,0,1,2,-1,-4};
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();

        for(int i = 0 ; i < nums.length; i++) {
            if(i>0 && nums[i] == nums[i-1] ) continue;
            int j = i+1;
            int k = nums.length-1;

            while(j < k) {
                int total = nums[i] + nums[j] + nums[k];
                if(total < 0) {
                    j++;
                } else if(total > 0) {
                    k--;
                } else {
                    ans.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    while(nums[j] == nums[j-1]) {
                        j++;
                    }
                }
            }
        }
        System.out.println(ans);
    }
}
