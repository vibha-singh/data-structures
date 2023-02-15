package main.practice.graph;

public class MaxAreaOfIsland {
    public static void main(String[] args) {
        int[][] island = {{1,1,0,0,0}, {1,1,0,0,0}, {0,0,1,0,0},{0,0,0,1,1}};
        int ans = 0;
        int m = island.length, n= island[0].length;
        for(int i = 0; i< m; i++) {
            for (int j = 0; j< n; j++) {
                if(island[i][j] == 1){
                    ans = Math.max(ans, maxSizeOfIsland(island, i,j,m, n)) ;
                }
            }
        }

        System.out.println(ans);
    }


    private static int maxSizeOfIsland(int[][] island, int i, int j, int m, int n) {
        if(i<0 || j<0 || i>=m || j>= n || island[i][j] != 1) return 0;

        island[i][j] = 0;
        int count = 1;
        count += maxSizeOfIsland(island, i+1,j,m,n);
        count += maxSizeOfIsland(island, i-1,j,m,n);
        count += maxSizeOfIsland(island, i,j+1,m,n);
        count += maxSizeOfIsland(island, i,j,m+1,n);
        return count;
    }

}
