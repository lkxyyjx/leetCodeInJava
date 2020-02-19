/**
 * 解法完全与51题一致
 */
public class S052 {
    int n;
    int res;
    public int totalNQueens(int n) {
        if (n == 0) return 0;
        /** queenPos意义为第i行皇后的放在在queenPos[i]列 */
        int[] queenPos = new int[n];
        this.n = n;
        res = 0;
        dfs(queenPos, 0);
        return res;
    }

    private void dfs(int[] queenPos, int row) {
        /** 由于在递归之前已经判断过可行性，所以当前行数超过数组范围时，当前queenPos记录了一个解，记录到res中 */
        if (row == n) {
            res ++;
        }
        for (int i = 0; i < n; i++) {
            if (validChoose(queenPos, row, i)) {
                queenPos[row] = i;
                dfs(queenPos, row + 1);
            }
        }
    }

    private boolean validChoose(int[] queenPos, int row, int column) {
        for (int i = 0; i < row; i++) {
            if (queenPos[i] == column || queenPos[i] == column - (row - i) || queenPos[i] == column + (row - i)) return false;
        }
        return true;
    }

    public static void main(String[] str) {
        S052 solution = new S052();
        System.out.println(solution.totalNQueens(4));
    }
}
