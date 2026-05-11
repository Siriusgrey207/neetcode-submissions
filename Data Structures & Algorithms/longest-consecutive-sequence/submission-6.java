class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return 1;

        Set<Integer> uniqueNums = new HashSet<>();
        for (int num : nums) {
            uniqueNums.add(num);
        }

        int longest = 1;
        for (int num : uniqueNums) {
            if (uniqueNums.contains(num + 1)) {
                int currentStreak = 1;
                int currentNum = num;
                while (uniqueNums.contains(currentNum + 1)) {
                    currentStreak++;
                    currentNum++;
                }
                longest = Math.max(currentStreak, longest);
            }
        }

        return longest;
    }
}
