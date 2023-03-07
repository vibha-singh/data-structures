package main.practice.dp;


public class LongestPallindromicSubsequence {
    public static void main(String[] args) {
        String s1 = "GEEKSFORGEEKS";
        String s2 = reverseString(s1);
        System.out.println(LCS(s1, s2));
        CurrentValue res = new CurrentValue();
        longestPallindromicSubsequence(s1, 0, "", res);
        System.out.println(res);
    }

    static int LCS(String s1, String s2) {
        int[] dp = new int[s1.length()+1];
        for(int i = 0; i<s1.length(); i++) {
            int prev = dp[0];
            for(int  j = 1; j< dp.length; j++) {
                int temp = dp[j];
                if(s1.charAt(i) != s2.charAt(j-1)) {
                    dp[j] = Math.max(dp[j-1], dp[j]);
                } else {
                    dp[j] = prev +1;
                }
                prev = temp;
            }
        }
        return dp[dp.length -1];
    }

    static String reverseString(String s){
        int start = 0;
        int end = s.length()-1;
        char[] chars = s.toCharArray();
        while(start < end) {
            char c = s.charAt(start);
            chars[start] = chars[end];
            chars[end] = c;
            start++;
            end--;
        }
        return String.valueOf(chars);
    }

    static void longestPallindromicSubsequence(String s, int currIndex, String currString, CurrentValue res){
        if(currIndex >= s.length()) {
            String reverseString = reverseString(currString);
            if(currString.equals(reverseString) ){
                if(res.getS().length() > 0 ) {
                    if(res.getS().length() < currString.length()) res.setS(currString);
                } else {
                    res.setS(currString);
                }
            }
            return;
        }

        char currValue = s.charAt(currIndex);
        longestPallindromicSubsequence(s, currIndex+1, currString, res);
        currString += currValue;
        longestPallindromicSubsequence(s, currIndex+1, currString, res);
    }

}

class CurrentValue {
    String s ="";

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }

    @Override
    public String toString() {
        return "CurrentValue{" +
                "s='" + s + '\'' +
                '}';
    }
}
