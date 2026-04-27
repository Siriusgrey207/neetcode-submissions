class Solution {
    public int majorityElement(int[] nums) {
        int candidate = nums[0];
        int count = 0;

        for (final int num: nums) {
            if (num == candidate) {
                count++;
                continue;
            }
            count--;
            if (count == -1) {
                candidate = num;
                count = 0;
            }
        }

        return candidate;
    }
}