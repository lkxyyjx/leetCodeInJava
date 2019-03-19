import java.util.Arrays;

public class S026 {
    public static void main(String[] args) {
        S026 solution = new S026();
        int[] a = {1,1,1,2,2,2,3,4,5};
        System.out.println(solution.removeDuplicates(a));
        System.out.println(Arrays.toString(a));

    }

    public int removeDuplicates(int[] nums) {
        if (nums.length < 2) return nums.length;

        int resLen = 1;
        int currentNum = nums[0];
        for (int i = 0; i < nums.length; i ++) {
            if (currentNum != nums[i]) {
                nums[resLen ++] = nums[i];
                currentNum = nums[i];
            }
        }

        return resLen;
    }
}
