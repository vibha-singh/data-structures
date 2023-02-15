package main.practice.array;

public class MaximumIndex {
    public static void main(String[] args) {
        int [] arr = {34, 8, 10, 3, 2, 80, 30, 33, 1};
        System.out.println(maximumIndex(arr));
    }

    private static int maximumIndex(int[] arr) {
        int start = 0;
        int end = arr.length-1;
        while(start <  end) {
            if(arr[start] < arr[end])
                return end-start;
            start++;
            end--;
        }

        return -1;
    }
}
