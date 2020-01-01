public class S042 {
    public static void main(String[] args) {
        S042 solution = new S042();
        System.out.println(solution.trap(new int[] {0,1,0,2,1,0,1,3,2,1,2,1}));
    }

    public int trap(int[] height) {
        //计算非凹图形面积减去高度和即为雨水量
        if (height.length < 2) return 0;
        int bulgeSum = 0;
        int heightSum = 0;
        int maxHeightIndex = 0;
        int maxHeight = 0;
        for (int i = 0; i < height.length; i ++) {
            heightSum += height[i];
            if (height[i] >= maxHeight) {
                maxHeightIndex = i;
                maxHeight = height[i];
            }
        }

        int formerMaxHeight = 0;
        for (int i = 0; i < maxHeightIndex; i ++) {
            if (height[i] > formerMaxHeight) {
                formerMaxHeight = height[i];
            }
            bulgeSum += formerMaxHeight;
            System.out.println(i + "bsum:" + bulgeSum);
        }

        int afterMaxHeight = 0;
        for (int i = height.length - 1; i >= maxHeightIndex; i --) {
            if (height[i] > afterMaxHeight) {
                afterMaxHeight = height[i];
            }
            bulgeSum += afterMaxHeight;
            System.out.println(i + "bsum:" + bulgeSum);
        }
        return bulgeSum - heightSum;
    }
}
