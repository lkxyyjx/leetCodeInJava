import java.util.ArrayList;
import java.util.List;

public class S093 {
    private List<String> res = new ArrayList<>();
    private StringBuilder singleRes = new StringBuilder();
    public List<String> restoreIpAddresses(String s) {
        if (s.length() < 4) return res;
        singleRes.append(s);
        restoreIpAddresses(s, 0, 0);
        return res;
    }

    private void restoreIpAddresses (String s, int curPos, int curDotNum) {
        if (curDotNum == 3) {
            if (singleRes.length() - curPos <= 3
                    && Integer.parseInt(singleRes.substring(curPos, singleRes.length())) <= 255
                    && !(singleRes.charAt(curPos) == '0' && singleRes.length() - curPos > 1)) {
                res.add(singleRes.toString());
            }
            return;
        }
        StringBuilder judgement = new StringBuilder();
        for (int i = 1; i < 4; i ++) {
            judgement.append(singleRes.charAt(curPos + i - 1));
            if (curPos + i >= singleRes.length()
            || Integer.parseInt(judgement.toString()) > 255
                    || (Integer.parseInt(judgement.toString()) < 10 && judgement.length() >= 2))
                break;
            singleRes.insert(curPos + i, '.');
            restoreIpAddresses(s, curPos + i + 1, curDotNum + 1);
            singleRes.delete(curPos + i, curPos + i + 1);
        }
    }

    public static void main (String[] str) {
        S093 solution = new S093();
        String s = "0279245587303";
        System.out.println(solution.restoreIpAddresses(s));
    }
}
