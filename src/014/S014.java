public class S014 {
    public static void main(String[] args) {
        S014 hw = new S014();
        System.out.println(hw.longestCommonPrefix(new String[] {"fdsaf","fdsafasd"}));
    }

    public String longestCommonPrefix(String[] strs) {
        String res = "";
        int arrLen = strs.length;
        int strLen;
        int i,j;
        if (arrLen < 1) {
            return res;
        } else {
            res = strs[0];
            for (i = 0; i < arrLen; i++) {
                 strLen = strs[i].length() < res.length() ? strs[i].length() : res.length();
                 j = 1;
                 while (j <= strLen && strs[i].substring(0, j).equals(res.substring(0, j))) {
                     j ++;
                 }
                 res = res.substring(0, j - 1);
            }
        }
        return res;
    }
}
