public class S058 {
    public int lengthOfLastWord(String s) {
        int len = s.length();
        int res = 0;
        if (len < 1) return res;
        int curWordLen = 0;
        for (int i = 0; i < len; i ++) {
            if ((curWordLen != 0 && s.charAt(i) == ' ')) {
                res = curWordLen;
            }
            if (s.charAt(i) != ' ') {
                curWordLen ++;
            } else {
                curWordLen = 0;
            }
        }
        return curWordLen == 0 ? res : curWordLen;
    }

    public static void main (String[] str) {
        S058 solution = new S058();
        System.out.println(solution.lengthOfLastWord("b a  "));
    }
}
