import java.util.*;

public class S076 {
    public String minWindow(String s, String t) {
        int slen = s.length();
        int tlen = t.length();
        if (slen < tlen) return "";
        HashMap<Character, Integer> filledCharMap = new HashMap<>();
        HashSet<Character> charSetOfT = new HashSet<>();
        for (int i = 0; i < tlen; i ++) {
            filledCharMap.put(t.charAt(i), 0);
            charSetOfT.add(t.charAt(i));
        }
        int pLeft = 0;
        int pRight = 0;
        Queue<Integer> nextLeftPos = new LinkedList<>();
        HashSet<Integer> containsHashSet;
        StringBuilder res = new StringBuilder();
        int loopTime = 0;
        while (!(pRight == slen && nextLeftPos.size() < 3 && !charSetOfT.contains(s.charAt(pLeft)))) {
            if (loopTime > 20) break;
            loopTime ++;
            if (charSetOfT.contains(s.charAt(pRight))) {
                if(!nextLeftPos.contains(pRight) && pRight != 0) nextLeftPos.add(pRight);
                filledCharMap.put(s.charAt(pRight), filledCharMap.get(s.charAt(pRight)) + 1);
                //判断是否含有全部t的字符
                containsHashSet = new HashSet<>(filledCharMap.values());
                if (!containsHashSet.contains(0)) {
                    if (res.length() == 0) {
                        res.append(s, pLeft, pRight + 1);
                    } else if (res.length() > (pRight - pLeft + 1)) {
                        res.delete(0, res.length());
                        res.append(s, pLeft, pRight + 1);
                    }
                    //pLeft移至下一个匹配到t中的字符的位置
                    if (charSetOfT.contains(s.charAt(pLeft))) {
                        filledCharMap.put(s.charAt(pLeft), filledCharMap.get(s.charAt(pLeft)) - 1);
                    }
                    if (!nextLeftPos.isEmpty()) {
                        pLeft = nextLeftPos.poll();
                    } else {
                        break;
                    }
                    //没有移动pRight并且需要再次经过此判断，故预先将pRight对应计数-1
                    filledCharMap.put(s.charAt(pRight), filledCharMap.get(s.charAt(pRight)) - 1);
                    continue;
                }
            }
            if (pRight < slen - 1) pRight = pRight + 1;
        }
        return res.toString();
    }

    public static void main (String[] str) {
        S076 solution = new S076();
        String s = "ab";
        String t = "b";
        System.out.println(solution.minWindow(s, t));
    }
}
