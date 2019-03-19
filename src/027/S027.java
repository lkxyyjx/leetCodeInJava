import java.util.Arrays;

public class S027 {
    public static void main(String[] args) {
        S027 solution = new S027();
        int[] a = {1,2,3,3,3,3,3,3};
        System.out.println(solution.removeElement(a, 3));
        System.out.println(Arrays.toString(a));

    }

    public int removeElement(int[] nums, int val) {
        int numsLen = nums.length;
        if (numsLen < 1) return 0;
        int valCount = 0;
        for (int i = 0 ;i < numsLen; i ++) {
            if (nums[i] != val) {
                nums[valCount++] = nums[i];
            }
        }
        return valCount;
    }
}
