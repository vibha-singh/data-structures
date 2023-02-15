package main.practice.dp.houseRobber;

/**
 * Given an array of Number representing money, find maximum amount, that can be robbed without choosing the adjacent houses.
 */
public class HouseRobberI {
    public static void main(String[] args) {
        int nums[] = {2,7,9,3,1};
        int res = maximumAmountRobbed(nums, nums.length);
        System.out.println(res);
    }

    private static int maximumAmountRobbed(int[] nums, int n) {
        int dp[] ;
        if(n == 1) return nums[0];
        else if(n == 2) return Math.max(nums[0], nums[1]);
        else {
            dp = new int[n+1];
            dp[0] = nums[0];
            dp[1] = Math.max(nums[0], nums[1]);
            for(int i = 2; i<n; i++) {
                dp[i] = Math.max(nums[i]+dp[i-2], dp[i-1]);
            }

            return dp[n-1];
        }
    }
}
