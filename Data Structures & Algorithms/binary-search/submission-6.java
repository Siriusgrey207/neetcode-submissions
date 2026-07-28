class Solution {
    public int binary_search(int left, int right, int[] nums, int target) {
        if (left > right) return -1;
        int middle = left + (right - left) / 2;

        // Return the middle index if a match is found.
        if (nums[middle] == target) return middle;
        return (nums[middle] < target) ? 
            binary_search(middle + 1, right, nums, target) :
            binary_search(left, middle - 1, nums, target);
    }

    public int search(int[] nums, int target) {
        return binary_search(0, nums.length - 1, nums, target);
    }
}
