import java.util.ArrayList;
import java.util.List;

public class S068 {
    public List<String> fullJustify(String[] words, int maxWidth) {
        if (words.length < 1) return new ArrayList<>();
        int countLen = 0;
        int countCharLen = 0;

        int leastSpaceCount;
        int preIndex = 0;

        int curNeededSpaceNum;
        int reminderSpace;
        int NeededSpaceNum;
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.length;) {
            leastSpaceCount = countLen == 0 ? 0 : 1;
            if (countLen + words[i].length() + leastSpaceCount > maxWidth) {
                sb.delete(0, sb.length());
                //只有一个单词的情况
                if ((i - 1 - preIndex) == 0) {
                    sb.append(words[i-1]);
                    while (sb.length() < maxWidth) sb.append(' ');
                    res.add(sb.toString());
                } else {
                    NeededSpaceNum = (maxWidth - countCharLen) / (i - 1 - preIndex);
                    reminderSpace = (maxWidth - countCharLen) % (i - 1 - preIndex);
                    //构造一行字符串
                    for (int wordIndex = 0; preIndex + wordIndex < i; wordIndex++) {
                        sb.append(words[preIndex + wordIndex]);
                        if (preIndex + wordIndex < i - 1) {
                            curNeededSpaceNum = wordIndex < reminderSpace ? NeededSpaceNum + 1 : NeededSpaceNum;
                            for (int spaceAppendNum = 0; spaceAppendNum < curNeededSpaceNum; spaceAppendNum++) {
                                sb.append(' ');
                            }
                        }
                    }
                    res.add(sb.toString());
                }
                preIndex = i;
                countLen = 0;
                countCharLen = 0;
            } else {
                countLen = countLen + words[i].length() + leastSpaceCount;
                countCharLen += words[i].length();
                i ++;
            }
        }
        sb.delete(0, sb.length());
        for (int wordIndex = 0; wordIndex < words.length - preIndex; wordIndex ++) {
            sb.append(words[preIndex+wordIndex]);
            if (wordIndex < words.length - preIndex - 1) {
                sb.append(' ');
            }
        }
        while (sb.length() < maxWidth) sb.append(' ');
        res.add(sb.toString());
        return res;
    }

    public static void main (String[] str) {
        S068 solution = new S068();
        String[] words = new String[] {"What","must","be","acknowledgment","shall","be"};
        int maxWidth = 16;
        System.out.println(solution.fullJustify(words, maxWidth));
    }
}
