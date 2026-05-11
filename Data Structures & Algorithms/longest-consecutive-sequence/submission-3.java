class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return 1;

        // Step 1: We create a set out of the ints in nums.
        Set<Integer> uniqueNums = new HashSet<>();
        for (int num : nums) {
            if (!uniqueNums.contains(num)) uniqueNums.add(num);
        }

        // Step 2: Create an array from the set of uniqueNums
        int[] uniqueNumsArr = new int[uniqueNums.size()];
        int index = 0;
        for (int num : uniqueNums) {
            uniqueNumsArr[index++] = num; 
        }
        // An array of unique nums has been created.

        int longest = 1;
        for (int i = 0; i < uniqueNumsArr.length; i++) {
            int num = uniqueNumsArr[i];
            // If the current num is not the start of a sequence, move on.
            if (uniqueNums.contains(num - 1)) continue;

            int currentStreak = 1;
            while (uniqueNums.contains(num + 1)) {
                currentStreak++;
                num++;
                longest = Math.max(currentStreak, longest);
            }
        }

        return longest;
    }
}
