package main.practice.trie;

import java.util.HashSet;
import java.util.Set;

/**
 * Time Complexity: O(N*W + R*C^2)
 *
 * Auxiliary Space: O(N*W + R*C)
 */
public class WordBoggleI {
    static String [] dictionary = { "GEEKS", "FOR", "QUIZ", "GUQ", "EE" };
    public static void main(String[] args) {

        char[][] boggle = {{'G','I','Z'},{'U','E','K'},{'Q','S','E'}};
        wordBoggle(boggle);
    }

    private static void wordBoggle(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        Set<String> ans = new HashSet<>();
        for (String s : dictionary) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (dfs(board, s, i, j, n, m, 0)) {
                        ans.add(s);
                    }
                }
            }
        }
        for (String i : ans) {
            System.out.println(i);
        }
    }

    private static boolean dfs(char[][] board, String s, int i, int j, int n, int m, int idx) {
        if (i < 0 || i >= n || j < 0 || j >= m)
            return false;
        if (s.charAt(idx) != board[i][j])
            return false;
        if (idx == s.length() - 1)
            return true;

        char temp = board[i][j];
        board[i][j] = '*';
        boolean a = dfs(board, s, i, j + 1, n, m, idx + 1); // right side
        boolean b = dfs(board, s, i, j - 1, n, m, idx + 1); // left side
        boolean c = dfs(board, s, i + 1, j, n, m, idx + 1); // below
        boolean d = dfs(board, s, i - 1, j, n, m, idx + 1); // above
        boolean e = dfs(board, s, i + 1, j + 1, n, m, idx + 1); // below right diagonal
        boolean f = dfs(board, s, i - 1, j + 1, n, m, idx + 1); //
        boolean g = dfs(board, s, i + 1, j - 1, n, m, idx + 1);
        boolean h = dfs(board, s, i - 1, j - 1, n, m, idx + 1);

        board[i][j] = temp;
        return a || b || c || e || f || g || h || d;
    }
}
