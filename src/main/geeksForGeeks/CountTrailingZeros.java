package main.geeksForGeeks;

/** Count number of zeros in a factorial**/
public class CountTrailingZeros {
    public static void main(String[] args) {
        System.out.println(countTrailingZeros(300));
        System.out.println(countTrailingZeros(200));
    }

    static int countTrailingZeros(int n){
        int res = 0;
        for(int i = 5; i<= n; i = i*5){
            res += n/i;
        }
        return res;
    }
}
