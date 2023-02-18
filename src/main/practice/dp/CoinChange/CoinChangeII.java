package main.practice.dp.CoinChange;

public class CoinChangeII {
    public static void main(String[] args) {
        int[] coins = {1,2,3};
        int n = coins.length;
        int sum = 4;
//        int[] dp = new int[sum+1];
//        dp[0] = 1;
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++){
            int cnt = 0;
            for (int j = coins[i]; j <= sum; j++){
//                dp[j] += dp[j - coins[i]];
                cnt++;
            }
            ans = Math.min(cnt, ans);
        }

        System.out.println(ans);
    }
}
