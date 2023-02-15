package main.practice.dp.houseRobber;

import java.util.Arrays;

/**
 * Given an array of Number representing money, find maximum amount, that can be robbed without choosing the adjacent houses.
 * Houses are in circle, which means
 * 1) if we start from 1st house, then we cannot rob last house
 * 2) if we start from last house, then we cannot rob 1st house
 */
public class HouseRobberII {
    public static void main(String[] args) {
        int nums[] = {2,7,9,3,1};
        int res = maximumAmtRobCyclic(nums, nums.length);
        System.out.println(res);
    }

    private static int maximumAmtRobCyclic(int[] nums, int n) {
        if(n == 0) return 0;
        if(n == 1) return nums[0];
        if(n == 2) return Math.max(nums[0], nums[1]);
        int zeroRobbing = robbing(nums, 0, nums.length-2);
        int firstRobbing = robbing(nums, 0, nums.length-1);
        return Math.max(zeroRobbing, firstRobbing);
    }

    static int robbing(int[] nums, int start, int end) {
       if(start == end) return nums[start];
       int dp[] = new int[nums.length];
       dp[start] = nums[start];
       dp[start+1] = Math.max(nums[start+1], nums[start]);
       for(int i = start+2; i<=end; i++)
           dp[i] = Math.max(nums[i]+dp[i-2], dp[i-1]);
       return dp[end];
    }


}
