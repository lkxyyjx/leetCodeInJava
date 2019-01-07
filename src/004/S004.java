public class S004 {
    public static void main(String[] args) {
        S004 hw = new S004();
        System.out.println(hw.findMedianSortedArrays(new int[] {1}, new int[] {3,4}));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int p1 = 0;
        int p2 = 0;

        double res;
        boolean isOdd = (len1 + len2) % 2 != 0;
        if (len1 == 0) {
            return isOdd ? nums2[len2/2] : (nums2[len2/2] + nums2[len2/2-1])/2.0;
        }
        if (len2 == 0) {
            return isOdd ? nums1[len1/2] : (nums1[len1/2] + nums1[len1/2-1])/2.0;
        }
        if (isOdd) {
            while (p1 + p2 + 2 <= (len1 + len2 + 1) / 2) {
                if (p1 + 1 < len1 && p2 + 1 < len2) {
                    if (nums1[p1] > nums2[p2]) {
                        p2++;
                    } else if (nums1[p1] < nums2[p2]) {
                        p1++;
                    } else {
                        if (p1 + 1 < len1 && p2 + 1 < len2) {
                            if (nums1[p1 + 1] >= nums2[p2 + 1]) {
                                p2++;
                            } else {
                                p1++;
                            }
                        } else if (p1 + 1 >= len1) {
                            p2++;
                        } else if (p2 + 1 >= len2) {
                            p1++;
                        }
                    }
                } else if (p1 + 1 >= len1) {
                    p2++;
                } else if (p2 + 1 >= len2) {
                    p1++;
                }
            }
        } else {
            while (p1 + p2 + 2 < (len1 + len2 + 2) / 2) {
                if (p1 + 1 < len1 && p2 + 1 < len2) {
                    if (nums1[p1] > nums2[p2]) {
                        p2++;
                    } else if (nums1[p1] < nums2[p2]) {
                        p1++;
                    } else {
                        if (p1 + 1 < len1 && p2 + 1 < len2) {
                            if (nums1[p1 + 1] >= nums2[p2 + 1]) {
                                p2++;
                            } else {
                                p1++;
                            }
                        } else if (p1 + 1 >= len1) {
                            p2++;
                        } else if (p2 + 1 >= len2) {
                            p1++;
                        }
                    }
                } else if (p1 + 1 >= len1) {
                    p2++;
                } else if (p2 + 1 >= len2) {
                    p1++;
                }
            }
        }

        if (p1 + 1 == len1 && p2 - 1 >= 0 && nums2[p2 - 1] > nums1[p1]) {
            res = isOdd ? nums2[p2 - 1] : (nums2[p2 - 1] + nums2[p2])/2.0;
        } else if (p2 + 1 == len2 && p1 - 1 >= 0 && nums1[p1 - 1] > nums2[p2]) {
            res = isOdd ? nums1[p1 - 1] : (nums1[p1 - 1] + nums1[p1])/2.0;
        } else {
            if (isOdd) {
                res = nums1[p1] > nums2[p2] ? nums2[p2] : nums1[p1];
            } else {
                if (nums1[p1] > nums2[p2]) {
                    if (p2 + 1 > len2 - 1 || nums1[p1] < nums2[p2 + 1]) {
                        res = (nums1[p1] + nums2[p2]) / 2.0;
                    } else {
                        res = (nums2[p2] + nums2[p2 + 1]) / 2.0;
                    }
                } else {
                    if (p1 + 1 > len1 - 1 || nums2[p2] < nums1[p1 + 1]) {
                        res = (nums2[p2] + nums1[p1]) / 2.0;
                    } else {
                        res = (nums1[p1] + nums1[p1 + 1]) / 2.0;
                    }
                }
            }
        }
        return res;
    }
}
