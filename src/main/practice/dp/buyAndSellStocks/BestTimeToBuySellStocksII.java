package main.practice.dp.buyAndSellStocks;

/**
 * Given an array of prices, find the maximum profit if we are allowed to do many transactions.
 */
public class BestTimeToBuySellStocksII {
    public static void main(String[] args) {
        int [] prices = {7,1,5,3,6,4};
        int profit = 0;

        for(int i = 1; i< prices.length; i++) {
            if(prices[i] > prices[i-1])
                profit += prices[i] - prices[i-1];
        }

        System.out.println(profit);
    }
}
