import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class QsortClass {
    public static void main(String[] args) {
        QsortClass solution = new QsortClass();
        int[] input = new int[] {3,7,2,4,6,9};
        solution.qsort(input, 0 ,5);
        for (int num:
             input) {
            System.out.println(num);
        }


    }

    public void qsort(int[] nums, int pLeft, int pRight) {
        if (pLeft >= pRight) return;
        int initialLeft = pLeft;
        int initialRight = pRight;
        if (nums.length < 2) return;
        int key = nums[pLeft];
        while (pRight > pLeft) {
            while (nums[pRight] >= key && pRight > pLeft) pRight--;
            if (pRight > pLeft) {
                nums[pLeft] = nums[pRight];
                pLeft ++;
            }
            while (nums[pLeft] <= key && pRight > pLeft) pLeft++;
            if (pRight > pLeft) {
                nums[pRight] = nums[pLeft];
                pRight --;
            }
        }
        nums[pLeft] = key;
        qsort(nums, initialLeft, pLeft - 1);
        qsort(nums, pRight + 1, initialRight);
    }
}
