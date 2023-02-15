package main.practice.array;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of N integers, and an integer K, find the number of pairs of elements in the array whose sum is equal to K.
 * Input:
 * N = 4, K = 6
 * arr[] = {1, 5, 7, 1}
 * Output: 2
 * Explanation:
 * arr[0] + arr[1] = 1 + 5 = 6
 * and arr[1] + arr[3] = 5 + 1 = 6.
 */
public class CountPairsWithGivenSum {
    public static void main(String[] args) {
        int[] arr = {1, 5, 7, 1};
        int k = 6;
        System.out.println(countPairsWithGivenSum(arr, k));
    }

    private static int countPairsWithGivenSum(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int result = 0;
        for(int i = 0; i< arr.length; i++) {
            if(map.containsKey(k-arr[i])) {
                result += map.get(k-arr[i]);
            }
            map.put(arr[i], map.getOrDefault(arr[i],0)+1);
        }
        return result;
    }
}
