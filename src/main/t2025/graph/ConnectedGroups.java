package main.t2025.graph;


public class ConnectedGroups {
    public static void main(String[] args) {
//        int[][] matrix ={{1, 1, 0, 0},
//                {0,0,0,1},
//                {1,1,1,0},
//                {0,1,1,0},
//                {0,0,0,1}};

        int[][] matrix = {{1,1,1,1},{1,1,1,1},{1,1,1,1},{1,1,1,1}};

        int n = matrix.length;
        boolean[] visited = new boolean[n];
        int groupCount = 0;
        for(int i = 0; i< n; i++) {
            if(!visited[i]) {
                groupCount++;
                dfs(matrix, i, visited);
            }
        }
        System.out.println(groupCount);
    }

    private static void dfs(int[][] matrix, int person, boolean[] visited) {
        visited[person] = true;
        for(int i = 0; i<matrix[0].length; i++) {
            if(matrix[person][i] == 1 && !visited[i])
                dfs(matrix, i, visited);
        }
    }
}
