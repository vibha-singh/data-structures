package main.t2025.binarySearch;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

/**
 * Input: weights = [1,2,3,4,5,6,7,8,9,10], D = 5
 * Output: 15
 * Explanation:
 * A ship capacity of 15 is the minimum to ship all the packages in 5 days like this:
 * 1st day: 1, 2, 3, 4, 5
 * 2nd day: 6, 7
 * 3rd day: 8
 * 4th day: 9
 * 5th day: 10
 *
 * Note that the cargo must be shipped in the order given, so using a ship of capacity 14 and splitting the packages into parts like (2, 3, 4, 5), (1, 6, 7), (8), (9), (10) is not allowed.
 */
public class CapacityToShipPackageWithinDdays {
    public static void main(String[] args) {
        List<Integer> weights = List.of(1,2,3,4,5,6,7,8,9,10);
        int noOfDays = 5;
        int left = Collections.max(weights);
        int right = weights.stream().mapToInt(Integer::intValue).sum();
        int mid;
        while (left < right) {
             mid = left + (right - left) / 2;
            if(feasible(mid, weights, noOfDays)) {
                right = mid;
            } else {
                left = mid +1;
            }
        }
        System.out.println(left);
    }

    private static boolean feasible(int capacity, List<Integer> weights, int D) {
        int days = 1;
        int currCapacity = 0;
        for(Integer w : weights){
            currCapacity += w;
            if(currCapacity > capacity) {
                currCapacity = w;
                days += 1;
                if(days > D)
                    return false;
            }
        }
        return true;
    }
}
