package main.practice;

public class TrappingWaterProblem {


    public static void main(String[] args) {
        int[] arr = {5,0,6,2,3};
        int[] lmax = new int[arr.length];
        int[] rmax = new int[arr.length];
        lmax[0] = arr[0];
        for(int i = 1; i<arr.length; i++) {
            lmax[i] = Math.max(arr[i], lmax[i-1]);
        }
        for(int i = 0; i<arr.length; i++) {
            System.out.print(lmax[i]);
        }

        rmax[arr.length-1] = arr[arr.length-1];
        for(int i = arr.length-2; i>=0; i--) {
            rmax[i] = Math.max(arr[i], rmax[i+1]);
        }

        System.out.println();
        for(int i = 0; i<arr.length; i++) {
            System.out.print(rmax[i]);
        }

        int res = 0;
        for(int i = 1; i< arr.length;i++) {
            res += (Math.min(lmax[i],rmax[i]) - arr[i]);
        }

        System.out.println(res);
    }
}
