package main.practice.array;

import java.util.ArrayList;

public class SumPairClosestToX {
    public static void main(String[] args) {
        int [] arr = {10, 22, 28, 29, 30, 40};
        int N = 6;
        int X = 54;

        sumClosestToX(arr, N, X);
    }

    private static void sumClosestToX(int[] arr, int n, int sum) {
        int start = 0; int end = n-1;
        ArrayList<Integer> result  = new ArrayList<>();
        result.add(arr[start]);
        result.add(arr[end]);

        while (start < end) {
            int currSum = arr[start] + arr[end];
            if(currSum < sum) {
                if(result.get(0) + result.get(1) < sum) {
                    result.set(0, arr[start]);
                    result.set(1, arr[end]);
                }
                start++;
            } else if(currSum > sum) {
                end--;
            } else {
                break;
            }
        }

        System.out.println(result);
    }
}
