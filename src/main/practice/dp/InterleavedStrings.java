package main.practice.dp;

/**
 * Given strings A, B, and C, find whether C is formed by an interleaving of A and B.
 * An interleaving of two strings S and T is a configuration such that it creates a new string Y from the concatenation substrings of A and B and |Y| = |A + B| = |C|
 *
 * For example:
 *
 * A = "XYZ"
 * B = "ABC"
 * so we can make multiple interleaving string Y like, XYZABC, XAYBCZ, AXBYZC, XYAZBC and many more so here your task is to check whether you can create a string Y which can be equal to C.
 *Input:
 * A = YX, B = X, C = XXY
 * Output: 0
 * Explanation: XXY is not interleaving
 * of YX and X
 *
 * Input:
 * A = XY, B = X, C = XXY
 * Output: 1
 * Explanation: XXY is interleaving of
 * XY and X.
 *
 */
public class InterleavedStrings {
    public static void main(String[] args) {
        String A = "XY";
        String B = "X";
        String C = "XXY";

        int aLen = A.length(), bLen = B.length(), cLen = C.length();

        if(cLen != aLen+bLen) System.out.println(false);
        else {
            Boolean[][] dp = new Boolean[aLen+1][bLen+1];
            System.out.println(isInterLeaved(A, B, C, 0, 0, 0, dp));
        }

    }

    private static boolean isInterLeaved(String a, String b, String c, int aCurrLen, int bCurrLen, int cCurrLen, Boolean[][] dp) {
        if(cCurrLen == c.length()) return true;
        if(dp[aCurrLen][bCurrLen] != null) return dp[aCurrLen][bCurrLen];

        boolean x = false, y = false;
        if(aCurrLen < a.length() && a.charAt(aCurrLen) == c.charAt(cCurrLen))
            x = isInterLeaved(a, b, c, aCurrLen+1, bCurrLen, cCurrLen+1, dp);

        if(bCurrLen < b.length() && b.charAt(bCurrLen) == c.charAt(cCurrLen))
            x = isInterLeaved(a, b, c, aCurrLen, bCurrLen+1, cCurrLen+1, dp);

        return dp[aCurrLen][bCurrLen] = x || y;
    }

}
