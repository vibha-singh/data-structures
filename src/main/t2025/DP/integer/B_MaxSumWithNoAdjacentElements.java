package main.t2025.DP.integer;

public class B_MaxSumWithNoAdjacentElements {
    public static void main(String[] args) {
        int[] arr1 = { 5, 5, 10, 100, 10, 5 }; // Example with positive numbers
        int[] arr2 = { -5, -1, -10, -100, -10, -5 }; // Example with negative numbers
        int[] arr3 = { 3, -2, 7, -10, 4, 2, -5 }; // Example with mixed numbers

        System.out.println("Maximum sum (positive numbers): " + maxSumWithNoAdjacentElements(arr1));
        System.out.println("Maximum sum (negative numbers): " + maxSumWithNoAdjacentElements(arr2));
        System.out.println("Maximum sum (mixed numbers): " + maxSumWithNoAdjacentElements(arr3));
    }

    public static int maxSumWithNoAdjacentElements(int[] arr) {

        if(arr == null || arr.length == 0) return 0;
        int n = arr.length;
        if(n == 1) return arr[0];
        int prev = arr[0];
        int curr = Math.max(arr[0], arr[1]);

        for(int i = 2 ; i < n ; i++) {
            int temp = Math.max(curr, prev+arr[i]);
            prev = curr;
            curr = temp;
        }
        return Math.max(prev, curr);
    }
}
