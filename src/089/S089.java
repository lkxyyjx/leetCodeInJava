import java.util.*;

public class S089 {
    public List<Integer> grayCode(int n) {
        Deque<Integer> resStack = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        res.add(0);
        resStack.push(0);
        for (int i = 0; i < n; i ++) {
            while (!resStack.isEmpty()) {
                res.add(resStack.poll() | 1 << i);
            }
            for (Integer num: res) {
                resStack.push(num);
            }
        }
        return res;
    }

    public static void main (String[] str) {
        S089 solution = new S089();
        System.out.println(solution.grayCode(2));
    }
}
