/**
 * 以下解答为错误解答，没有考虑curHP会影响后续路程中minHP的变化，留给自己作纪念，以儆效尤
 *
 * dp array define:dp[m][n] = Pair<int, int>, key:minHP, val:curHP
 * 计算当前dp时，minHP = lastDp.val + 当前位置消耗 > 0 ? lastDp.key : lastDp.key - (lastDp.val + 当前位置消耗) + 1
 * State transfer equation:dp[m][n].key = min(dp[m][n-1]计算所得结果， dp[n - 1][m]计算所得结果)
 *                         dp[m][n].val根据dp[m][n].key的计算结果得出
 * Base condition:minHP[0][0] = dungeon[0][0] > 0 ? 1 : -dungeon[0][0] + 1
 *                CurHP[0][0] = dungeon[0][0] > 0 ? 1 + dungeon[0][0] : 1;
 */
public class S174_falseAnswer {
    private int[][] dpMinHP;
    private int[][] dpCurHP;

    public int calculateMinimumHP(int[][] dungeon) {
        int m,n;
        m = dungeon.length;
        if (m < 1) return 1;
        n = dungeon[0].length;
        if (n < 1) return 1;
        dpMinHP = new int[m][n];
        dpCurHP = new int[m][n];
        int minHPFromM;
        int minHPFromN;
        for (int i = 0;i < m;i++) {
            for (int j = 0;j < n;j++) {
                if (i == 0 && j == 0) {
                    dpMinHP[0][0] = dungeon[0][0] > 0 ? 1 : -dungeon[0][0] + 1;
                    dpCurHP[0][0] = dungeon[0][0] > 0 ? 1 + dungeon[0][0] : 1;
                } else if(i == 0) {
                    minHPFromN = dpCurHP[i][j - 1] + dungeon[i][j] > 0 ? dpMinHP[i][j - 1] : dpMinHP[i][j - 1] - (dpCurHP[i][j - 1] + dungeon[i][j]) + 1;
                    dpMinHP[i][j] = minHPFromN;
                    dpCurHP[i][j] = dpCurHP[i][j - 1] + dungeon[i][j] > 0 ? dpCurHP[i][j - 1] + dungeon[i][j] : 1;
                } else if(j == 0) {
                    minHPFromM = dpCurHP[i - 1][j] + dungeon[i][j] > 0 ? dpMinHP[i - 1][j] : dpMinHP[i - 1][j] - (dpCurHP[i - 1][j] + dungeon[i][j]) + 1;
                    dpMinHP[i][j] = minHPFromM;
                    dpCurHP[i][j] = dpCurHP[i - 1][j] + dungeon[i][j] > 0 ? dpCurHP[i - 1][j] + dungeon[i][j] : 1;
                } else {
                    minHPFromN = dpCurHP[i][j - 1] + dungeon[i][j] > 0 ? dpMinHP[i][j - 1] : dpMinHP[i][j - 1] - (dpCurHP[i][j - 1] + dungeon[i][j]) + 1;
                    minHPFromM = dpCurHP[i - 1][j] + dungeon[i][j] > 0 ? dpMinHP[i - 1][j] : dpMinHP[i - 1][j] - (dpCurHP[i - 1][j] + dungeon[i][j]) + 1;
                    dpMinHP[i][j] = Math.min(minHPFromM, minHPFromN);
                    if (minHPFromM > minHPFromN) {
                        dpCurHP[i][j] = dpCurHP[i][j - 1] + dungeon[i][j] > 0 ? dpCurHP[i][j - 1] + dungeon[i][j] : 1;
                    } else {
                        dpCurHP[i][j] = dpCurHP[i - 1][j] + dungeon[i][j] > 0 ? dpCurHP[i - 1][j] + dungeon[i][j] : 1;
                    }
                }
            }
        }
        return dpMinHP[m - 1][n - 1];
    }

    public static void main(String[] str) {
        S174_falseAnswer solution = new S174_falseAnswer();
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
                    System.out.println("dpCurHP[" + i + "][" + j + "] = " + solution.dpCurHP[i][j]);
                }
            }
        }
    }
}
