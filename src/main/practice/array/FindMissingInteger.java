package main.practice.array;

/**
 * Given an array of size N-1 such that it only contains distinct integers in the range of 1 to N. Find the missing element.
 */
public class FindMissingInteger {
    public static void main(String[] args) {
        int [] arr = {6,1,2,8,3,4,7,10,5};
        System.out.println(findMissingInteger(arr));
    }

    private static int findMissingInteger(int[] arr) {
        int currSum = 0;
        for(int i = 0; i < arr.length; i++) {
            currSum += arr[i];
        }
        int n = arr.length+1;
        return (n*(n+1))/2 - currSum;
    }
}
