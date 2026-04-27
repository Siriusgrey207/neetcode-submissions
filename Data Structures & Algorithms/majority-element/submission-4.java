class Solution {
    public int majorityElement(int[] nums) {
        int majorityEl = nums[0];
        int count = 0;

        for (final int num: nums) {
            if (num == majorityEl) {
                count++;
            } else {
                count--;
                if (count == -1) {
                    majorityEl = num;
                    count = 0;
                }
            }
        }

        return majorityEl;
    }
}