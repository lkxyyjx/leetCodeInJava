import javafx.util.Pair;

import java.util.*;

public class S040 {
    public static void main(String[] args) {
        S040 solution = new S040();
        List<List<Integer>> result;
        result = solution.combinationSum2(new int[]{1}, 2);
        System.out.println(result);
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates.length < 1) return new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        List<Pair<Integer, Integer>> backTrackingStack = new ArrayList<>();
        int sum = candidates[0];
        int leftIndex = 0;
        int rightIndex = 1;
        List<Integer> singleResult;
        backTrackingStack.add(new Pair<>(0, candidates[0]));
        while (leftIndex < candidates.length) {
            if (sum < target) {
                if (rightIndex > candidates.length - 1) {
                    rightIndex = backTrackingStack.get(backTrackingStack.size() - 1).getKey() + 1;
                    sum -= backTrackingStack.get(backTrackingStack.size() - 1).getValue();
                    if (sum == 0) leftIndex = backTrackingStack.get(backTrackingStack.size() - 1).getKey() + 1;
                    backTrackingStack.remove(backTrackingStack.size() - 1);
                } else {
                    backTrackingStack.add(new Pair<>(rightIndex, candidates[rightIndex]));
                    sum += candidates[rightIndex ++];
                }
            } else {
                if (sum == target) {
                    singleResult = new ArrayList<>();
                    for (Pair<Integer, Integer> loopPair :
                            backTrackingStack) {
                        singleResult.add(loopPair.getValue());
                    }
                    singleResult.sort(Comparator.comparingInt((obj)->obj));
                    result.add(singleResult);
                }
                rightIndex = backTrackingStack.get(backTrackingStack.size() - 1).getKey() + 1;
                sum -= backTrackingStack.get(backTrackingStack.size() - 1).getValue();
                if (sum == 0) leftIndex = backTrackingStack.get(backTrackingStack.size() - 1).getKey() + 1;
                backTrackingStack.remove(backTrackingStack.size() - 1);
            }
        }
        Set<List<Integer>> listWithoutDuplicates = new LinkedHashSet<>(result);
        result = new ArrayList<>(listWithoutDuplicates);
        return  result;
    }
}
