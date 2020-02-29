import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class S078 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<List<Integer>> added =  new ArrayList<>();
        List<Integer> singleRes;
        res.add(new ArrayList<>());
        for (int i = 0; i < nums.length; i ++) {
            added.clear();
            for (List<Integer> oldRes: res) {
                singleRes = new ArrayList<>(oldRes);
                singleRes.add(nums[i]);
                added.add(singleRes);
            }
            res.addAll(added);
        }
        return res;
    }
}
