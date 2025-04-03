package main.t2025.DP;

public class C_HouseRobber {
    public static void main(String[] args) {
        int[] nums = {2, 7, 9, 3, 1};
        System.out.println("Maximum amount robbed: " + rob(nums));
    }

    private static int rob(int[] nums) {
        int prev1 = nums[0];
        int prev2 = Math.max(nums[0], nums[1]);
        for(int i = 2; i < nums.length ; i++) {
          int curr = Math.max(prev2, prev1 + nums[i]);
          prev1 = prev2;
          prev2 = curr;
        }
        return prev2;
    }
}
