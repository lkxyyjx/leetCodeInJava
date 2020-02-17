/**
 * 比较简单，就不多写了dp[n]=dp[n-1] + dp[n-2]
 */
public class S070 {

    int[] dpWays;
    public int climbStairs(int n) {
        switch (n) {
            case 0:
                return 0;
            case 1:
                return 1;
            case 2:
                return 2;
            default:
                dpWays = new int[n + 1];
                dpWays[0] = 1;
                dpWays[1] = 2;
                for (int i = 2; i < n; i++) {
                     /* 卧槽突然发现居然是就是fibo数列 QAQ其实直接用公式算就行了*/
                    dpWays[i] = dpWays[i-1] + dpWays[i-2];
                }
                return dpWays[n - 1];
        }
    }

    public static void main(String[] str) {
        S070 solution = new S070();
        int n = 10;
        boolean debug = true;
        System.out.println(solution.climbStairs(n));
        if (debug) {
            for (int i = 0; i < n; i++) {
                System.out.println(solution.dpWays[i]);
            }
        }
    }
}
