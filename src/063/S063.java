/**
 * dp问题
 * 状态转移类似62题，只不过状态转移方程需要随条件变化
 * Base condition变化为dp[0][0] = 1
 */
public class S063 {
    int[][] dpUniqPaths;
    int[][] obstacleGrid;

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m,n;
        m = obstacleGrid.length;
        n = m > 0 ? obstacleGrid[0].length : 0;
        this.obstacleGrid = obstacleGrid;
        dpUniqPaths = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j  = 0; j < n; j ++) {
                dpUniqPaths[i][j] = -1;
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j  = 0; j < n; j ++) {
                dpUniqPaths[i][j] = countDpUniqPaths(i, j);
            }
        }

        return dpUniqPaths[m - 1][n - 1];
    }

    private int countDpUniqPaths (int m, int n) {
        if (dpUniqPaths[m][n] != -1) return dpUniqPaths[m][n];
        if (obstacleGrid[m][n] == 1) return 0;
        int res;
        if (m == 0 && n == 0) {
            res = 1;
        } else if (m == 0) {
            res = countDpUniqPaths(0, n - 1);
        } else if (n == 0) {
            res = countDpUniqPaths(m - 1, 0);
        } else {
            if (obstacleGrid[m - 1][n] == 1) {
                if (obstacleGrid[m][n - 1] == 1) {
                    res = 0;
                } else {
                    res = countDpUniqPaths(m, n - 1);
                }
            } else {
                if (obstacleGrid[m][n - 1] == 1) {
                    res = countDpUniqPaths(m - 1, n);
                } else {
                    res = countDpUniqPaths(m - 1, n) + countDpUniqPaths(m, n - 1);
                }
            }
        }
        return res;
    }

    public static void main(String[] str) {
        S063 solution = new S063();

        System.out.println(solution.uniquePathsWithObstacles(new int[][]{{0,0,0},{0,1,0},{0,0,0}}));
    }
}
