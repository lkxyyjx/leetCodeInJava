public class S877 {
    public static void main(String[] args) {
        S877 solution = new S877();
        System.out.println(solution.recoverTree(new int[] {3,4,7,4}));
    }

    public boolean recoverTree(int[] piles) {
        /*maxScore[i][j] = (j - i) % 2 == 0 ? max((maxScore[i][j - 1] - piles[j]), (maxScore[i + 1][j] - piles[i])) :
         max((maxScore[i][j - 1] + piles[j]), (maxScore[i + 1][j] + piles[i])) */
        int len = piles.length;
        if (len < 1) {
            return true;
        }
        int maxScore[][] = new int[len][len];
        int j;
        for (int size = 1; size < len; size++) {
            for (int i = 0; i < len - size + 1; i++) {
                j = i + size - 1;
                if ((j - i) % 2 == 0) {
                    maxScore[i][j] = Integer.max((maxScore[i][j - 1] - piles[j]), (maxScore[i + 1][j] - piles[i]));
                } else {
                    maxScore[i][j] = Integer.max((maxScore[i][j - 1] + piles[j]), (maxScore[i + 1][j] + piles[i]));
                }
            }
        }
        System.out.println(maxScore[0][len - 1]);
        return maxScore[0][len - 1] > 0;
    }
}
