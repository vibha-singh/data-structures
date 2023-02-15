package main.practice.array;

import java.util.Arrays;

/**
 * Given an array of size N, find the smallest positive integer value that is either not presented in the array or cannot be represented as a sum(coz sum means you are adding two or more elements) of some elements from the array.
 */
public class SmallestPositiveIntegerThatCantBeRepresentedAsASum {

    public static void main(String[] args) {
        int[] arr = {1, 10, 3, 11, 6, 15};
        Arrays.sort(arr);
        int sum = 1;

        for(int i = 0; i<arr.length && arr[i]<=sum; i++) {
                sum = sum+arr[i];
        }

        System.out.println(sum);

    }


}
