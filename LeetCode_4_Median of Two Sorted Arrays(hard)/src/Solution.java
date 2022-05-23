public class Solution {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 3};
        int[] nums2 = new int[]{2};
        Solution s = new Solution();
        double r = s.findMedianSortedArrays(nums1, nums2);
        System.out.println(r);
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l = nums1.length, r = nums2.length;
        if ((l + r) % 2 != 0) {
            return getKth(nums1, nums2, (l + r) / 2 + 1);
        } else {
            return (getKth(nums1, nums2, (l + r) / 2) + getKth(nums1, nums2, (l + r) / 2 + 1)) / 2.0;
        }
    }

    private int getKth(int[] nums1, int[] nums2, int k) {
        int index1 = 0, index2 = 0;
        while (true) {
            if (nums1.length == index1) {
                return nums2[index2 + k - 1];
            } else if (nums2.length == index2) {
                return nums1[index1 + k - 1];
            }
            if (k == 1) {
                return Math.min(nums1[index1], nums2[index2]);
            }
            int mid = k / 2;
            int newIndex1 = Math.min(index1 + mid, nums1.length) - 1;
            int newIndex2 = Math.min(index2 + mid, nums2.length) - 1;
            if (nums1[newIndex1] < nums2[newIndex2]) {
                k -= newIndex1 - index1 + 1;
                index1 = newIndex1 + 1;
            } else {
                k -= newIndex2 - index2 + 1;
                index2 = newIndex2 + 1;
            }
        }
    }
}
