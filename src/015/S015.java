import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
public class S015 {
    public static void main (String[] args) {
        S015 solution = new S015();
        System.out.println(solution.threeSum(new int[] {

        }));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        HashSet<List<Integer>> tempRes = new HashSet<>(res);
        Arrays.sort(nums);
        for (int i = 0; i < nums.length;i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> eachRes = new ArrayList<>();
                        eachRes.add(nums[i]);
                        eachRes.add(nums[j]);
                        eachRes.add(nums[k]);
                        tempRes.add(eachRes);
                    }
                }
            }
        }
        res.addAll(tempRes);
        return res;
    }
}
