package main.practice2024.array;

import java.util.Arrays;
import java.util.List;

public class CyclicallyRotate {
    public static void main(String[] args) {
        int [] num = {1,2,3,5,7};
        int k = 3;
        reverse(num, 0, num.length-1);
        reverse(num, 0, k-1);
        for (int n: num) {
            System.out.print(n+" ");
        }
    }

    public static void reverse(int[] num, int start, int end) {
        if (num.length > 0) {
           while (start < end){
                int curr = num[start];
                num[start] = num[end];
                num[end] = curr;
                start++;
                end--;
            }
        }
    }
}
