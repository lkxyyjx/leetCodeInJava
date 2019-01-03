import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

class S001 {
    public static void main(String[] args) {
        S001 hw = new S001();
        int[] a = {1,2,3,4,5};
        System.out.println(Arrays.toString(hw.twoSum(a,9)));
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int couple = target - nums[i];
            if (map.containsKey(couple)) {
                return new int[] { map.get(couple), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("false");
    }
}