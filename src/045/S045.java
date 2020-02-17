/**
 * State define:dp[n]表示从当前位置到数组最后一个位置需要的最小跳跃数
 * State transfer equation:dp[i] = min(dp[i+1],dp[i+2]......,dp[i+numsp[i]]) + 1
 * Base condition:dp[nums.length - 1] = 0
 */
public class S045 {

    int dpMinJumps[];
    public int jump(int[] nums) {
        int n = nums.length;
        if (n < 2)return 0;
        dpMinJumps = new int[n];
        int step;
        int res;
        for (int i = n - 2; i >= 0; i --) {
            step = nums[i];
            res = dpMinJumps[i + 1];
            for (int j = 1; j <= step && i + j < n; j ++) {
                res = Math.min(res, dpMinJumps[i+j]);
            }
            dpMinJumps[i] = res + 1;
        }
        return dpMinJumps[0];
    }

    public static void main(String[] str) {
        S045 solution = new S045();
        int[] nums = new int[] {2,3,1,1,4};
        boolean debug = true;
        System.out.println(solution.jump(nums));
        if (debug) {
            for(int i = 0; i < nums.length; i ++) {
                System.out.println(solution.dpMinJumps[i]);
            }
        }
    }
}
