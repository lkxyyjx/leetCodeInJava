import java.util.*;

public class S049 {
    public List<List<String>> groupAnagrams(String[] strs) {
        int wordNum = strs.length;
        if (wordNum < 1) return new ArrayList<>();
        List<List<String>> res = new ArrayList<>();
        HashMap<String, List<String>> resMap = new HashMap<>();
        char[] tempForSorting;
        String tempStr;
        for (int i = 0; i < wordNum; i ++) {
            tempForSorting = strs[i].toCharArray();
            Arrays.sort(tempForSorting);
            tempStr = String.valueOf(tempForSorting);
            if (!resMap.containsKey(tempStr)) {
                resMap.put(tempStr, new ArrayList<>());
            }
            resMap.get(tempStr).add(strs[i]);
        }
        res = new ArrayList<>(resMap.values());
        return res;
    }

    public static void main(String[] str) {
        S049 solution = new S049();
        List<List<String>> res = solution.groupAnagrams(new String[] {"eat", "tea", "tan", "ate", "nat", "bat"});
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < res.size(); i ++) {
            sb.delete(0, sb.length());
            for (int j = 0; j < res.get(i).size(); j ++) {
                sb.append(res.get(i).get(j) + ' ');
            }
            System.out.println(sb.toString());
        }
    }
}
