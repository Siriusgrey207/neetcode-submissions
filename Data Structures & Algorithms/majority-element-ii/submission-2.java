class Solution {
    public List<Integer> majorityElement(int[] nums) {
        if (nums.length == 1) return Arrays.asList(nums[0]);
        
        // *number in nums* : *frequency* map
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // For each frequency in the map we test if the num appears at least 1/3 of the length of nums
        List<Integer> result = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            int num = entry.getKey();
            int numFreq = entry.getValue();
            if (numFreq > nums.length / 3) result.add(num);
        }

        return result;
    }
}