package main.practice.recursion_and_backtracking;

public class FloodFill {
    public static void main(String[] args) {
        int[][] floodFill = {{1,1,1},{1,1,0},{1,0,1}};
        int m = floodFill.length;
        int n = floodFill[0].length;
        int sr = 1, sc = 1, currColor = 1, newColor = 2;
        floodFill(floodFill, sr, sc, m, n, currColor, newColor);

        for (int i = 0; i<m; i++) {
            for (int j = 0; j<n; j++) {
                System.out.print(floodFill[i][j] +" ");
            }
            System.out.println();
        }
    }

    private static void floodFill(int[][] floodFill, int i, int j, int m, int n, int currColor, int newColor) {

        if(i <0 || j<0 || i>=m|| j>=n || floodFill[i][j] != currColor) return;

        floodFill[i][j] = newColor;
        floodFill(floodFill,i+1, j, m, n, currColor, newColor);
        floodFill(floodFill,i, j+1, m, n, currColor, newColor);
        floodFill(floodFill,i-1, j, m, n, currColor, newColor);
        floodFill(floodFill,i, j-1, m, n, currColor, newColor);
    }
}
