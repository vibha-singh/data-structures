package main.practice2024.array;

import java.util.HashMap;
import java.util.Map;

public class FindDuplicatesInAnArray {
    public static void main(String[] args) {
        int[] arr = {1,5,2,4,5,1};
        Map<Integer,Integer> map = new HashMap<>();
        for (int  i = 0; i < arr.length; i++) {
             map.put(arr[i] , map.getOrDefault(arr[i], 0)+1);
        }

        map.entrySet().stream().filter(e -> e.getValue() > 1).forEach(System.out::println);
    }
}
