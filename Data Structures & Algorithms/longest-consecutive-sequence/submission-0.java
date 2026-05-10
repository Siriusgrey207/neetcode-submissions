class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return 1;

        // Step 1: Create a set from nums
        Set<Integer> numsSet = new HashSet<>();
        for (int num : nums) {
            if (numsSet.contains(num)) continue;
            numsSet.add(num);
        }

        // Step 2: Create an array of the unique nums from the set.
        int index = 0;
        int[] uniqueNums = new int[numsSet.size()];
        for (int num : numsSet) {
            uniqueNums[index++] = num;
        }

        // Step 3: Find the longest sequence.
        int longest = 0;
        
        // Iterate directly through set
        for (int num : numsSet) {

            // Only start counting if this is the beginning
            // of a sequence
            if (!numsSet.contains(num - 1)) {

                int currentNum = num;
                int currentStreak = 1;

                // Count consecutive numbers
                while (numsSet.contains(currentNum + 1)) {
                    currentNum++;
                    currentStreak++;
                }

                longest = Math.max(longest, currentStreak);
            }
        }

        return longest;
    }
}
