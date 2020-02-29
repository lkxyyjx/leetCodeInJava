import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class S077 {
    private List<List<Integer>> combination = new LinkedList<>();
    private List<Integer> temp = new LinkedList<>();
    public List<List<Integer>> combine(int n, int k) {
        if (k > n || k == 0) return new LinkedList<>();
        combineRescuely(n, k, 1);
        return combination;
    }

    private void combineRescuely(int n, int k, int curNum) {
        if (temp.size() == k)  {
            combination.add(new LinkedList<>(temp));
            return;
        }
        int lastNum = n + 2 - (k - temp.size());
        for (int i = curNum; i < lastNum; i ++) {
            temp.add(i);
            combineRescuely(n, k, i + 1);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main (String[] str) {
        S077 solution = new S077();
        System.out.println(solution.combine(4,2));
    }
}
