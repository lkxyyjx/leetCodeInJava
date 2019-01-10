public class S007 {
    public static void main(String[] args) {
        S007 hw = new S007();
        System.out.println(hw.reverse(1534236469));
    }

    public int reverse(int x) {
        boolean isPosiNum = x >= 0;
        if (!isPosiNum) {
            x = -x;
        }
        int res = 0;
        int remainder;
        while (x != 0) {
            remainder = x % 10;
            if ((Integer.MAX_VALUE - remainder) / 10 < res) {
                return 0;
            }
            res = res * 10 + remainder;
            x /= 10;
        }
        res = isPosiNum ? res : -res;
        return res;
    }
}
