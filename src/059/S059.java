public class S059 {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int loopTime = (n + 1)/2;
        int countNum = 0;
        for (int i = 0; i < loopTime; i ++) {
            for (int topLoop = i; topLoop < n - i; topLoop ++) {
                res[i][topLoop] = ++ countNum;
            }
            for (int rightLoop = i + 1; rightLoop < n - i; rightLoop ++) {
                res[rightLoop][n-1-i] = ++ countNum;
            }
            if (n - 1 - i != i) {
                for (int bottomLoop = n - 2 - i; bottomLoop >= i; bottomLoop--) {
                    res[n - 1 - i][bottomLoop] = ++ countNum;
                }
            }
            if (n - 1 - i != i) {
                for (int leftLoop = n - 2 - i; leftLoop > i; leftLoop--) {
                    res[leftLoop][i] = ++ countNum;
                }
            }
        }
        return res;
    }
}
