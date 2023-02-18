package main.practice.dp.jumpGame;

import java.util.Arrays;

/**
 * Given array of nums which indicate max number of jump from any index. Reach last index in minimum number of moves.
 */
public class JumpGameII {
    public static void main(String[] args) {
        int [] nums = {2,3,1,1,4};
        System.out.println(jump(nums));
    }

    public static int jump(int[] nums) {
        int n = nums.length;
        if(n == 1) return 0;
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        // important don't forget this.
        dp[0] = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 1; j+i < n && j <= nums[i]; j++) {
                dp[i+j] = Math.min(dp[i+j] , dp[i]+1);
            }
        }
        return dp[n-1];
    }
}
