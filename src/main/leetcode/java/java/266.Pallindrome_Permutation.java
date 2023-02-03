package main.leetcode.java.java;

/**
 * 266. Pallindrome Permutation
 * Given a string, determine if a permutation of the string is a pallindrome
 *
 * Example 1
 * Input: "code"
 * Output: false
 *
 * Example 2
 * Input: "aab"
 * Output: truw
 *
 * Example 3
 * Input : "racecar"
 * Output: true
 * **/

class PallindromePermutation{
    public boolean canPermutePallindrome(String s){
        //for all ASCII values considering upper cases and lower case
        int[] charCounts = new int[128];
        for(int i =0; i< s.length(); i++){
            charCounts[s.charAt(i)]++;
        }

        int count = 0;
        for(int i =0; i<128; i++){
            count +=charCounts[i] %2;
        }

        return count <=1;
    }
}