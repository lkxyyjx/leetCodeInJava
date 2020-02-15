/**
 * dp问题
 * State transfer equation:dp[m][n] = dp[m - 1][n] + dp[m][n - 1] 数组元素保存的是走到当前位置的线路数
 * Base condition: dp[0][n] = 1, dp[m][0] = 1
*/
public class S062 {

    int[][] dpUniqPaths;

    public int uniquePaths(int m, int n) {
        dpUniqPaths = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j  = 0; j < n; j ++) {
                dpUniqPaths[i][j] = countDpUniqPaths(i, j);
            }
        }

        return dpUniqPaths[m - 1][n - 1];
    }

    private int countDpUniqPaths (int m, int n) {
        if (m == 0 || n == 0)return 1;
        if (dpUniqPaths[m][n] != 0) return dpUniqPaths[m][n];
        return countDpUniqPaths(m - 1, n) + countDpUniqPaths(m, n - 1);
    }

    public static void main(String[] str) {
        S062 solution = new S062();
        int m = 5, n =3;
        System.out.println(solution.uniquePaths(m, n));
    }
}
