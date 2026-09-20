class Solution {
    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;

        while (true) {
            slow = nums[slow];
            fast = nums[nums[fast]];
            if (slow == fast) break;
        }

        // Now the position of the slow pointer is recorded.
        int slowTwo = 0;
        while (true) {
            slow = nums[slow];
            slowTwo = nums[slowTwo];
            if (slow == slowTwo) break;
        }

        return slow;
    }
}
