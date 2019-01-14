public class S009 {
    public static void main(String[] args) {
        S009 hw = new S009();
        System.out.println(hw.isPalindrome(12321));
    }

    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        return x == reverse(x) ? true : false;
    }

    public long reverse(int x) {
        boolean isPosiNum = x >= 0;
        if (!isPosiNum) {
            x = -x;
        }
        long res = 0;
        int remainder = 0;
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
