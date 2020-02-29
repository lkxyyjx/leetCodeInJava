public class S091 {
    public int numDecodings(String s) {
        if (s.length() < 1) return 0;
        int dpWays[] = new int[s.length() + 1];
        dpWays[0] = 1;
        if (s.charAt(0) == '0') {
            return 0;
        } else {
            dpWays[1] = 1;
        }
        for (int i = 2; i < s.length() + 1; i ++) {
            if (s.charAt(i - 1) == '0') {
                if (s.charAt(i - 2) == '1' || s.charAt(i - 2) == '2') {
                    dpWays[i] = dpWays[i - 2];
                } else {
                    return 0;
                }
            } else if (s.charAt(i - 1) <= '6') {
                if (s.charAt(i - 2) == '1' || s.charAt(i - 2) == '2') {
                    dpWays[i] = dpWays[i - 1] + dpWays[i - 2];
                } else {
                    dpWays[i] = dpWays[i - 1];
                }
            } else {
                if (s.charAt(i - 2) == '1') {
                    dpWays[i] = dpWays[i - 1] + dpWays[i - 2];
                } else {
                    dpWays[i] = dpWays[i - 1];
                }
            }
        }
        return dpWays[s.length()];
    }
}
