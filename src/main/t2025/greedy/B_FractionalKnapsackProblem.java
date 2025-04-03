package main.t2025.greedy;

import java.util.Arrays;

/**
 *  Fractional Knapsack Problem
 * Problem: Given weights and values of items, fill a knapsack of capacity W to maximize the total value. You can take fractions of items.
 *
 * Greedy Choice: Always pick the item with the highest value-to-weight ratio.
 */
public class B_FractionalKnapsackProblem {
    public static void main(String[] args) {
        Item[] items = {
                new Item(60, 10),
                new Item(100, 20),
                new Item(120, 30)
        };
        int W = 50;

        System.out.println("Maximum value: " + fractionalKnapsack(items, W));

    }

    private static Double fractionalKnapsack(Item[] items, int w) {
        Arrays.sort(items, (a,b) -> Double.compare((double) b.value/b.weight, (double) a.value/a.weight));
        double totalValue = 0.0;
        for(Item item: items) {
            if(w >= item.weight ){
                totalValue += item.value;
                w -= item.weight;
            } else {
                totalValue += (double) w/(item.value*item.weight);
                break;
            }
        }
        return totalValue;
    }
}

class Item {
    int value;
    int weight;
    public Item(int value, int weight) {
        this.value = value;
        this.weight = weight;
    }
}
