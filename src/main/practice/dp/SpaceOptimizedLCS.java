package main.practice.dp;

public class SpaceOptimizedLCS {
    public static int lcs(String text1, String text2) {
        int[] dp = new int[text2.length()+1];
        for(int i = 0; i< text1.length(); i++){
            int prev = dp[0];
            for(int j = 1; j < dp.length; j++){
                int temp = dp[j];
                if(text1.charAt(i) != text2.charAt(j-1)){
                    dp[j] = Math.max(dp[j-1], dp[j]);
                }else{
                    dp[j] = prev +1;
                }
                //important line
                prev = temp;
            }
        }
        return dp[dp.length-1];
    }

    public static void main(String[] args)
    {
        String X = "AGGTAB";
        String Y = "GXTXAYB";

        System.out.println("Length of LCS is " + lcs(X, Y));
    }
}
