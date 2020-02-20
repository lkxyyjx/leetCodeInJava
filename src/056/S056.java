import sun.management.AgentConfigurationError;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class S056 {
    public int[][] merge(int[][] intervals) {
        if (intervals.length < 2)return intervals;
        List<List<Integer>> intervalsList = new ArrayList<>();
        List<Integer> intervalList;
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> singleRes = new ArrayList<>();
        for (int[] interval:
             intervals) {
            intervalList = new ArrayList<>();
            intervalList.add(interval[0]);
            intervalList.add(interval[1]);
            intervalsList.add(intervalList);
        }
        intervalsList.sort(new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                if (o1.get(0) != o2.get(0)) return o1.get(0) - o2.get(0);
                return (o1.get(1) - o2.get(1));
            }
        });
        int start, end;
        start = intervalsList.get(0).get(0);
        end = intervalsList.get(0).get(1);
        for (int i = 1; i < intervalsList.size(); i ++) {
            if (start <= intervalsList.get(i).get(0) &&
                end >= intervalsList.get(i).get(0)) {
                end = Math.max(intervalsList.get(i).get(1), end);
            } else {
                singleRes.clear();
                singleRes.add(start);
                singleRes.add(end);
                res.add(new ArrayList<>(singleRes));
                start = intervalsList.get(i).get(0);
                end = intervalsList.get(i).get(1);
            }
        }
        singleRes.clear();
        singleRes.add(start);
        singleRes.add(end);
        res.add(new ArrayList<>(singleRes));
        int[][] resArray = new int[res.size()][2];
        for (int i = 0; i < res.size(); i ++) {
            resArray[i][0] = res.get(i).get(0);
            resArray[i][1] = res.get(i).get(1);
        }
        return resArray;
    }

    public static void main(String[] str) {
        S056 solution = new S056();
        int[][] intervals = new int[][] {{2,3},{4,5},{6,7},{1,10}};
        int[][] res = solution.merge(intervals);
        for (int[] it : res) {
            System.out.println("block:[" + it[0] + "," + it[1] + "]");
        }
    }
}
