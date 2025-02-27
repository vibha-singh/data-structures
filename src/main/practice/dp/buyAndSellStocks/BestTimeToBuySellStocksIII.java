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
        int[] prevDiff = new int[k+1];
        int[] profit = new int[k+1];

        for ( int i = 0; i < n; i++) {
            for ( int j = 1; j <= k ; j++) {
                prevDiff[j] = Math.max(prevDiff[j], profit[j-1] - prices[i]);
                profit[j] = Math.max(profit[j], (prices[i] + prevDiff[j]));
            }
        }
        System.out.println(profit[k]);
    }
}
