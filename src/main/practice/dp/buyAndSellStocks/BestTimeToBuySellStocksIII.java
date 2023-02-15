package main.practice.dp.buyAndSellStocks;

import java.util.Arrays;

/**
 * Maximum profit has to achieved by at most two transactions
 */
public class BestTimeToBuySellStocksIII {
    public static void main(String[] args) {
        int[] prices = {3,2,6,5,0,3,4};
        int n = prices.length;
        int  k = 2;
        int[][] dp = new int[k+1][n];
        for (int tran = 1; tran <= k; tran++) {
            int tmpMax = Integer.MIN_VALUE;
            for (int day = 1; day < n; day++) {
                dp[tran][day] = Math.max(dp[tran][day - 1], prices[day] + tmpMax);
                tmpMax =  Math.max(tmpMax, dp[tran - 1][day] - prices[day]);
            }
        }
        System.out.println(dp[k][n - 1]);
    }
}
