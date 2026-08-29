class Solution {
    public boolean search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Check if we have found the target.
            if (nums[mid] == target) return true;

            // Check if mid is in the left-sorted portion.
            if (nums[left] < nums[mid]) {
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }

            // Check if mid is in the right-sorted portion.
            } else if (nums[left] > nums[mid]) {
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            // If we can't determine where mid is, move the left pointer.
            } else {
                left++;
            }
        }

        return false;
    }
}