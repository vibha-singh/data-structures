package main.practice.array;

import java.util.HashMap;
import java.util.Map;

/**
 * Find the first non-repeating element in a given array arr of N integers.
 * Note: Array consists of only positive and negative integers and not zero.
 *
 * Example 1:
 *
 * Input : arr[] = {-1, 2, -1, 3, 2}
 * Output : 3
 * Explanation:
 * -1 and 2 are repeating whereas 3 is
 * the only number occuring once.
 * Hence, the output is 3.
 */
public class FirstNonRepeatingElement {
    public static void main(String[] args) {
        int[] arr = {-1, 2, -1, 3, 2};
        System.out.println(firstRepeatingElement(arr));
    }

    private static int firstRepeatingElement(int[] arr) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i<arr.length; i++) {
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }

        for(int i = 0; i<arr.length; i++){
            if(map.get(arr[i]) == 1) return i;
        }

        return -1;
    }
}
