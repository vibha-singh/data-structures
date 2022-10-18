package companies.atlassian;

public class StringToAtoi {

    public static void main(String[] args) {

    }

    public int myAtoi(String s) {
        int n = s.length();
        int i = 0;
        while(i<n && s.charAt(i)==' ') i++; //Removing whitespaces;
        if(i >= n) return 0;  //If only whitespace is present, return 0;

        //sign check
        int sign = 1;
        if(s.charAt(i) =='-' || s.charAt(i)=='+'){
            sign = s.charAt(i)=='+'? +1: -1;
            i++;
        }
        if(i >= n) return 0; //If only sign is present,return 0;

        long res = 0;
        while(i < n && 0 <= s.charAt(i) - '0' && s.charAt(i) - '0' <=9){
            res = res*10 + (s.charAt(i)-'0');
            if(res > Integer.MAX_VALUE ){  //Integer overflow case check
                if(sign == 1) return Integer.MAX_VALUE ;
                else return Integer.MIN_VALUE;
            }
            i++;
        }
        return (int)res*sign;
    }
}
