//package main.practice.recursion_and_backtracking;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * [BWBW]
// * [BBB]
// * [WW]
// * [BWBW]
// * [BWBW]
// *
// * black = 5, white = 4
// *
// * o/p: 2
// */
//public class BlackAndWhiteBall {
//
//    public static void main(String[] args) {
//        List<List<Character>> res = new ArrayList<>();
//
//        List<Character> ch = List.of('B','W','B','W');
//        res.add(ch);
//        ch =  List.of('B', 'B','B');
//        res.add(ch);
//        ch =  List.of('B', 'W','B','W');
//        res.add(ch);
//
//        maxPossiblePermutation(res, 4, 4);
//    }
//
//    public static void maxPossiblePermutation (List<List<Character>> a, int black, int white) {
//        int res = 0;
//        int b = 0;
//        int w = 0;
//        int prevBlack = black;
//        int prevWhite = white;
//        for(List<Character> curr : a) {
//
//
//        }
//        System.out.println(res);
//    }
//
//    public boolean isSafe(List<Character> curr, int black, int white){
//        int b = 0, w = 0;
//        for(Character c: curr) {
//            if(c == 'B') b++;
//            else w++;
//        }
//
//        if((b == black && w == white) || (b <black && w == white) || (b == black && w < white) || (b < black && w < white)) {
//            res = Math.max(res+1, res);
//            b = black - b;
//            w = white - w;
//            prevBlack = b;
//            prevWhite = w;
//        } else{
//            b = prevBlack;
//            w = prevWhite;
//        }
//    }
//
//}
