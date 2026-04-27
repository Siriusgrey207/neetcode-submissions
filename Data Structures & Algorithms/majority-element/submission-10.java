class Solution {
    public int majorityElement(int[] nums) {
        // we initialise two variables, a candidate and its relative occurances.
        int candidate = nums[0];
        int count = 0;

        // we start looping through the list of nums
        for (final int num: nums) {
            if (num == candidate) {
                count++;
            } else {
                count--;
                if (count == -1) {
                    candidate = num;
                    count = 0;
                }
            }
        }

        return candidate;
    }
}