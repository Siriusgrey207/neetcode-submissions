class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        // Define the left pointer, the running total and the window size.
        int left = 0;
        int total = 0;
        int windowSize = Integer.MAX_VALUE;

        // Start moving the right pointer.
        for (int right = 0; right < nums.length; right++) {
            // On every iteration update the running total.
            total += nums[right];

            // Once we have reached or gone above the target, try to see how small the window can get
            while (total >= target) {
                windowSize = Math.min(right - left + 1, windowSize);
                total -= nums[left];
                left++;
            }
            // The above loop will guarantee we shrink the window as much as possible whilst keeping
            // the running total above the target value.
        }

        return windowSize == Integer.MAX_VALUE ? 0 : windowSize;
    }
}