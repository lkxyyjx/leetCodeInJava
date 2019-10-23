import javafx.util.Pair;
import java.util.ArrayList;
import java.util.List;

public class S039 {
    public static void main (String[] args) {
        S039 solution = new S039();
        List<List<Integer>> result = new ArrayList<>();
        result = solution.combinationSum(new int[]{2,3,6,7}, 7);
        System.out.println(result);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (candidates.length < 1) return result;
        //pair key为数组index value为值
        List<Pair<Integer, Integer>> backTrackingStack = new ArrayList<>();
        backTrackingStack.add(new Pair<>(0, candidates[0]));
        int sum = candidates[0];
        List<Integer> singleResult;
        int lastIndex = 0;
        int firstIndex = 0;
        while (firstIndex < candidates.length) {
            if (sum >= target) {
                if (sum == target) {
                    singleResult = new ArrayList<>();
                    for (Pair<Integer, Integer> loopPair :
                            backTrackingStack) {
                        singleResult.add(loopPair.getValue());
                    }
                    result.add(singleResult);
                }
                lastIndex = backTrackingStack.get(backTrackingStack.size() - 1).getKey() + 1;
                sum -= backTrackingStack.get(backTrackingStack.size() - 1).getValue();
                if (sum == 0) firstIndex = backTrackingStack.get(backTrackingStack.size() - 1).getKey() + 1;
                backTrackingStack.remove(backTrackingStack.size() - 1);
            } else {
                if (lastIndex > candidates.length - 1) {
                    lastIndex = backTrackingStack.get(backTrackingStack.size() - 1).getKey() + 1;
                    sum -= backTrackingStack.get(backTrackingStack.size() - 1).getValue();
                    if (sum == 0) firstIndex = backTrackingStack.get(backTrackingStack.size() - 1).getKey() + 1;
                    backTrackingStack.remove(backTrackingStack.size() - 1);
                } else {
                    backTrackingStack.add(new Pair<>(lastIndex, candidates[lastIndex]));
                    sum += candidates[lastIndex];
                }
            }

        }
        return result;
    }
}
