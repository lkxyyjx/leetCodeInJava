public class S088 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) return;
        if (m == 0) {
            for (int i = 0; i < n; i ++) {
                nums1[i] = nums2[i];
            }
        }
        int pNums1 = m - 1;
        int pNums2 = n - 1;
        int pNewNums = m + n - 1;
        while (pNums1 >= 0 || pNums2 >= 0) {
            if (pNums1 >= 0 && pNums2 >=0) {
                if (nums1[pNums1] < nums2[pNums2]) {
                    nums1[pNewNums --] = nums2[pNums2 --];
                } else {
                    nums1[pNewNums --] = nums1[pNums1 --];
                }
            } else if (pNums1 >= 0) {
                nums1[pNewNums --] = nums1[pNums1 --];
            } else {
                nums1[pNewNums --] = nums2[pNums2 --];
            }
        }
    }
}
