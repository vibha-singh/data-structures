package leetcode.java;

/**
 * 10. Regular Expression Matching
 * Hard
 *
 * 8175
 *
 * 1244
 *
 * Add to List
 *
 * Share
 * Given an input string s and a pattern p, implement regular expression matching with support for '.' and '*' where:
 *
 * '.' Matches any single character.​​​​
 * '*' Matches zero or more of the preceding element.
 * The matching should cover the entire input string (not partial).
 *
 *
 *
 * Example 1:
 *
 * Input: s = "aa", p = "a"
 * Output: false
 * Explanation: "a" does not match the entire string "aa".
 * Example 2:
 *
 * Input: s = "aa", p = "a*"
 * Output: true
 * Explanation: '*' means zero or more of the preceding element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
 * Example 3:
 *
 * Input: s = "ab", p = ".*"
 * Output: true
 * Explanation: ".*" means "zero or more (*) of any character (.)".
 * **/
class Regular_expression_matching {
    public boolean isMatch(String s, String p) {

        boolean[][] dp = new boolean [p.length() +1][s.length()+1];

        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j < dp[0].length; j++){
                if(i == 0 && j == 0){
                    dp[i][j] = true;
                } else if(i == 0) {
                    dp[i][j] = false;
                } else if(j == 0) {
                    char pc = p.charAt(i-1);
                    if(pc == '*'){
                        dp[i][j] = dp[i-2][j];
                    }else{
                        dp[i][j] = false;
                    }

                } else {
                    char pc = p.charAt(i-1);
                    char sc = s.charAt(j-1);

                    if(pc == '*'){
                        dp[i][j] = dp[i-2][j];
                        char pslc = p.charAt(i-2);
                        if(pslc == '.' || pslc == sc){
                            dp[i][j] = dp[i][j] || dp[i][j-1];
                        }

                    } else if(pc == '.'){
                        dp[i][j] = dp[i-1][j-1];
                    } else if(pc == sc){
                        dp[i][j] = dp[i-1][j-1];
                    } else{
                        dp[i][j] = false;
                    }


                }
            }
        }

        return dp[p.length()][s.length()];

    }
}