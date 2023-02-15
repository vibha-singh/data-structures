package main.practice.array;

public class CoinChangeProblem {
    public static void main(String[] args) {
        int[] arr = {2,5,3,6};
        int sum = 10;
        System.out.println(count(arr, arr.length, sum));
    }
    public static long count(int coins[], int m, int n) {
        long dp[][] = new long[n+1][m+1];
        //lemgth of aray
        for(int i = 0; i <= m; i++) dp[0][i] = 1;
        //Sum
        for(int i = 0 ; i <= n ; i++) dp[i][0] = 0;

        for(int i = 1; i<= n; i++){
            for(int j = 1; j<= m ; j++){
                dp[i][j] = dp[i][j-1];
                if(coins[j-1] <= i){
                    dp[i][j] += dp[i-coins[j-1]][j];
                }
            }
        }

        return dp[n][m];
    }
}
