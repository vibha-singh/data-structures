package main.t2025.DP.integer;

import com.sun.source.tree.Tree;

import java.util.*;

public class A_LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println("Length of LIS: " + longestIncreasingSubsequence(nums));
        System.out.println(LIS(nums));

    }

    private static int longestIncreasingSubsequence(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n+1];
        int maxLength = 1;
        Arrays.fill(dp, 1);
        for(int i = 1; i<n; i++) {
            for(int j = 0; j<i; j++) {
                if(nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            maxLength = Math.max(dp[i], maxLength);
        }
        return maxLength;
    }

    private static List<Integer> LIS(int[] nums) {
        int n = nums.length;
        int maxIndex = 0;
        int [] groupSize = new int[n];
        int [] prevIndex = new int[n];
        for(int i = 0; i<n; i++) {
            groupSize[i] = 1;
            prevIndex[i] = -1;
            for(int j = 0; j<i; j++) {
                if(nums[j] < nums[i]) {
                    if(groupSize[i] < groupSize[j]+1) {
                        groupSize[i] = groupSize[j]+1;
                        prevIndex[i] = j;
                    }
                }
            }
            if(groupSize[i] > groupSize[maxIndex])
                maxIndex = i;
        }

        List<Integer> ans = new ArrayList<>();
        while(maxIndex != -1) {
            ans.add(nums[maxIndex]);
            maxIndex = prevIndex[maxIndex];
        }
        return ans;
    }


}
