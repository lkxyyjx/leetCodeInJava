import java.util.ArrayList;
import java.util.List;

public class S030 {
    public static void main(String[] args) {
        S030 solution = new S030();
        System.out.println(solution.findSubstring("barfoothefoobarman", new String[] {"foo","bar"}));
    }

    public List<Integer> findSubstring(String s, String[] words) {

        List<Integer> ret = new ArrayList<>();
        int wordsNum = words.length;
        if (wordsNum < 1) return ret;
        int wordLen = words[0].length();
        //todo:可换成hashmap记录word出现的次数
        boolean[] isWordsUsed = new boolean[wordsNum];

        StringBuffer sb1 = new StringBuffer(s);
        StringBuffer sb2 = new StringBuffer();
        int endPosition = s.length() - wordLen * wordsNum + 1;
        boolean breakFlag;
        int usedWordNum;
        for (int i = 0; i < endPosition; i ++) {
            for (int b = 0; b < wordsNum; b ++) {
                isWordsUsed[b] = false;
            }
            sb2.append(sb1.toString());
            breakFlag = false;
            usedWordNum = 0;
            while (!breakFlag) {
                for (int j = 0; j < wordsNum; j ++) {
                    if (!isWordsUsed[j] && sb2.indexOf(words[j]) == 0) {
                        isWordsUsed[j] = true;
                        sb2.delete(0, wordLen);
                        usedWordNum ++;
                        break;
                    }
                    if (j == wordsNum - 1) {
                        breakFlag = true;
                    }
                }
            }
            if (usedWordNum == wordsNum) {
                ret.add(i);
            }
            sb2.delete(0, sb2.length());
            sb1.delete(0, 1);
        }
        return ret;
    }

}
