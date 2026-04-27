class Solution {
    public int majorityElement(int[] nums) {
        // If there is only 1 element, the majority element is obviously that one.
        if (nums.length == 1) return nums[0];

        // Create a map to preserve the frequency information of the ints
        // "integer in nums": "frequency"
        Map<Integer, Integer> numsFrequency = new HashMap<>();

        // Loop through the array and record frequency info
        for (int num: nums) {
            if (numsFrequency.containsKey(num)) {
                numsFrequency.replace(num, numsFrequency.get(num) + 1);
            } else {
                numsFrequency.put(num, 1);
            }
        }

        Set<Integer> numKeys = numsFrequency.keySet();
        for (int key: numKeys) {
            int val = numsFrequency.get(key);
            if (val > (nums.length / 2)) return key;
        }
        return 0;
    }
}