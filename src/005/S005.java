public class S005 {
    public static void main(String[] args) {
        S005 hw = new S005();
        System.out.println(hw.longestPalindrome("babad"));
    }

    public String longestPalindrome(String s) {
        String res = "";
        int strLen = s.length();
        int[] strPos1 = new int[2];
        int[] strPos2 = new int[2];
        int[] resStrPos1 = new int[2];
        int[] resStrPos2 = new int[2];

        if (strLen > 1000 || strLen == 0) {
            return res;
        }
        for (int i = 0; i < strLen; i++) {
            strPos1[0] = i;
            strPos1[1] = i;
            longestPalindromeByPos(s, strPos1);
            if (i+1 < s.length() && s.charAt(i) == s.charAt(i+1)) {
                strPos2[0] = i;
                strPos2[1] = i + 1;
                longestPalindromeByPos(s, strPos2);
                if (compareStrPosLen(strPos1, strPos2)) {
                    resStrPos1 = strPos1.clone();
                } else {
                    resStrPos1 = strPos2.clone();
                }
            } else {
                resStrPos1 = strPos1.clone();
            }
            if (compareStrPosLen(resStrPos1, resStrPos2)) {
                resStrPos2 = resStrPos1.clone();
            }
        }
        res = s.substring(resStrPos2[0], resStrPos2[1] + 1);
        return res;
    }

    private void longestPalindromeByPos(String s, int[] strPos) {
        while (strPos[1] + 1 < s.length() && strPos[0] > 0 && s.charAt(strPos[0] - 1) == s.charAt(strPos[1] + 1)) {
            strPos[0]--;
            strPos[1]++;
        }
    }

    private boolean compareStrPosLen(int[] strPos1, int[] strPos2) {
        return strPos1[1] - strPos1[0] > strPos2[1] - strPos2[0];
    }
}
