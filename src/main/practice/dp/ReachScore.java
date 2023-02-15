package main.practice.dp;

/**
 * "Reach a given score" problems can often be solved using Dynamic Programming (DP). In DP, the problem is divided into smaller sub-problems, and the solutions to these sub-problems are stored in an array, so that they can be reused later.
 * Here's a simple example of a DP problem in this category:
 * Given a game where you can score 3 or 5 or 10 points in each turn, find the total number of ways to reach a given score 'n'.
 * To solve this problem, you can use an array dp[] where dp[i] stores the number of ways to reach the score i. The base cases are:
 */
public class ReachScore {

    public static void main(String[] args) {
        int targetScore = 8;
        int[] scoreWays = {3, 5, 10};
        System.out.println("Number of ways to reach " + targetScore + " is: " +
                countWaysToReachScore(targetScore, scoreWays));
    }
    public static int countWaysToReachScore(int targetScore, int[] scoreWays) {
        int[] dp = new int[targetScore + 1];
        dp[0] = 1;

        for (int i = 0; i < scoreWays.length; i++) {
            for (int j = scoreWays[i]; j <= targetScore; j++) {
                dp[j] += dp[j - scoreWays[i]];
            }
        }

        return dp[targetScore];
    }

}
