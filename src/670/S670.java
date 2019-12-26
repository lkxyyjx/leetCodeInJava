import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class S670 {

    public static void main(String args[]) {
        S670 solution = new S670();
        System.out.println(solution.maximumSwap(10));
    }

    public int maximumSwap(int num) {
        int res = 0;
        int quotient = num;
        int reminder = 0;
        Map<Integer, Integer> numMapper = new HashMap<>();
        List<Integer> singleNumArr = new ArrayList<>();
        for (int i = 0; i < 10; i ++ ) {
            numMapper.put(i, 0);
        }

        while(quotient >= 10) {
            reminder = quotient % 10;
            singleNumArr.add(0, reminder);
            numMapper.put(reminder, numMapper.get(reminder) + 1);
            quotient = quotient / 10;
        }
        singleNumArr.add(0, quotient);
        numMapper.put(quotient, numMapper.get(quotient) + 1);

        int pLeft = -1;
        int pRight = -1;
        int numCount = 0;
        int curIndex = 0;
        int rightNum = -1;
        for (int i = 9; i >= 0; i --) {
            numCount = numMapper.get(i);
            for (int j = 0; j < numCount; j ++) {
                if (singleNumArr.get(curIndex) != i) {
                    pLeft = curIndex;
                    rightNum = i;
                    break;
                }
                curIndex ++;
            }
            if (pLeft != -1) break;
        }

        if (pLeft != -1) {
            for (int i = singleNumArr.size() - 1; i >= 0; i --) {
                if (singleNumArr.get(i) == rightNum) {
                    pRight = i;
                    break;
                }
            }

            singleNumArr.set(pRight, singleNumArr.get(pLeft));
            singleNumArr.set(pLeft, rightNum);

            for (int singleNum : singleNumArr) {
                res = singleNum + res * 10;
            }
        } else {
            res = num;
        }


        return res;
    }
}
