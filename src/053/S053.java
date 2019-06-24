public class S053 {
    public static void main(String[] args) {
        S053 solution = new S053();
        System.out.println(solution.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }

    public int maxSubArray(int[] nums) {
        int res;
        int len = nums.length;
        if (len < 1) {
            return 0;
        } else if (len == 1) {
            return nums[0];
        }

        res = dfs(0, len - 1, nums);

        return res;
    }

    private int dfs(int left, int right, int[] nums) {
        if (left == right) {
            return nums[left];
        }

        int mid = left + (right - left) / 2;
        int leftRes;
        int rightRes;
        int midRes;
        leftRes = dfs(left, mid, nums);
        rightRes = dfs(mid + 1, right, nums);
        midRes = maxSubArrayAll(left, mid, right, nums);

        return Integer.max(leftRes, Integer.max(rightRes, midRes));
    }

    private int maxSubArrayAll(int left, int mid, int right, int[] nums) {
        int leftSum = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = mid; i >= left; i--) {
            sum += nums[i];
            if (sum > leftSum) {
                leftSum = sum;
            }
        }
        sum = 0;
        int rightSum = Integer.MIN_VALUE;
        for (int i = mid + 1; i <= right; i++) {
            sum += nums[i];
            if (sum > rightSum) {
                rightSum = sum;
            }
        }
        return leftSum + rightSum;
    }
}
