package main.t2025.slidingWindow;

public class B_MaxSum_WithMostKElements {
    public static void main(String[] args) {
        int[] positiveArr = { 1, 2, 3, 4, 5 }; // Only positive numbers
        int[] negativeArr = { -1, -2, -3, -4, -5 }; // Only negative numbers
        int[] mixedArr = { 2, -1, 5, -3, 6, -2 }; // Mixed positive and negative numbers

        int k = 3;

        System.out.println("Max sum (only positive): " + maxSumWithAtMostKElements(positiveArr, k));
        System.out.println("Max sum (only negative): " + maxSumWithAtMostKElements(negativeArr, k));
        System.out.println("Max sum (mixed): " + maxSumWithAtMostKElements(mixedArr, k));

    }

    public static int maxSumWithAtMostKElements (int[] arr, int k) {
        if(arr == null || arr.length == 0) return 0;

        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;

        for(int i = 0; i < arr.length ; i++) {
            currSum += arr[i];

            if(i >= k) {
                currSum -= arr[i-k];
            }
            if(currSum > maxSum ) maxSum = currSum;

            if(currSum < 0) currSum = 0;
        }

        return maxSum;
    }
}
