import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class S018 {
    public static void main (String[] args) {
        S018 solution = new S018();
        solution.fourSum(new int[] {1,2,3,5,6,-2}, 3);
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i<nums.length - 3; i++) {
            if (i!=0 && nums[i] == nums[i -1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length -2; j++) {
                if ((j!= i+1) && nums[j] == nums[j -1]) {
                    continue;
                }
                int poor = target - nums[i] - nums[j];
                int l = j + 1;
                int r = nums.length - 1;
                while(l < r) {
                    if(nums[l]+nums[r]==poor) {
                        res.add(Arrays.asList(nums[i],nums[j],nums[l],nums[r]));
                        while(l<r && nums[l]==nums[l+1]){
                            l++;
                        }
                        while(l<r && nums[r]==nums[r-1]){
                            r--;
                        }
                        l++;
                        r--;
                    }else if(nums[l]+nums[r] < poor){
                        l++;
                    }else r--;
                }
            }
        }
        return res;
    }
}
