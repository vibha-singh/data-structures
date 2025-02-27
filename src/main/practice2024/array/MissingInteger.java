package main.practice2024.array;

public class MissingInteger {
    public static void main(String[] args) {
        int[] arr = {1,2,3,6,4,7};
        int sum = 0;
        int n = arr.length+1;
        for(int i = 0; i<arr.length; i++) {
            sum += arr[i];
        }

        System.out.println(((n*(n+1))/2)-sum);
    }
}
