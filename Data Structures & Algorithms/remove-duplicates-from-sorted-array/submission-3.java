class Solution {
    public int removeDuplicates(int[] nums) {
        // Initialise a slow and a fast pointer.
        int slow = 0;
        int fast = 0;

        while (fast < nums.length) {
            if (nums[slow] == nums[fast]) {
                fast++;
                continue;
            }
            if (nums[slow] != nums[fast]) {
                nums[slow + 1] = nums[fast];
                fast++;
                slow++;
            }

        }

        return slow + 1;
    }
}