public class S096 {
    public int numTrees(int n) {
        if (n < 1) return 0;
        if (n == 1) return 1;
        int[] dpTreesNum = new int[n + 1];
        dpTreesNum[0] = 1;
        dpTreesNum[1] = 1;
        for (int i = 2; i <= n; i ++) {
            for (int root = 1; root <= i;  root ++) {
                dpTreesNum[i] += dpTreesNum[i - root] * dpTreesNum[root - 1];
            }
        }
        return dpTreesNum[n];
    }

    public static void main(String[] str) {
        S096 solution = new S096();
        System.out.println(solution.numTrees(3));
    }
}
