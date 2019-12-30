public class S041 {
    static boolean ifdebug = true;

    public static void main(String args[]) {
        S041 solution = new S041();
        System.out.println(solution.firstMissingPositive(new int[]{-1,4,2,1,9,10}));
    }

    public int firstMissingPositive(int[] nums) {
        int result = -1;
        if (nums.length < 1) return 1;
        int temp = 0;
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] > 0 && nums[i] < nums.length && nums[i] != i + 1 && nums[i] != nums[nums[i] - 1]) {
                temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
            if (ifdebug) {
                System.out.println(i + "round");
                for (int j = 0; j < nums.length; j++) {
                    System.out.println("nums[" + j + "] = " + nums[j]);
                }
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                result = i + 1;
                break;
            }
        }

        if (result == -1) result = nums[nums.length - 1] + 1;

        return result;
    }
}
