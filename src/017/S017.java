import java.util.*;

public class S017 {
    public static void main(String[] args) {
        S017 solution = new S017();
        System.out.println(solution.letterCombinations("312"));
    }

    public List<String> letterCombinations(String digits) {
        Map<Character, List<Character>> numberChar = new HashMap<>();
        int len = digits.length();
        List<String> res = new ArrayList<>();
        List<String> tempRes = new ArrayList<>();
        if (len < 1) {
            return res;
        }

        numberChar.put('2', new ArrayList<Character>() {{addAll(Arrays.asList('a','b','c'));}});
        numberChar.put('3', new ArrayList<Character>() {{addAll(Arrays.asList('d','e','f'));}});
        numberChar.put('4', new ArrayList<Character>() {{addAll(Arrays.asList('g','h','i'));}});
        numberChar.put('5', new ArrayList<Character>() {{addAll(Arrays.asList('j','k','l'));}});
        numberChar.put('6', new ArrayList<Character>() {{addAll(Arrays.asList('m','n','o'));}});
        numberChar.put('7', new ArrayList<Character>() {{addAll(Arrays.asList('p','q','r','s'));}});
        numberChar.put('8', new ArrayList<Character>() {{addAll(Arrays.asList('t','u','v'));}});
        numberChar.put('9', new ArrayList<Character>() {{addAll(Arrays.asList('w','x','y','z'));}});

        char number;
        for (int i = 0 ; i < len ; i ++) {
            number = digits.charAt(i);
            if (number == '1') {
                continue;
            }
            tempRes.clear();
            tempRes.addAll(res);
            res.clear();
            for (Character singleChar: numberChar.get(number)) {
                if (tempRes.isEmpty()) {
                    res.add("" + singleChar);
                } else {
                    for (String tempString : tempRes) {
                        res.add(tempString + singleChar);
                    }
                }
            }
        }
        return res;
    }
}
