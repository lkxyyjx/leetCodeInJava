import java.util.Map;
import java.util.HashMap;


public class S013 {
    public static void main(String[] args) {
        S013 hw = new S013();
        System.out.println(hw.romanToInt("IX"));
    }


    public int romanToInt(String s) {
        int res = 0;
        int pre;
        int back;
        int len = s.length();
        Map<Character, Integer> roman = new HashMap<>();
        roman.put('I', 1);
        roman.put('V', 5);
        roman.put('X', 10);
        roman.put('L', 50);
        roman.put('C', 100);
        roman.put('D', 500);
        roman.put('M', 1000);

        for (int i = 0; i < len; i++) {
            if (i == len - 1) {
                res += roman.get(s.charAt(i));
            } else {
                pre = roman.get(s.charAt(i));
                back = roman.get(s.charAt(i + 1));
                if (pre >= back) {
                    res += pre;
                } else {
                    res -= pre;
                }
            }
        }
        return res;
    }

}
