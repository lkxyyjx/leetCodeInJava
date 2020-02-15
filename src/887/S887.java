/**
 * 基本DP解法，算法会超时
 * 时间效率在O（KN^2）
 */
import java.util.ArrayList;
import java.util.List;

public class S887 {

    private List<List<Integer>> dpEggAndFloor;

    public int superEggDrop(int K, int N) {
        if (N == 0 || N == 1 || K == 1) {
            return N;
        }
        if (dpEggAndFloor == null) initArrayList(K, N);
        if (dpEggAndFloor.get(K).get(N) != 0) return dpEggAndFloor.get(K).get(N);
        int res = N;
        for (int i = 1; i <= N; i ++) {
            res = Math.min(res, Math.max(superEggDrop(K - 1, i - 1), superEggDrop(K, N - i)) + 1);
        }
        dpEggAndFloor.get(K).set(N, res);
        return res;
    }


    private void initArrayList(int k, int n) {
        dpEggAndFloor = new ArrayList<>();
        for (int i = 0; i <= k; i ++) {
            List<Integer> temp = new ArrayList<>(n + 1);
            for (int j = 0; j <= n; j ++) {
                temp.add(0);
            }
            dpEggAndFloor.add(temp);
        }
    }

    public static void main(String[] str) {
        S887 solution = new S887();
        int k = 2, n = 10;
        boolean debug = false;
        System.out.println(solution.superEggDrop(k,n));
        if (debug) {
            for (int i = 0; i < k + 1; i++) {
                for (int j = 0; j < n + 1; j++) {
                    System.out.println("dpEggAndFloor[" + i + "][" + j + "] = " + solution.dpEggAndFloor.get(i).get(j));
                }
            }
        }
    }
}
