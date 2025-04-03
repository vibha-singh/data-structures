package main.t2025.graph;

public class TownJudge {
    public static void main(String[] args) {
        int n = 3;
        int[][] trust = {{1, 3}, {2, 3}}; // Example input
        int judge = findJudge(n, trust);
        System.out.println("The town judge is: " + judge); // Output: -1 (no judge)
    }

    private static int findJudge(int n, int[][] trusts) {
        int[] trustCount = new int[n+1];
        boolean[] trustOthers = new boolean[n+1];

        for(int[] trust: trusts){
            int a = trust[0];
            int b = trust[1];
            trustCount[b]++;
            trustOthers[a] = true;
        }

        for(int i = 1; i<=n; i++) {
            if(trustCount[i] == n-1 && !trustOthers[i] ) return i;
        }
        return -1;
    }
}
