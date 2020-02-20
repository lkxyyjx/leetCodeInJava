import java.util.ArrayList;
import java.util.List;

/**
 * 按题目描述逐个读取元素就行了，注意边界条件即可
 */
public class S054 {
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix.length < 1 || matrix[0].length < 1) return new ArrayList<>();
        int m,n;
        m = matrix.length;
        n = matrix[0].length;
        int loopTime = (Math.min(m, n) + 1)/2;
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < loopTime; i ++) {
            for (int topLoop = i; topLoop < n - i; topLoop ++) {
                res.add(matrix[i][topLoop]);
            }
            for (int rightLoop = i + 1; rightLoop < m - i; rightLoop ++) {
                res.add(matrix[rightLoop][n-1-i]);
            }
            if (m - 1 - i != i) {
                for (int bottomLoop = n - 2 - i; bottomLoop >= i; bottomLoop--) {
                    res.add(matrix[m - 1 - i][bottomLoop]);
                }
            }
            if (n - 1 - i != i) {
                for (int leftLoop = m - 2 - i; leftLoop > i; leftLoop--) {
                    res.add(matrix[leftLoop][i]);
                }
            }
        }
        return res;
    }

    public static void main(String[] str) {
        S054 solution = new S054();
        int[][] matrix = new int[][] {{1,2,3,4},
                {5,6,7,8},
                {9,10,11,12}};
        System.out.println(solution.spiralOrder(matrix));
    }
}
