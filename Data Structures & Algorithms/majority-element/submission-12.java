class Solution {
    public int majorityElement(int[] nums) {
        // we initialise two variables, a candidate and its relative occurances.
        int candidate = nums[0];
        int count = 0;

        // we start looping through the list of nums
        for (final int num: nums) {
            // If the current num equals the candidate, increment the counter.
            if (num == candidate) {
                count++;
            } 
            // If it doesn't decrement it
            else {
                count--;
                // And if the counter reaches -1, set the candidate to the new current num.
                if (count == -1) {
                    candidate = num;
                    count = 0;
                }
            }
        }
        return candidate;
    }
}