public class S075 {
    public void sortColors(int[] nums) {
        int len = nums.length;
        if (len < 2) return;
        int pZero = 0;
        int pOne = len - 1;
        int temp;
        while (pZero < pOne) {
            if (nums[pZero] > 0) {
                temp = nums[pOne];
                nums[pOne] = nums[pZero];
                nums[pZero] = temp;
                pOne --;
            } else {
                pZero ++;
            }
        }
        int pTwo = len - 1;
        while (pOne < pTwo) {
            if (nums[pOne] > 1) {
                temp = nums[pTwo];
                nums[pTwo] = nums[pOne];
                nums[pOne] = temp;
                pTwo --;
            } else {
                pOne ++;
            }
        }
    }
}
