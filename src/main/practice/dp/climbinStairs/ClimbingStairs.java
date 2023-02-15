package main.practice.dp.climbinStairs;

/**
 * Given a value 'N', find the number of ways to reach N and jumps possible are one or two.
 */
public class ClimbingStairs {

//    public static void main(String[] args) {
//        int n = 5;
//        int dp [] = new int[n+1];
//        for(int i = 0; i< n+1; i++){
//            dp[i] = -1;
//        }
//
//        System.out.println(noOfWays(n, dp));
//    }

    static int noOfWays(int n, int[] dp) {
        if(n<=1) return dp[n] = 1;
        if(dp[n] != -1) return dp[n];
        dp[n] = noOfWays(n-1, dp) + noOfWays(n-2,dp);
        return dp[n];

    }

    public static void main(String[] args) {
        int n = 5;
        int firstVal = 1, secondVal = 1;
        for(int i = 2; i<= n; i++) {
            int curr = secondVal+firstVal;
            secondVal = firstVal;
            firstVal = curr;
        }
        int ans = firstVal;
        System.out.println(ans);
    }

}
