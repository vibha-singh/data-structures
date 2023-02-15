package main.practice.array;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/**
 * Given an array arr[] of size n, find the first repeating element. The element should occur more than once and the index of its first occurrence should be the smallest.
 *
 * Note:- The position you return should be according to 1-based indexing.
 *
 * Input:
 * n = 7
 * arr[] = {1, 5, 3, 4, 3, 5, 6}
 * Output: 2
 * Explanation:
 * 5 is appearing twice and
 * its first appearence is at index 2
 * which is less than 3 whose first
 * occuring index is 3.
 */
public class FirstRepeatingElement {
    public static void main(String[] args) {
        int[] arr = {1, 5, 3, 4, 3, 5, 6};
        System.out.println(firstRepeatingElement(arr));
    }

    private static int firstRepeatingElement(int[] arr) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i<arr.length; i++) {
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }

        for(int i = 0; i<arr.length; i++){
            if(map.get(arr[i]) >1) return i+1;
        }

        return -1;
    }
}
