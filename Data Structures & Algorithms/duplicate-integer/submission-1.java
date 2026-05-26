class Solution {
    public boolean hasDuplicate(int[] nums) {
        // An *number* : *is present* map
        Map<Integer, Boolean> map = new HashMap<>();

        for (int num : nums) {
            if (map.containsKey(num)) return true;
            map.put(num, true);
        }

        return false;
    }
}