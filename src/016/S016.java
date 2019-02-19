import java.util.Arrays;
import java.lang.Math;

public class S016 {
    public static void main (String[] args) {
        S016 solution = new S016();
        System.out.println(solution.threeSumClosest(new int[] {0,2,1,-3}, 1));
    }

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closestNum = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            int l = i + 1, r = nums.length - 1;
            while (l < r){
                int threeSum = nums[l] + nums[r] + nums[i];
                if (Math.abs(threeSum - target) < Math.abs(closestNum - target)) {
                    closestNum = threeSum;
                }
                if (threeSum > target) {
                    r--;
                } else if (threeSum < target) {
                    l++;
                } else {
                    return target;
                }

            }

        }

        return closestNum;
    }
}
