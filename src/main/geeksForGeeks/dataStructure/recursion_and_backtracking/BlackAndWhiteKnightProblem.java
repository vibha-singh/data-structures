package main.geeksForGeeks.dataStructure.recursion_and_backtracking;

/**
 * Black and White
 * MediumAccuracy: 50.28%Submissions: 5733Points: 4
 * Given the chessboard dimensions. Find out the number of ways we can place a black and a white Knight on this chessboard such that they cannot attack each other.
 *
 * Note:
 * The knights have to be placed on different squares. A knight can move two squares horizontally and one square vertically (L shaped), or two squares vertically and one square horizontally (L shaped). The knights attack each other if one can reach the other in one move.
 *
 * Example 1:
 *
 * Input:
 * N = 2, M = 2
 * Output: 12
 * Example 2:
 *
 * Input:
 * N = 2, M = 3
 * Output: 26
 * Your Task:
 * Your task is to complete the function numOfWays() which takes the chessboard dimensions N and M as inputs and returns the number of ways we can place 2 Knights on this chessboard such that they cannot attack each other. Since this number can be very large, return it modulo 109+7.
 *
 * Expected Time Complexity: O(N*M).
 * Expected Auxiliary Space: O(1).
 *
 * Constraints:
 * 1 <= N * M <= 105
 */
public class BlackAndWhiteKnightProblem {
    static long numOfWays(int N, int M)
    {
        long d  = 1000000007;
        long count =0;
        int dx[] = new int[]{1,-1,1,-1,2,2,-2,-2}; // all moves of knight
        int dy[] = new int[]{2,2,-2,-2,1,-1,1,-1};
        for(int i =0; i<N; ++i){
            for(int j =0; j<M; ++j){
                for(int k =0; k<8; k++){
                    int xdx = i + dx[k];
                    int ydy = j + dy[k];
                    if(issafe(xdx, ydy, N, M)) count--;
                }
                count +=(N*M - 1); // remaining pos where we can put                                                other knight.
                count %= d;           // prompt by the Q.
            }
        }
        return count;
    }

    static boolean issafe(int i, int j, int N, int M){
        return(i>=0 && i<N && j>=0 && j<M);
    }
}
