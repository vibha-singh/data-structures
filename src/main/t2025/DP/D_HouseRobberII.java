package main.t2025.DP;

public class D_HouseRobberII {
    public static int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];

        // Case 1: Exclude the last house
        int rob1 = robHelper(nums, 0, n - 2);
        // Case 2: Exclude the first house
        int rob2 = robHelper(nums, 1, n - 1);

        // Return the maximum of the two cases
        return Math.max(rob1, rob2);
    }

    // Helper function to solve the classic House Robber problem for a given range
    private static int robHelper(int[] nums, int start, int end) {
        if (start == end) return nums[start];

        int prev1 = nums[start]; // Maximum amount if we rob the first house in the range
        int prev2 = Math.max(nums[start], nums[start + 1]); // Maximum amount if we rob the first or second house

        for (int i = start + 2; i <= end; i++) {
            int current = Math.max(prev2, prev1 + nums[i]); // Recurrence relation
            prev1 = prev2;
            prev2 = current;
        }

        return prev2;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 2};
        System.out.println("Maximum amount robbed: " + rob(nums));
    }
}
