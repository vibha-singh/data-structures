package main.t2025.twoPointer.sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:
 * 0 <= a, b, c, d < n
 * a, b, c, and d are distinct.
 * nums[a] + nums[b] + nums[c] + nums[d] == target
 * You may return the answer in any order.
 * Example 1:
 *
 * Input: nums = [1,0,-1,0,-2,2], target = 0
 * Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
 */
public class C_4Sum {
    public static void main(String[] args) {
        int[] nums = {1,0,-1,0,-2,2};
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0; i < nums.length -3 ; i++) {
            if(i > 0 && nums[i] == nums[i-1]) continue;
            for(int j = i+1; j < nums.length - 2 ; j++ ) {
                if(j > i+1 && nums[j] == nums[j-1]) continue;
                int k = j+1;
                int l = nums.length-1;


                while(k < l){
                    int total = nums[i] + nums[j] + nums[k] +nums[l];
                    if(total < 0) {
                       k++;
                    } else if(total > 0) {
                        l--;
                    } else {
                        ans.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                        k++;
                        l--;

                        while (k < l && nums[k - 1] == nums[k]) k++;

                        while (k < l && nums[l + 1] == nums[l]) l--;
                    }
                }
            }
        }
        System.out.println(ans);
    }
}
