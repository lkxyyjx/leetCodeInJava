public class S097 {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length())return false;
        if (s1.equals("")) return s2.equals(s3);
        if (s2.equals("")) return s1.equals(s3);
        boolean[][] dpIsInter = new boolean[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i < s1.length() + 1; i ++) {
            for (int j = 0; j < s2.length() + 1; j ++) {
                if (i == 0 && j == 0) {
                    dpIsInter[0][0] = true;
                } else if (i == 0) {
                    dpIsInter[i][j] = dpIsInter[i][j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1);
                } else if (j == 0) {
                    dpIsInter[i][j] = dpIsInter[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i - 1);
                } else {
                    dpIsInter[i][j] = (dpIsInter[i][j - 1] && s2.charAt(j - 1) == s3.charAt(j + i - 1)) ||
                            (dpIsInter[i - 1][j] && s1.charAt(i - 1) == s3.charAt(j + i - 1));
                }
                System.out.println("dp [" + i + "][" + j +"] = " + dpIsInter[i][j]);
            }
        }
        return dpIsInter[s1.length()][s2.length()];
    }
}
