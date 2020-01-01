import java.util.ArrayList;
import java.util.List;

public class S043 {
    public static void main (String[] args) {
        S043 solution = new S043();
        System.out.println(solution.multiply("123", "345"));
    }

    public String multiply(String num1, String num2) {
        List<Integer> result = new ArrayList<>();
        int len1 = num1.length();
        int len2 = num2.length();
        int position;
        int singleResult;
        for (int i = len2 - 1; i >= 0; i --) {
            for (int j = len1 - 1; j >= 0; j --) {
                position = len2 - 1 - i + (len1 - 1 - j);
                singleResult = (num1.charAt(j) - '0') * (num2.charAt(i) - '0');
                if (result.size() - 1 < position) {
                    result.add(singleResult);
                } else {
                    result.set(position, result.get(position) + singleResult);
                }
            }
        }

        int quotient;
        int remainder;
        for (int i = 0; i < result.size() - 1; i ++) {
            quotient = result.get(i) / 10;
            remainder = result.get(i) % 10;
            result.set(i, remainder);
            result.set(i + 1, result.get(i + 1) + quotient);
        }

        boolean notZeroFlag = false;
        StringBuilder resultString = new StringBuilder();
        for (int i = result.size() - 1; i >= 0; i --) {
            if (result.get(i) != 0) {
                notZeroFlag = true;
            }
            if (notZeroFlag) {
                resultString.append(result.get(i).toString());
            }
        }

        if (!notZeroFlag) return "0";
        return resultString.toString();
    }
}
