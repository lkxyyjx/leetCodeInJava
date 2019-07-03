public class S877 {
    public static void main(String[] args) {
        S877 solution = new S877();
        System.out.println(solution.stoneGame(new int[] {3,4,7,4}));
    }

    public boolean stoneGame(int[] piles) {
        /*maxScore[i][j] = (j - i) % 2 == 0 ? max((maxScore[i][j - 1] - piles[j]), (maxScore[i + 1][j] - piles[i])) :
         max((maxScore[i][j - 1] + piles[j]), (maxScore[i + 1][j] + piles[i])) */
        int len = piles.length;
        if (len < 1) {
            return true;
        }
        int maxScore[][] = new int[len + 2][len + 2];
        int j;
        for (int size = 1; size < len + 1; size++) {
            for (int i = 1; i < len - size + 2; i++) {
                j = i + size - 1;
                if ((j - i) % 2 == 0) {
                    maxScore[i][j] = Integer.max((maxScore[i][j - 1] - piles[j - 1]), (maxScore[i + 1][j] - piles[i -1]));
                } else {
                    maxScore[i][j] = Integer.max((maxScore[i][j - 1] + piles[j - 1]), (maxScore[i + 1][j] + piles[i -1]));
                }
                System.out.println("maxScore[" + i + "]" + "[" + j + "]:" + maxScore[i][j]);
            }
        }
        System.out.println(maxScore[1][len]);
        return maxScore[1][len] > 0;
    }
}
