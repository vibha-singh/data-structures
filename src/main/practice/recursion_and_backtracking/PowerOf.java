package main.practice.recursion_and_backtracking;

public class PowerOf {
    public static void main(String[] args) {
        System.out.println(powerOfTwo(8));
        System.out.println(powerOfThree(27));
        System.out.println(powerOfFour(16));
    }

    private static boolean powerOfFour(int i) {
        if(i == 1) return true;
        if(i<=0 || i%4!= 0) return false;
        return powerOfFour(i/4);
    }

    private static boolean powerOfThree(int i) {
        if(i == 1) return true;
        if(i<=0 || i%3 != 0) return false;
        return powerOfThree(i/3);
    }

    private static boolean powerOfTwo(int i) {
        if(i == 1) return true;
        if(i<=0 || i%2!= 0) return false;
        return powerOfTwo(i/2);
    }
}
