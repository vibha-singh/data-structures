package main.practice.recursion_and_backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LetterCombinationOfPhoneNumber {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1,"");
        map.put(2,"abc");
        map.put(3,"def");
        map.put(4,"ghi");
        map.put(5,"jkl");
        map.put(6,"mno");
        map.put(7,"pqrs");
        map.put(8,"tuv");
        map.put(9,"wxyz");


        ArrayList<String> ans = new ArrayList<>();
//        getLetterCombination("23",map, ans);
    }

    static ArrayList<String> getLetterCombination(String number, Map<Integer, String> map, Integer currentIndex, String currStr, ArrayList<String> ans) {

        int curr = number.charAt(currentIndex);
        if(curr >0) {
          String alpha = map.get(curr);
          for(int i = 0; i< alpha.length() ; i++) {
              ans.add( String.valueOf(alpha.charAt(i)));
//              getLetterCombination(number, map, currentIndex+1, cu)
              ans.remove( String.valueOf(alpha.charAt(i)));
          }
        }
        return new ArrayList<>();
    }
}
