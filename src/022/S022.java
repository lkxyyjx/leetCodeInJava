import java.util.List;
import java.util.ArrayList;

public class S022 {

    public static void main(String[] args) {
        S022 hw = new S022();
        System.out.println(hw.generateParenthesis(3));
    }

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList();
        generate(res, 2 * n, 0, 0, "");
        return res;
    }

    public void generate(List<String> res, int length, int open, int close, String record) {
        if (record.length() >= length) {
            res.add(record);
            return;
        }

        if (open < length / 2) {
            generate(res, length, open + 1, close, record + "(");
        }

        if (close < open) {
            generate(res, length, open, close + 1, record + ")");
        }
    }

}
