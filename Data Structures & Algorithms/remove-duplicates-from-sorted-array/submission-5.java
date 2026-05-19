class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 1) return 1;

        int slow = 0;
        int fast = 0;

        while (fast < nums.length) {
            if (nums[slow] != nums[fast]) {
                nums[slow + 1] = nums[fast];
                slow++;
            }
            fast++;
        }

        return slow + 1;
    }
}