import java.util.Map;
import java.util.HashMap;


public class S003 {

    public static void main(String[] args) {
        S003 hw = new S003();
        System.out.println(hw.lengthOfLongestSubstring("pezfhjqkecapqsidubmecoqnsrulakerofyyrpivrkkheumyxzdzpvmhmjvpvb"));
    }

    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        Map <Character, Integer> charMap = new HashMap<>();
        int head = 0;
        int tail = 1;
        int sLength = s.length();
        char newChar;
        if (sLength > 0) {
            while (head < tail && sLength >= tail) {
                newChar = s.charAt(tail - 1);
                if (charMap.containsKey(newChar)) {
                    head = head > charMap.get(newChar) ? head : charMap.get(newChar);
                }
                charMap.put(newChar, tail);

                res = res > tail - head ? res : tail - head;
                tail ++;

            }
        }
        return res;
    }

}
