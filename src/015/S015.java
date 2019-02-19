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
        Arrays.sort(nums);
        for(int i =0; i<nums.length-2;i++){
            if(i!=0 && nums[i]==nums[i-1])
                continue;
            int poor = 0-nums[i];
            int l = i+1;
            int r = nums.length-1;
            while(l < r) {
                if(nums[l]+nums[r]==poor) {
                    res.add(Arrays.asList(nums[i],nums[l],nums[r]));
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

        return res;
    }
}
