/**
 * 遍历0到n/2行，对于第i行，对元素i到n-i进行循环，进行该元素和该元素对应的其他三个旋转位置的元素的四元交换即可
 */
public class S048 {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        if (n < 2) return;
        int loopTimes1 = n/2;
        n = n - 1;
        int loopTimes2;
        int temp;
        for (int i = 0; i < loopTimes1; i++) {
            loopTimes2 = n - i;
            for (int j = i; j < loopTimes2; j ++) {
                temp = matrix[n-j][i];
                matrix[n-j][i] = matrix[n-i][n-j];
                matrix[n-i][n-j] = matrix[j][n-i];
                matrix[j][n-i] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }
    }

    public static void main(String[] str) {
        S048 solution = new S048();
        boolean debug = true;
        int[][] matrix = new int[][] {{1,2,3},
                {4,5,6},
                {7,8,9}};
        solution.rotate(matrix);
        StringBuilder sb = new StringBuilder();
        if (debug) {
            for (int i = 0; i < matrix.length; i++) {
                sb.delete(0, sb.length());
                for (int j = 0; j < matrix.length; j++) {
                    sb.append(matrix[i][j]);
                }
                System.out.println(sb.toString());
            }
        }
    }
}
