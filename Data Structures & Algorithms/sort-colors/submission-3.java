class Solution {
    public void sortColors(int[] nums) {
        if (nums.length == 0) return;

        // 3 pointers indicating different regions
        int left = 0;
        int mid = 0;
        int right = nums.length - 1;

        while (mid <= right) {
            // Case 1: nums[mid] == 0 -> Move mid element to start an increment start.
            if (nums[mid] == 0) {
                this.swap(nums, left, mid);
                left++;
                mid++;
            }
            // Case 2: nums[mid] == 1 -> Don't move mid element, already in correct region.
            // Move mid pointer
            else if (nums[mid] == 1) {
                mid++;
            }
            // Case 3: nums[mid] == 2 -> Swap nums[right] and nums[mid], decrement right pointer.
            else {
                this.swap(nums, mid, right);
                right--;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}