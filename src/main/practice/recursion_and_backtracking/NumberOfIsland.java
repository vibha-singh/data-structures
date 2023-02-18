package main.practice.recursion_and_backtracking;

public class NumberOfIsland {
    public static void main(String[] args) {
        int[][] island = {{1,1,0,0,0}, {1,1,0,0,0}, {0,0,1,0,0},{0,0,0,1,1}};
        int ans = 0;
        int m = island.length, n= island[0].length;
        for(int i = 0; i< m; i++) {
            for (int j = 0; j< n; j++) {
                if(island[i][j] == 1){
                    ans++;
                    noOfIsland(island, i,j,m, n) ;
                }
            }
        }

        System.out.println(ans);
    }

    private static void noOfIsland(int[][] island, int i, int j, int m, int n) {
        if(i<0 || j<0 || i>=m || j>= n || island[i][j] != 1) return;

        island[i][j] = 0;
        noOfIsland(island, i+1,j,m,n);
        noOfIsland(island, i-1,j,m,n);
        noOfIsland(island, i,j+1,m,n);
        noOfIsland(island, i,j,m+1,n);
    }

}
