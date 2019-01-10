import java.util.regex.*;

public class S008 {
    public static void main(String[] args) {
        S008 hw = new S008();
        System.out.println(hw.myAtoi("-123fdsa"));
    }

    public int myAtoi(String str) {
        String resStr;
        Pattern p = Pattern.compile("\\s*-?\\d+");
        Matcher m = p.matcher(str);
        if (m.find()) {
            resStr = m.group(0);
        } else {
            resStr = "0";
        }
        return Integer.valueOf(resStr);
    }
}
