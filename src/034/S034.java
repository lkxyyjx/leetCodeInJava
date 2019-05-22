public class S034 {

    public static void main(String[] args) {
        S034 solution = new S034();
        solution.searchRange(new int[]{1, 2, 2, 3, 4, 5, 5, 6, 6, 6, 7, 7, 8, 8, 9}, 6);
        System.out.println(solution.searchRange(new int[]{1, 2, 2, 3, 4, 5, 5, 6, 6, 6, 7, 7, 8, 8, 9}, 6));
    }

    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[] {-1, -1};
        int numsLen = nums.length;
        if (numsLen == 0) {
            return res;
        } else if (numsLen == 1) {
            if (target == nums[0]) {
                res[0] = 0;
                res[0] = 0;
                return res;
            }
        }

        int leftP = 0;
        int rightP = numsLen - 1;
        int mid;
        boolean findTargetInFirstLoop = false;
        while (leftP != rightP) {
            mid = leftP + (rightP - leftP) / 2;
            if (nums[mid] > target) {
                rightP = mid;
            } else if (nums[mid] < target) {
                leftP = mid;
            } else if (nums[mid] == target) {
                findTargetInFirstLoop = true;
                break;
            }
        }
        //分两个区间查找上界和下界
        while () {
            
        }
        return res;
    }
}
