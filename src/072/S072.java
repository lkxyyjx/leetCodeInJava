/**
 *
 */
public class S072 {

    int[][] dpMinEditDistance;

    public int minDistance(String word1, String word2) {
        int m,n;
        m = word1.length();
        n = word2.length();
        dpMinEditDistance = new int[m+1][n+1];
        for (int i=0; i<m+1; i++) {
            for (int j=0; j<n+1; j++) {
                if (i == 0 && j == 0) {
                    dpMinEditDistance[i][j] = 0;
                } else if (i == 0 || j == 0) {
                    dpMinEditDistance[i][j] = i == 0? j : i;
                } else {
                    if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                        dpMinEditDistance[i][j] = dpMinEditDistance[i - 1][j - 1];
                    } else {
                        dpMinEditDistance[i][j] = Math.min(Math.min(dpMinEditDistance[i-1][j], dpMinEditDistance[i][j-1]), dpMinEditDistance[i-1][j-1]) + 1;
                    }
                }
            }
        }
        return dpMinEditDistance[m][n];
    }

    public static void main(String[] str) {
        S072 solution = new S072();
        boolean debug = true;
        String word1 = "horse";
        String word2 = "ros";
        System.out.println(solution.minDistance(word1, word2));
        if (debug) {
            int m = word1.length();
            int n = word2.length();
            for (int i = 0;i < m;i++) {
                for (int j = 0; j < n; j++) {
                    System.out.println("dpMinHP[" + i + "][" + j + "] = " + solution.dpMinEditDistance[i][j]);
                }
            }
        }
    }
}
