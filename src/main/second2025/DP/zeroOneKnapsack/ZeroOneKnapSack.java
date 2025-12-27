package main.second2025.DP.zeroOneKnapsack;

public class ZeroOneKnapSack {
    int[] wt,  val;
    int W;
    public static void main(String[] args) {

    }

    // Recursion
    int knapsackRecursion(int[] wt, int[] val, int W, int n) {
        // base condition
        if(n == 0 || W == 0) return 0;
        if(W >= wt[n-1]) {
            return Math.max(val[n-1] + knapsackRecursion(wt, val, W-wt[n-1], n-1) ,
                    knapsackRecursion(wt, val, W, n-1));
        } else {
            return knapsackRecursion(wt, val, W, n-1);
        }
    }

    //Memoization
    int[][] mDp = new int[val.length+1][W+1];
    int knapsackMemoize(int[] wt, int[] val,int W, int n ) {
         if(n == 0 || W == 0) return 0;
         if(mDp[n][W] != -1) return mDp[n][W];
         if(W <= wt[n-1]){
             return mDp[n][W] = Math.max(val[n-1] + knapsackMemoize(wt, val, W-wt[n-1], n-1) ,
                     knapsackMemoize(wt, val, W, n-1));
         } else{
             return mDp[n][W] = knapsackMemoize(wt, val, W, n-1);
         }
    }

    int knapsackTabulation(int[] wt, int val[], int W) {
        int n = val.length;
        int[][] dp = new int[n+1][W+1];
        for(int i = 0; i<n+1; i++){
            for(int j = 0; j<W+1; j++){
                dp[i][j] = 0;
            }
        }

        for(int i = 0; i<n+1; i++){
            for(int j = 0; j<W+1; j++){
                if (j >= wt[i-1]) {
                  dp[i][j] = Math.max( val[i-1] + dp[i-1][j-wt[i-1]] , dp[i-1][j]);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][W];
    }
}
