package main.t2025.slidingWindow.misc;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 *  Maximum of All Subarrays of Size K
 * o Problem: Given an array of integers, find the maximum of all subarrays of
 * window size k.
 * o Example:
 * ▪ Input: [1, 3, -1, -3, 5, 3, 6, 7], k = 3
 * ▪ Output: [3, 3, 5, 5, 6, 7]
 */
public class A_MaximumOfAllSubarraysOfSizeK {
    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] result = maximumOfAllSubarraysOfSizeK(nums, k);
        for (int num : result) {
            System.out.print(num + " "); // Output: 3 3 5 5 6 7
        }
    }

    public static int[] maximumOfAllSubarraysOfSizeK(int[] arr, int k) {
        if(arr == null || arr.length == 0 || k<=0) return new int[0];
        int[] ans = new int[arr.length - k +1];
        Deque<Integer> deque = new ArrayDeque<>();
        int currIndex = 0;
        for(int i = 0; i<arr.length ; i++) {
            // remove indices of elements not in the current window
            while(!deque.isEmpty() && deque.peekFirst() < i - k+1) {
                deque.pollFirst();
            }
            // remove indices of elements smaller than current element
            while (!deque.isEmpty() && arr[deque.peekLast()] < arr[i]) {
                deque.pollLast();
            }

            //add element to deque
            deque.offerLast(i);

            // if the window has reached the size k then add the max to the result
            if( i >= k-1) {
                ans[currIndex++] = arr[deque.peekFirst()];
            }
        }
        return ans;
    }
}
