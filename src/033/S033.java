public class S033 {

    public static void main(String[] args) {
        S033 solution = new S033();
        System.out.println(solution.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
    }

    public int search(int[] nums, int target) {
        int res = -1;
        int len = nums.length;

        if (len < 1) {
            return res;
        } else if (len == 1) {
            return nums[0] == target ? 0 : -1;
        }

        int leftP = 1;
        int rightP = len;
        int mid = (rightP + leftP) / 2;


        while (mid != rightP && mid != leftP) {
            //后半部有序
            if (nums[mid - 1] <= nums[rightP - 1]) {
                if (target >= nums[mid - 1]) {
                    if (target <= nums[rightP - 1]) {
                        leftP = mid;
                    } else {
                        rightP = mid;
                    }
                } else {
                    rightP = mid;
                }
            }
            //前半部有序
            else {
                if (target <= nums[mid - 1]) {
                    if (target >= nums[leftP - 1]) {
                        rightP = mid;
                    } else {
                        leftP = mid;
                    }
                } else {
                    leftP = mid;
                }
            }
            mid = (rightP + leftP) / 2;
        }
        System.out.println(leftP);
        System.out.println(rightP);
        if (target == nums[leftP - 1]) {
            res = leftP - 1;
        } else if (target == nums[rightP - 1]) {
            res = rightP - 1;
        }

        return res;
    }

}
