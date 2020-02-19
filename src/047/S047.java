import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 回溯+剪枝，具体参看代码
 */
public class S047 {

    private int[] nums;
    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums.length < 1)return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> singleRes = new ArrayList<>();
        this.nums = nums;
        /* 对数组排序方便剪枝 */
        Arrays.sort(nums);
        /* 记录用了哪个位置的数 */
        Stack<Integer> backTracking = new Stack<>();
        boolean[] used = new boolean[this.nums.length];
        int curPos;
        boolean valid;

        backTracking.add(0);
        singleRes.add(this.nums[0]);
        used[0] = true;
        curPos = -1;
        while (!(backTracking.empty() && curPos == this.nums.length - 1)) {
            if (singleRes.size() == this.nums.length) {
                res.add(new ArrayList<>(singleRes));
                curPos = backTracking.pop();
                singleRes.remove(singleRes.size() - 1);
                used[curPos] = false;
            } else {
                valid = false;
                for (int i = curPos + 1; i < this.nums.length; i++) {
                    if (used[i]) continue;
                    /* 当前得到元素与上次回溯掉的元素相同时判断会出现重复数据，故进行剪枝，
                    注意这边的操作是对已经排序过的数组进行的操作 */
                    if (curPos != -1 && this.nums[curPos] == this.nums[i]) {
                        curPos = i;
                        valid = true;
                        continue;
                    }
                    backTracking.push(i);
                    singleRes.add(nums[i]);
                    used[i] = true;
                    curPos = -1;
                    valid = true;
                    break;
                }
                if (!valid) {
                    curPos = backTracking.pop();
                    singleRes.remove(singleRes.size() - 1);
                    used[curPos] = false;
                }
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < singleRes.size(); i++) {
                sb.append(singleRes.get(i).toString());
            }
            System.out.println("this time singleRes:" + sb.toString());
            System.out.println("this time curPos:" + curPos);
            for (int i = 0; i < used.length; i++) {
                System.out.println("used[" + i + "] = " + used[i]);
            }
        }
        return res;
    }

    public static void main(String[] str) {
        S047 solution = new S047();
        int[] nums = new int[] {1,1};
        List<List<Integer>> res;
        res = solution.permuteUnique(nums);
        for(int j = 0; j < res.size(); j ++) {
            System.out.println("sequence:");
            for (int i = 0; i < nums.length; i++) {
                System.out.println(res.get(j).get(i));
            }
        }
    }
}
