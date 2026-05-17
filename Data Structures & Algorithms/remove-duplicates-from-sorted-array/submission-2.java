class Solution {
    public int removeDuplicates(int[] nums) {
        int slow = 0;
        int fast = 0;

        while (fast < nums.length) {
            if (nums[slow] == nums[fast]) {
                fast++;
                continue;
            } else {
                nums[slow + 1] = nums[fast];
                slow++;
            }
        }

        return slow + 1;
    }
}