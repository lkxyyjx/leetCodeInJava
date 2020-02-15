/**
 * dp问题
 * State transfer equation:dp[m][n] = min(dp[m - 1][n], dp[m][n - 1]) + grid[m][n]
 * Base condition:dp[0][0] = gird[0][0]
 */
public class S064 {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        if(m < 1) return 0;
        int n = grid[0].length;
        if(n < 1) return 0;
        int dpMinPathSum[][] = new int[m][n];
        for (int i = 0; i < m; i ++) {
            for (int j = 0; j < n; j ++) {
                if (i == 0 && j == 0) {
                    dpMinPathSum[i][j] = grid[0][0];
                } else if (i == 0) {
                    dpMinPathSum[i][j] = dpMinPathSum[i][j - 1] + grid[i][j];
                } else if (j == 0) {
                    dpMinPathSum[i][j] = dpMinPathSum[i - 1][j] + grid[i][j];
                } else {
                    dpMinPathSum[i][j] = Math.min(dpMinPathSum[i][j - 1], dpMinPathSum[i - 1][j]) + grid[i][j];
                }
            }
        }
        return dpMinPathSum[m - 1][n - 1];
    }

    public static void main(String[] str) {
        S064 solution = new S064();
        int res = solution.minPathSum(new int[][] {{1,3,1},
        {1,5,1},
        {4,2,1}});
        System.out.println(res);
    }
}
