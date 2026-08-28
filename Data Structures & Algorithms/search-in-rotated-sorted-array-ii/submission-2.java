class Solution {
    public boolean search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return true;

            // Mid is in the left-sorted portion.
            if (nums[left] < nums[mid]) {
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            // Mid is in the right-sorted portion.
            else if (nums[left] > nums[mid]) {
                if (nums[mid] < target && target <= nums[mid]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } 
            
            // We can't determine in which portion mid is so we move the left pointer.
            else {
                left++;
            }
        }

        return false;
    }
}