/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *
 * 你可以假设数组中无重复元素。
 */
public class S035 {

    public static void main(String[] args) {
        S035 solution = new S035();
        System.out.println(solution.searchInsert(new int[]{0, 1, 2, 4, 5, 6, 7}, 3));
    }

    public int searchInsert(int[] nums, int target) {
        int res = -1;
        int numsLen = nums.length;
        if (numsLen == 0) {
            return res;
        } else if (numsLen == 1) {
            if (target == nums[0]) {
                res = 0;
                return res;
            }
        }

        int leftP = 0;
        int rightP = numsLen - 1;
        int mid;
        while (leftP <= rightP) {
            mid = leftP + (rightP - leftP) / 2;
            if (nums[mid] > target) {
                rightP = mid - 1;
            } else if (nums[mid] < target) {
                leftP = mid + 1;
            } else {
                res = mid;
                break;
            }
        }

        if (leftP > rightP) {
            res = leftP;
        }

        return res;
    }
}
