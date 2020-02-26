public class S060 {
    public String getPermutation(int n, int k) {
        StringBuilder res = new StringBuilder();
        int factorial = 1;
        boolean[] used = new boolean[n];
        int sum = 0;
        for (int i = 1; i < n + 1; i ++) {
            factorial *= i;
        }
        int num;
        int validScanTime;
        for (int pos = n; pos > 0; pos --) {
            factorial /= pos;
            validScanTime = 0;
            for (num = 1; num < n + 1; num ++) {
                if (used[num-1]) continue;
                validScanTime ++;
                if (k <= factorial * validScanTime + sum) {
                    res.append(num);
                    used[num-1] = true;
                    break;
                }
            }
            sum += factorial * (validScanTime - 1);
        }
        return res.toString();
    }

    public static void main (String str[]) {
        S060 solution = new S060();
        System.out.println(solution.getPermutation(3,3));
    }
}
