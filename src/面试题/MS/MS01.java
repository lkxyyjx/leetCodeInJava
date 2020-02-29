public class MS01 {
    public int solution(int[] A) {
        // write your code in Java SE 8
        int res1 = 0;
        int res2 = 0;
        int n = A.length;
        for (int i = 0; i < n; i ++) {
            if (A[i] != (i + 1) % 2 ) res1 ++;
        }
        for (int i = 0; i < n; i ++) {
            if (A[i] != i % 2) res2 ++;
        }
        return Math.min(res1, res2);
    }

    public static void main (String[] str) {
        MS01 solution = new MS01();
        System.out.println(solution.solution(new int[] {1, 0, 1, 0, 1, 1}));
    }
}
