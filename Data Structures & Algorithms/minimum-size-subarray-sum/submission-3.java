class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int total = 0;
        int windowSize = Integer.MAX_VALUE;

        for (int right = 0; right < nums.length; right++) {
            total += nums[right];

            while (total >= target) {
                windowSize = Math.min(right - left + 1, windowSize);
                total -= nums[left];
                left++;
            }
        }

        return windowSize == Integer.MAX_VALUE ? 0 : windowSize;
    }
}