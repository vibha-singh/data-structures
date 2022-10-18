package geeksForGeeks.dataStructure.backtracking;

import java.util.ArrayList;

/**
 * N-Queen Problem
 * HardAccuracy: 56.62%Submissions: 19047Points: 8
 * Lamp
 * This problem is part of GFG SDE Sheet. Click here to view more.
 *
 * The n-queens puzzle is the problem of placing n queens on a (n×n) chessboard such that no two queens can attack each other.
 * Given an integer n, find all distinct solutions to the n-queens puzzle. Each solution contains distinct board configurations of the n-queens’ placement, where the solutions are a permutation of [1,2,3..n] in increasing order, here the number in the ith place denotes that the ith-column queen is placed in the row with that number. For eg below figure represents a chessboard [3 1 4 2].

 *
 * Example 1:
 *
 * Input:
 * 1
 * Output:
 * [1]
 * Explaination:
 * Only one queen can be placed
 * in the single cell available.
 * Example 2:
 *
 * Input:
 * 4
 * Output:
 * [2 4 1 3 ] [3 1 4 2 ]
 * Explaination:
 * These are the 2 possible solutions.
 *
 *
 * Your Task:
 * You do not need to read input or print anything. Your task is to complete the function nQueen() which takes n as input parameter and returns a list containing all the possible chessboard configurations in sorted order. Return an empty list if no solution exists.
 *
 *
 *
 * Expected Time Complexity: O(n!)
 * Expected Auxiliary Space: O(n2)
 */
public class NQueensProblemWithNoOfPossibleSol {

    ArrayList<ArrayList<Integer>> li=new ArrayList<>();
    int ind=0;

    ArrayList<ArrayList<Integer>> nQueen(int n) {
        int arr[][]=new int[n][n];
        solveRec(arr,"",0);
        return li;

    }
    private void solveRec(int[][] arr, String qsf, int c) {
        if(c==arr[0].length) {
// 			System.out.println(qsf);
            li.add(new ArrayList<>());
            String ans[]=qsf.split(" ");
            for(int k=0;k<ans.length;k++) {
                li.get(ind).add(Integer.valueOf(ans[k]));
            }

            ind++;
            return;
        }

        for(int r=0;r<arr.length;r++) {
            if(queenSafe(arr,r,c)==true) {
                arr[r][c]=1;
                solveRec(arr,qsf+(r+1)+" ",c+1);
                arr[r][c]=0;
            }
        }

    }

    private  boolean queenSafe(int[][] arr, int r, int c) {
        //up to down side
        for(int i=0;i<c;i++) {
            if(arr[r][i]==1) {
                return false;
            }
        }

        for(int i=r,j=c;i>=0 && j>=0;j--,i--) {
            if(arr[i][j]==1) {
                return false;
            }
        }


        for(int i=r+1,j=c-1;i<arr.length && j>=0;j--,i++) {
            if(arr[i][j]==1) {
                return false;
            }
        }
        return true;

    }
}
