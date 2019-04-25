import java.util.Arrays;

public class S031 {
    public static void main(String[] args) {
        S031 solution = new S031();
        int[] nums = new int[] {5,4,7,5,3,2};
        solution.nextPermutation(nums);
        for (int num: nums
             ) {
           System.out.println(num);
        }
    }

    public void nextPermutation(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return;
        }
        int index = 0;
        for (int i = len - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                index = i - 1;
                break;
            } else if (i == 1) {
                Arrays.sort(nums);
                return;
            }
        }
        int temp;
        int indexOfMin = index + 1;
        if (nums[len - 1] > nums[index]) {
            indexOfMin = len  - 1;
        } else {
            for (int i = index + 1; i < len; i++) {
                if (nums[i] <= nums[index]) {
                    indexOfMin = i - 1;
                    break;
                }
            }
        }
        temp = nums[index];
        nums[index] = nums[indexOfMin];
        nums[indexOfMin] = temp;
        Arrays.sort(nums, index + 1, len);
    }

}
