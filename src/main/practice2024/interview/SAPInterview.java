package main.practice2024.interview;

import java.util.Stack;

/**
 * Share price on different days
 *
 * price = [6,5,7,2,10] Ans 8 , buy_index, sell_index
 * price = [10,9,8,7,6,2,8], 6
 *
 * Find two days one to buy and one to sell to get highest possible profit
 */
public class SAPInterview {

    public static void main(String[] args) {
        //int[] price1 = {6,5,7,2,10};
        //right max: [4,4,4,4,4]
        //[0,1,1,3,3]

        // left, right, int sell_index, int profit, buy_index
        int[] price1 = {10,9,8,7,6,2,8};

        int buy_index = 0;
        int sell_index = 0;
        int profit = Integer.MIN_VALUE;
        for(int i = 1 ; i < price1.length; i++) {
            if (price1[i] < price1[buy_index]) {
                buy_index = i;
            } else {
                sell_index = i;
                profit = price1[i] - price1[buy_index];
            }
        }

        System.out.println("buy_index: "+buy_index+ " sell_index :"+sell_index + " profit: "+profit );

    }
}
