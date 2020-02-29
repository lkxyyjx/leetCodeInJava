public class MS02 {
    public int solution(String S) {
        // write your code in Java SE 8
        if (S.length() < 1) return 0;
        StringBuilder sb = new StringBuilder(S);
        while (sb.length() > 0 && sb.charAt(0) == '0')sb.delete(0, 1);
        if (sb.length() == 0) return 0;
        int numsOfOne = 0;
        for (int i = 0; i < sb.length(); i ++) {
            if (sb.charAt(i) == '1') numsOfOne ++;
        }
        return numsOfOne + sb.length() - 1;
    }

    public static void main (String[] str) {
        MS02 solution = new MS02();
        System.out.println(solution.solution("111"));
    }
}
