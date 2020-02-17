/**
 * State define:dp[i][j]为从当前格子走到目的所需的最少血量
 * State transfer equation:dp[i][j] = Math.max(1, Math.min(dp[i+1][j], dp[i][j+1]) - dungeon[i][j])
 * Base condition:dp[m-1][n-1]=dungeon[m-1][n-1]>0?1:1-dungeon[m-1][n-1]
 */
public class S174 {

    int[][] dpMinHP;

    public int calculateMinimumHP(int[][] dungeon) {

        int m = dungeon.length;
        int n = dungeon[0].length;

        dpMinHP = new int[m][n];
        dpMinHP[m-1][n-1] = Math.max(1, 1 - dungeon[m-1][n-1]);
        for(int i = m - 2; i >= 0; i--){
            dpMinHP[i][n-1] = Math.max(1, dpMinHP[i+1][n-1] - dungeon[i][n-1]);
        }
        for(int i = n - 2; i >= 0; i--){
            dpMinHP[m-1][i] = Math.max(1, dpMinHP[m-1][i+1] - dungeon[m-1][i]);
        }

        for(int i = m - 2; i >= 0; i--){
            for(int j = n - 2; j >= 0; j--){
                int dpmin = Math.min(dpMinHP[i+1][j], dpMinHP[i][j+1]);
                dpMinHP[i][j] = Math.max(1, dpmin - dungeon[i][j]);
            }
        }
        return dpMinHP[0][0];
    }

    public static void main(String[] str) {
        S174 solution = new S174();
        boolean debug = true;
        int[][] dungeon = new int[][] {{1,-3,3},
                {0,-2,0},
                {-3,-3,-3}};
        int res = solution.calculateMinimumHP(dungeon);
        System.out.println(res);
        if (debug) {
            int m = dungeon.length;
            int n = dungeon[0].length;
            for (int i = 0;i < m;i++) {
                for (int j = 0; j < n; j++) {
                    System.out.println("dpMinHP[" + i + "][" + j + "] = " + solution.dpMinHP[i][j]);
                }
            }
        }
    }
}
