public class S032 {
    public static void main(String[] args) {
        S032 solution = new S032();
        System.out.println(solution.longestValidParentheses("()((())))"));

    }

    public int longestValidParentheses(String s) {
        int res = 0;
        int strLen = s.length();
        if (strLen < 2) {
            return 0;
        }
        char[] sb = s.toCharArray();
        int tempRes;
        for (int i = 0 ; i < strLen - 1; i++) {
            tempRes = this.getValidLength(sb, i);
            res = res > tempRes ? res : tempRes;
        }
        return res;
    }

    private int getValidLength(char[] sb, int n) {
        int res = 0;
        int couple = 0;
        int strLen = sb.length;
        if (strLen < 2) {
            return 0;
        }

        int redundancenBracketsCount = 0;
        int i = n;
        for (; i < strLen ; i ++) {
            if (sb[i] == '(') {
                redundancenBracketsCount ++;
                couple ++;
            }
            else {
                redundancenBracketsCount --;
            }

            if (redundancenBracketsCount < 0) break;
            else if (redundancenBracketsCount == 0) res = couple * 2;
        }
        return res;
    }
}
