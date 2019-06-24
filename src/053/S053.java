public class S053 {
    public static void main(String[] args) {
        S053 solution = new S053();
        System.out.println(solution.maxSubArray(new int[] {-2,1,-3,4,-1,2,1,-5,4}));
    }

    public int maxSubArray(int[] nums) {
        //resArr[0]=>pLeft, [1]=>pRight, [2]=>maxSubArraySum
        int[] resArr;
        int len = nums.length;
        if (len < 1) {
            return 0;
        } else if (len == 1) {
            return nums[0];
        }

        resArr = dfs(0, len - 1, nums, "");

        System.out.println(resArr[0]);
        System.out.println(resArr[1]);
        return resArr[2];
    }

    private int[] dfs(int left, int right, int[] nums, String part) {
        int[] res = new int[3];
        if (left == right) {
            res[0] = res[1] = left;
            res[2] = nums[left];
            return res;
        }

        int mid = left + (right - left)/2;
        int[] leftRes;
        int[] rightRes;
        leftRes = dfs(left, mid, nums, "left");
        rightRes = dfs(mid + 1, right, nums, "right");

        int midSum;
        if (leftRes[1] < mid || rightRes[0] > mid + 1) {
            midSum = 0;
            for (int i = leftRes[1] + 1; i < rightRes[0]; i++ ) {
                midSum += nums[i];
            }
            if (Integer.min(leftRes[2], rightRes[2]) + midSum > 0) {
                res[0] = leftRes[0];
                res[1] = rightRes[1];
                res[2] = midSum + leftRes[2] + rightRes[2];
            } else if (leftRes[2] > rightRes[2]) {
                res = leftRes;
            } else if (leftRes[2] < rightRes[2]) {
                res = rightRes;
            } else {
                if (part == "left") {
                    res = rightRes;
                } else {
                    res = leftRes;
                }
            }
        } else {
            if (leftRes[2] > 0 && rightRes[2] > 0) {
                res[0] = leftRes[0];
                res[1] = rightRes[1];
                res[2] = leftRes[2] + rightRes[2];
            } else if (leftRes[2] > rightRes[2]) {
                res = leftRes;
            } else if (leftRes[2] < rightRes[2]) {
                res = rightRes;
            } else{
                if (part == "left") {
                    res = rightRes;
                } else {
                    res = leftRes;
                }
            }
        }

        return res;
    }
}
