public class S012 {
    public static void main(String[] args) {
        S012 hw = new S012();
        System.out.println(hw.intToRoman(2321));
    }

    public String intToRoman(int num) {
        String[][] romanNumMap = {{"", "M", "MM", "MMM"},
                {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"},
                {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"},
                {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"}};
        int[] dividers = {1000,100,10,1};
        String res = "";
        for (int i = 0; i < 4; i++) {
            res += romanNumMap[i][num/dividers[i]];
            num = num % dividers[i];
        }
        return res;
    }
}
