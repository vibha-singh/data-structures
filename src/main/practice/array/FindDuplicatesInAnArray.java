package main.practice.array;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array a[] of size N which contains elements from 0 to N-1, you need to find all the elements occurring more than once in the given array.
 *
 * Input:
 * N = 4
 * a[] = {0,3,1,2}
 * Output: -1
 * Explanation: N=4 and all elements from 0
 * to (N-1 = 3) are present in the given
 * array. Therefore output is -1.
 *
 * Input:
 * N = 5
 * a[] = {2,3,1,2,3}
 * Output: 2 3
 * Explanation: 2 and 3 occur more than once
 * in the given array.
 */
public class FindDuplicatesInAnArray {
    public static void main(String[] args) {
        int [] arr = {2,3,1,2,3};
        findDuplicatesInAnArray(arr);
    }

    private static void findDuplicatesInAnArray(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i< arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i],0)+1);
        }

        map.entrySet().stream().filter(e-> e.getValue() > 1).forEach(e->System.out.println(e.getKey()));
    }
}
