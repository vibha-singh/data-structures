package main.t2025.DP;

/**
 * The Climbing Stairs problem is a classic dynamic programming problem. The problem is defined as follows:
 * You are climbing a staircase. It takes n steps to reach the top.
 * Each time you can either climb 1 or 2 steps.
 */
public class A_ClimbingStairs {
    public static void main(String[] args) {
        int n = 5;
        System.out.println("Number of ways to climb " + n + " stairs: " + climbStairs(n));
    }

    private static int climbStairs(int n) {
        int prev1 = 1; // ways to climb 1st step
        int prev2 = 1; // ways to climb 0th step;
        for(int i = 2; i<=n; i++) {
            int curr = prev1 + prev2;
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }
}
