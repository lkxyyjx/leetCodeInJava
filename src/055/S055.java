/**
 * 简单的贪心，每个循环计算能跳到最远的位置即可，如果计算到跳到最远位置大于数组最大index或者一次扫描后可达最远位置没有变化结束循环
 */
public class S055 {
    public boolean canJump(int[] nums) {
        int numsLen = nums.length;
        if (numsLen < 2) return true;
        int preScanedPos = 0;
        int farestPos = nums[preScanedPos];
        int tempFarestPos = farestPos;
        while (preScanedPos != farestPos && farestPos < numsLen) {
            for (int i = preScanedPos + 1; i <= farestPos; i ++) {
                tempFarestPos = Math.max(tempFarestPos, i + nums[i]);
            }
            preScanedPos = farestPos;
            farestPos = tempFarestPos;
        }
        return farestPos >= numsLen - 1;
    }

    public static void main (String[] str) {
        S055 solution = new S055();
        int[] nums = new int[] {2,0,0};
        System.out.println(solution.canJump(nums));
    }
}
