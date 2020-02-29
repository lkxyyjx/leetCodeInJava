import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class S090 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> singleRes = new ArrayList<>();
        Arrays.sort(nums);
        int start = 0;
        res.add(new ArrayList<>(singleRes));
        int curResLen = 0;
        for (int i = 0; i < nums.length; i ++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                start = curResLen;
            } else {
                start = 0;
            }
            curResLen = res.size();
            for (int j = start; j < curResLen; j ++) {
                singleRes.clear();
                singleRes.addAll(res.get(j));
                singleRes.add(nums[i]);
                res.add(new ArrayList<>(singleRes));
            }
        }
        return res;
    }

    public static void main(String[] str) {
        S090 solution = new S090();
        System.out.println(solution.subsetsWithDup(new int[] {1,2,2}));
    }
}
