package main.practice2024.array;

import java.util.HashMap;
import java.util.Map;

public class CountPairsWithGivenSum {

    public static void main(String[] args) {
        int[] arr = {1,5,7,1};
        int sum = 6;
        int result = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for ( int i = 0; i< arr.length ; i++) {
            if ( map.containsKey(sum - arr[i])) {
                result += map.get(sum - arr[i]);
            }
            map.put(arr[i], map.getOrDefault(arr[i], 0)+1 );
        }
        System.out.println(result);
    }
}
