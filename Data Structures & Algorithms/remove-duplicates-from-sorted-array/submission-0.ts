class Solution {
    /**
     * @param {number[]} nums
     * @return {number}
     */
    removeDuplicates(nums: number[]): number {
        let k = 1;

        let slow = 0;
        let fast = 0;

        while (fast <= nums.length - 1) {
            if (nums[slow] == nums[fast]) {
                fast++;
                continue;
            } else {
                nums[slow + 1] = nums[fast];
                slow++;
                k++;
            }
        }

        return k;
    }
}
