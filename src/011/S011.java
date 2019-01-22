public class S011 {
    public static void main(String[] args) {
        S011 hw = new S011();
        System.out.println(hw.maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }

    public int maxArea(int[] height) {
        int n = height.length;
        int head = 0;
        int tail = n-1;
        int res = 0;
        int area = 0;
        while (head < tail) {
            area = (tail - head) * Math.min(height[head], height[tail]);
            res = area > res ? area : res;
            if (height[head] > height[tail]) {
                tail --;
            } else {
                head ++;
            }
        }
        return res;
    }
}
