public class S066 {
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        int addOne = 0;
        for (int i = len - 1; i >= 0; i --) {
            digits[i] = digits[i] + 1;
            addOne = digits[i] > 9 ? 1 : 0;
            digits[i] = digits[i] % 10;
            if (addOne == 0)break;
        }
        if (addOne == 1) {
            int[] res = new int[len + 1];
            res[0] = 1;
            for (int i = 1; i < res.length; i ++) {
                res[i] = digits[i-1];
            }
            return res;
        }
        return digits;
    }
}
