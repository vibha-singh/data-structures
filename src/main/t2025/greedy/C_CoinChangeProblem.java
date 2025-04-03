package main.t2025.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class C_CoinChangeProblem {
    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 11;
        System.out.println("Minimum coins: " + minCoins(coins, amount));
    }

    private static int minCoins(int[] coins, int amount) {
        Arrays.sort(coins);
        List<Integer> ans = new ArrayList<>();
        int count = 0;
        for(int i = coins.length -1 ; i>=0 ; i--) {
            while (amount >= coins[i]) {
                ans.add(coins[i]);
                amount -= coins[i];
                count++;
            }
        }
        System.out.println(ans);
        return amount == 0 ? count: -1;
    }
}
