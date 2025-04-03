package main.t2025.DP;

public class B_ClimbingStairsWithACost {
    public static void main(String[] args) {
        int[] cost = {10, 15, 20};
        System.out.println("Minimum cost to climb stairs: " + minCostClimbingStairs(cost));
    }

    private static int minCostClimbingStairs(int[] cost) {
        int prev1 = cost[1];
        int prev2 = cost[0];
        for(int i = 2; i<cost.length; i++) {
            int curr = cost[i] + Math.min(prev1, prev2);
            prev2 = prev1;
            prev1 = curr;
        }
        return Math.min(prev2, prev1);
    }
}
