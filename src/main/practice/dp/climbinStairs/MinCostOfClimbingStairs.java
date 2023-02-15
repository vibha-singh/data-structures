package main.practice.dp.climbinStairs;

/**
 * Given costs array, find minimum cost to reach the end, starting from 0 or 1, making 1 or 2 jumps
 */
public class MinCostOfClimbingStairs {
    public static void main(String[] args) {
        int cost[] = {10,15,20};
        int firstVal = 0, secondVal = 0;
        for(int i = 0; i< cost.length; i++) {
            int curr = cost[i] + Math.min(firstVal, secondVal);
            secondVal = firstVal;
            firstVal = curr;
        }
        int ans = Math.min(firstVal, secondVal);
        System.out.println(ans);
    }
}
