package main.t2025.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class A_KthLargestElementInAnArray {

    public static void main(String[] args) {
        int[] arr = {5,3,9,1,0,2};
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        for(int i = 0; i<arr.length ; i++) {
            queue.add(arr[i]);
        }

//        for(int i = 0; i<n)
        System.out.println(queue);
    }
}
