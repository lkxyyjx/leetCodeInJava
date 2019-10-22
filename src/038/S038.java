import java.util.ArrayList;
import java.util.List;

public class S038 {

    public static void main(String[] args) {
        S038 solution = new S038();
        System.out.println(solution.countAndSay(4));
    }

    public String countAndSay(int n) {
        List<String> result = new ArrayList<>();
        if (1 == n) {
            return new String("1");
        }
        result.add(new String("1"));

        String tempStr;
        int tempStrSize;
        int repeatition;
        int pIndex;
        StringBuilder tempResult = new StringBuilder();
        for (int count = 1; count < n; count++) {
            repeatition = 1;
            tempStr = result.get(count - 1);
            tempStrSize = tempStr.length();
            pIndex = 1;
            tempResult.delete(0, tempResult.length());
            while (pIndex < tempStrSize) {
                if (tempStr.charAt(pIndex - 1) == tempStr.charAt(pIndex)) {
                    repeatition ++;
                } else {
                    tempResult.append(Integer.toString(repeatition) + tempStr.charAt(pIndex - 1));
                    repeatition = 1;
                }
                pIndex ++;
            }

            tempResult.append(Integer.toString(repeatition) + tempStr.charAt(pIndex - 1));

            result.add(tempResult.toString());
        }

        return result.get(result.size() - 1);
    }

}
