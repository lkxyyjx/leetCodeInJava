import java.util.ArrayList;
import java.util.List;

public class S046 {

    private List<List<Integer>> res;
    private int[] nums;

    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        this.nums = nums;
        boolean[] used = new boolean[nums.length];
        List<Integer> singleRes = new ArrayList<>();
        dfs(used, singleRes);
        return res;
    }

    public void dfs(boolean[] used, List<Integer> res) {
        if(res.size() == nums.length) {
            this.res.add(new ArrayList<>(res));
            return;
        }
        for (int i = 0; i < used.length; i ++) {
            if (used[i]) continue;
            used[i] = true;
            res.add(nums[i]);
            dfs(used, res);
            used[i] = false;
            res.remove(res.size() - 1);
        }
    }

    public static void main(String[] str) {
        S046 solution = new S046();
        int[] nums = new int[] {1,2,3};
        List<List<Integer>> res;
        res = solution.permute(nums);
        for(int j = 0; j < res.size(); j ++) {
            System.out.println("sequence:");
            for (int i = 0; i < nums.length; i++) {
                System.out.println(res.get(j).get(i));
            }
        }
    }
}
