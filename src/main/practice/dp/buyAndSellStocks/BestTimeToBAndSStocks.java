package main.practice.dp.buyAndSellStocks;

/**
 * Given an array of prices, find the maximum profit if we are allowed to do one transaction.
 */
public class BestTimeToBAndSStocks {

    public static void main(String[] args) {
        int [] prices = {7,1,5,3,6,4};
        int buy = prices[0];
        int maxProfit = 0;
        for(int i = 1; i<prices.length; i++) {
            if(buy > prices[i]) {
                buy = prices[i];
            } else {
                maxProfit = Math.max(maxProfit, prices[i] - buy);
            }
        }

        System.out.println(maxProfit);

    }
}
