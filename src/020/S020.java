import java.util.Stack;

public class S020 {
    public static void main(String[] args) {
        S020 solution = new S020();
        System.out.println(solution.isValid("((()))}"));
    }

    public boolean isValid(String s) {
        Stack stack = new Stack<Character>();
        int strLen = s.length();
        char c;
        for (int i = 0; i < strLen; i++) {
            c = s.charAt(i);
            if (c == '[' || c == '(' || c == '{') {
                stack.push(c);
            } else {
                if (stack.empty()) return false;
                if ((c == ')' && stack.pop().equals('(')) ||
                        (c == ']' && stack.pop().equals('[')) ||
                        (c == '}' && stack.pop().equals('{'))) {
                    continue;
                } else {
                    return false;
                }
            }
        }
        return stack.empty();
    }
}
