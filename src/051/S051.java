import java.util.ArrayList;
import java.util.List;

/**
 * 回溯算法的教科书经典例题，实现一下
 */
public class S051 {
    List<List<String>> res;
    StringBuilder sb = new StringBuilder();
    int n;
    public List<List<String>> solveNQueens(int n) {
        if (n == 0) return new ArrayList<>();
        /** queenPos意义为第i行皇后的放在在queenPos[i]列 */
        int[] queenPos = new int[n];
        this.n = n;
        res = new ArrayList<>();
        dfs(queenPos, 0);
        return res;
    }

    private void dfs(int[] queenPos, int row) {
        /** 由于在递归之前已经判断过可行性，所以当前行数超过数组范围时，当前queenPos记录了一个解，记录到res中 */
        if (row == n) {
            List<String> singleRes =  new ArrayList<>();
            for (int i = 0; i < n; i ++) {
                sb.delete(0, sb.length());
                for (int j = 0; j < queenPos[i]; j ++) {
                    sb.append('.');
                }
                sb.append('Q');
                while (sb.length() < n) {
                    sb.append('.');
                }
                singleRes.add(sb.toString());
            }
            res.add(singleRes);
            return;
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
        S051 solution = new S051();
        List<List<String>> res = solution.solveNQueens(4);
        for (int i = 0; i < res.size(); i ++) {
            System.out.println("One of solves:");
            for (int j = 0; j < res.get(i).size(); j ++) {
                System.out.println(res.get(i).get(j));
            }
        }
    }
}
