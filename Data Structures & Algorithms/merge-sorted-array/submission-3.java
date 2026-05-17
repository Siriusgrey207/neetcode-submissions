class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // The last index in the nums1 array.
        int lastIndex = m + n - 1;

        // Merge the two sorted arrays in-place of nums1
        while (m > 0 && n > 0) {
            if (nums1[m - 1] > nums2[n - 1]) {
                nums1[lastIndex] = nums1[m - 1];
                m--;
            } else {
                nums1[lastIndex] = nums2[n - 1];
                n--;
            }
            lastIndex--;
        }

        // Add the remaining elements from nums2, into nums1
        while (n > 0) {
            nums1[lastIndex] = nums2[n - 1];
            lastIndex--;
            n--;
        }
    }
}